package fhtw.bic.maintenancemonitor.controller;

import fhtw.bic.maintenancemonitor.model.Maintenancemonitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/api")
public class MaintenancemonitorController {

    private Maintenancemonitor mm = new Maintenancemonitor();

    @GetMapping("/")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/message/set")
    public String setMessage(@RequestParam(name="m", required=false, defaultValue="Everything works as expectedy") String message, Model model){

        LocalDateTime dateTime = LocalDateTime.now();
        mm.setStatus(message);
        mm.setStatusDate(dateTime);

        model.addAttribute("mm", mm);
        model.addAttribute("title", "Test-Title");

        return "index";
    }


    @GetMapping("/message/reset")
    public String resetMessage(Model model){

        LocalDateTime dateTime = LocalDateTime.now();

        mm.setStatus("Everything works as expected");
        mm.setStatusDate(dateTime);

        model.addAttribute("mm", mm);
        model.addAttribute("title", "Test-Title");

        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "api/greeting";
    }
}
