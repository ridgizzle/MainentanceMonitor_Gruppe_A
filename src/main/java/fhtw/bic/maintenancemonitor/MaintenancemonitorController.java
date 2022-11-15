package fhtw.bic.maintenancemonitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
public class MaintenancemonitorController {

    private Maintenancemonitor mm = new Maintenancemonitor();


    @GetMapping("/api/message/set")
    public String setMessage(@RequestParam(name="m", required=false, defaultValue="Everything works as expected") String message){
        return mm.setMessage(message);
    }

    @GetMapping("/api/message/reset")
    public String setMessage(){
        return mm.setMessage("Everything works as expected");
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
