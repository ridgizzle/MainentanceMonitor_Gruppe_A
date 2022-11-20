package fhtw.bic.maintenancemonitor.controller;

import fhtw.bic.maintenancemonitor.model.Maintenancemonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.View;
import java.sql.Date;
import java.time.LocalDateTime;

@Controller
//@RequestMapping(value = "/api/message")
public class MaintenancemonitorController {

    private Maintenancemonitor mm = new Maintenancemonitor();

    @GetMapping("/api/message/set")
    //@ResponseBody
    public ModelAndView setMessage(@RequestParam(name="m", required=false, defaultValue="Everything works as expected") String message){

        mm.setStatus(message);

        ModelAndView mv = new ModelAndView();
        mv.addObject(mm.getStatus(), mm);
        mv.setViewName("/");
        //mm.setStatus(message);
        //return mm.setMessage(message);
        return mv;
    }

/*
    @RequestMapping(value = "/api")
    public String returnView(){
        return "/";
    }
*/

    @GetMapping("/api/message/reset")
    //@ResponseBody
    public String resetMessage(Model model){

        LocalDateTime dateTime = LocalDateTime.now();

        mm.setStatus("Everything works as expected");
        mm.setStatusDate(dateTime);

        model.addAttribute("mm", mm);
        //model.addAttribute("statusDateTime", mm.getStatusDate());
        //return mm.setMessage(message);
        return "/";
        //return mm.setStatus("Everything works as expected");
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
