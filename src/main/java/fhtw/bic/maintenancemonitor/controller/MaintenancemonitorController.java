package fhtw.bic.maintenancemonitor.controller;

import fhtw.bic.maintenancemonitor.model.Maintenancemonitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.View;
import java.sql.Date;
import java.time.LocalDateTime;

@Controller
//@RequestMapping(value = "/api/message")
public class MaintenancemonitorController {

    private Maintenancemonitor mm = new Maintenancemonitor();

    @GetMapping("/api/message/set")
    //@ResponseBody
    public String setMessage(@RequestParam(name="m", required=false, defaultValue="Everything works as expected") String message, Model model){

        LocalDateTime dateTime = LocalDateTime.now();
        mm.setStatus(message);
        mm.setStatusDate(dateTime);

        model.addAttribute("mm", mm);
        model.addAttribute("title", "Test-Title");
        //mm.setStatus(message);
        //return mm.setMessage(message);
        return "index";
    }

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/api/message/reset")
    //@ResponseBody
    public String resetMessage(Model model){

        LocalDateTime dateTime = LocalDateTime.now();

        mm.setStatus("Everything works as expected");
        mm.setStatusDate(dateTime);

        model.addAttribute("mm", mm);
        model.addAttribute("title", "Test-Title");
        //model.addAttribute("statusDateTime", mm.getStatusDate());
        //return mm.setMessage(message);
        return "index";
        //return mm.setStatus("Everything works as expected");
    }

    @GetMapping("/api/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "api/greeting";
    }
}
