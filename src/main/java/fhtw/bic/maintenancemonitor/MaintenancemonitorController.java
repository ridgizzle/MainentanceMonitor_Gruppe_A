package fhtw.bic.maintenancemonitor;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MaintenancemonitorController {
    public static String message = "default message";

    public String index(Model model) {
        formHandler();
        displayMessage();
        return "form";
    }
    @ResponseBody
    @RequestMapping(value = "message")
    public String displayMessage(){
        return message;
    }
    @RequestMapping (method = RequestMethod.GET)
    @ResponseBody
    public String formHandler(){
        String html = "<form method ='post'>" +                     //nach post kann um eine Url erweitert werden action='someURL' --> wie Weblink
                "<input type='text' name='name' />" +               //name ist der Parametername der in postHandler initiert wird
                "<input type='submit' value='Submit message' />" +
                "</form>";                                                //closes form
        return html;
    }
    @RequestMapping (method = RequestMethod.POST)
    @ResponseBody
    public String postHandler(HttpServletRequest request){
        message = request.getParameter("name");
        return formHandler();
    }
}
