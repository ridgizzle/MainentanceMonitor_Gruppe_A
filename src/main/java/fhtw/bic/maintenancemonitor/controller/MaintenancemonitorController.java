package fhtw.bic.maintenancemonitor.controller;

import fhtw.bic.maintenancemonitor.model.Maintenancemonitor;
import fhtw.bic.maintenancemonitor.service.MaintenancemonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//@RequestMapping(value = "/api")
public class MaintenancemonitorController {

    private static MaintenancemonitorService mms = new MaintenancemonitorService();
    private static Maintenancemonitor mm = new Maintenancemonitor(mms.getDefaultStatus(), mms.dateTimeNowString());

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("mm", mm);
        return "index";
    }

    @GetMapping("/api/message")
    public String messageIndex(Model model){

        model.addAttribute("mm", mm);
        return "index";
    }


    @GetMapping("/api/message/set")
    public String setMessage(@RequestParam(name="m", required=false, defaultValue=MaintenancemonitorService.defaultStatus) String message, Model model){

        mm.setStatus(message);
        mm.setStatusDateTime(mms.dateTimeNowString());

        if(!message.equals(mms.getDefaultStatus()))
            mm.setErrorPage(true);
        else
            mm.setErrorPage(false);

        model.addAttribute("mm", mm);
        //model.addAttribute("title", "Test-Title");

        return "index";
    }


    @GetMapping("/api/message/reset")
    public String resetMessage(Model model){

        mm.setStatus(mms.defaultStatus);
        mm.setStatusDateTime(mms.dateTimeNowString());
        mm.setErrorPage(false);

        model.addAttribute("mm", mm);
        //model.addAttribute("title", "Test-Title");

        return "index";
    }

}
