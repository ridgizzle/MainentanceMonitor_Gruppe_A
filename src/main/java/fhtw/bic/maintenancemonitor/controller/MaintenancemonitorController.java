package fhtw.bic.maintenancemonitor.controller;

import fhtw.bic.maintenancemonitor.model.Maintenancemonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;
import java.sql.Date;
import java.time.LocalDateTime;
@RestController
public class MaintenancemonitorController {
    public static String message = "default message";

    public String index(Model model) {
        formHandler();
        displayMessage();
        return "form";
    }

    /**
     * Von dieser Funktion wird die HTML Seite zurückgegeben.
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "message")
    public String displayMessage(){
        String string = String.format("<span id=\"monitorStatus\" style=\"font-size:24px; font-family:'Calibri'\">  %s </span>\n", message);

        String html = "<!DOCTYPE HTML>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <title>Maintenance Monitor</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "    <style>\n" +
                "\n" +
                "        body{\n" +
                "            background: linear-gradient(90deg, rgba(255,255,255,1) 0%, rgba(133,250,162,1) 50%, rgba(255,255,255,1) 100%);\n" +
                "        }\n" +
                "\n" +
                "        .center{\n" +
                "            position: absolute;\n" +
                "            top: 50%;\n" +
                "            width: 100%;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"mainBox\">\n" +
                "    <div class=\"center\">\n" +
                "        <span id=\"monitorHeader\" style=\"font-size:36px; font-weight: bold; font-family:'Calibri'\">Maintenance Monitor</span>\n" +
                "        <br />\n" +
                string +
                "        <br />\n" +
                "        <br />\n" +
                "        <span id=\"monitorLastUpdate\" style=\"font-size:12px; font-weight: bold; font-family:'Calibri'\">last update: 1900-01-01</span>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return html;
    }

    /**
     * Diese Klasse erstellt das Formular mit dem die Daten der Hauptseite manipuliert werden können
     * @return
     */
    @RequestMapping (method = RequestMethod.GET)
    @ResponseBody
    public String formHandler(){
        String html = "<form method ='post'>" +                     //nach post kann um eine Url erweitert werden action='someURL' --> wie Weblink
                "<input type='text' name='name' />" +               //name ist der Parametername der in postHandler initiert wird
                "<input type='submit' value='Submit message' />" +
                "</form>";                                                //closes form
        return html;
    }

    /**
     * In der Methode formHandler() wird der Name in einer Textbox eingeben. In dieser Methode wird die Variable "name" in den String
     * "message" gelegt. Der String message wird dann von der Funktion displayMessage() verwendet um die HTML-Seite entsprechend mit dem String zu versehen
     * @param request
     * @return
     */
    @RequestMapping (method = RequestMethod.POST)
    @ResponseBody
    public String postHandler(HttpServletRequest request){
        message = request.getParameter("name");
        return formHandler();
    }
}