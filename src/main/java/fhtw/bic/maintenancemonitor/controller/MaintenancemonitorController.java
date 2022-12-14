package fhtw.bic.maintenancemonitor.controller;

import fhtw.bic.maintenancemonitor.model.Maintenancemonitor;
import fhtw.bic.maintenancemonitor.service.MaintenancemonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//@RequestMapping(value = "/api")
public class MaintenancemonitorController {

    private static final MaintenancemonitorService mms = new MaintenancemonitorService();
    private static final Maintenancemonitor mm = new Maintenancemonitor(mms.getDefaultStatus(), mms.dateTimeNowString());

    /**
     * @param model model for body of the website
     * @return index
     */
    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("mm", mm);
        return "index";
    }

    /**
     * Mit dieser Funktion kann der Status generell abgefragt werden.
     *
     * @param model Webseitenvorlage die verändert wird
     * @return Website
     */
    @GetMapping("/api/message")
    public String messageIndex(Model model){

        model.addAttribute("mm", mm);
        return "index";
    }

    /**
     * Mit dieser Funktion kann ein Status auf der Webseite gesetzt werden.
     * Die Standardnachricht lautet "Works as expected" welche immer angezeigt wird sofern kein Status gesetzt ist.
     * Wird ein Status gesetzt, wird die Webseite entsprechend angepasst. Sie wird rot und die Statusnachricht wird ergänzt.
     * Es ist jedoch auch möglich die Webseite mit der entsprechend gesetzten Nachricht zu setzen, wenn man lediglich localhost:8080 aufruft
     *
     * @param message Nachricht die eingegeben wird (Bspw. "Maintenance Work until 05:00am)
     * @param model Webseitenvorlage die verändert wird
     * @return Website
     */
    @GetMapping("/api/message/set")
    public String setMessage(@RequestParam(name="m", required=false, defaultValue=MaintenancemonitorService.defaultStatus) String message, Model model){

        mm.setStatus(message);
        mm.setStatusDateTime(mms.dateTimeNowString());

        mm.setErrorPage(!message.equals(mms.getDefaultStatus()));

        model.addAttribute("mm", mm);
        //model.addAttribute("title", "Test-Title");

        return "index";
    }


    /**
     * Mit dieser Funktion kann die Statusnachricht wieder auf den Standard zurückgesetzt werden.
     * Der Service-Mitarbeiter gibt den Kunden hiermit bekannt, dass alles wieder funktioniert.
     * @param model Webseitenvorlage die verändert wird
     * @return Website
     */
    @GetMapping("/api/message/reset")
    public String resetMessage(Model model){

        mm.setStatus(mms.getDefaultStatus());
        mm.setStatusDateTime(mms.dateTimeNowString());
        mm.setErrorPage(false);

        model.addAttribute("mm", mm);
        //model.addAttribute("title", "Test-Title");

        return "index";
    }

}
