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
        return mm.setMessage("Everything works not expected");
    }

    @GetMapping("/api/greeting")
    public String maintenanceUntil(@RequestParam(name="time", required=false, defaultValue="00:00") String time,
                                   @RequestParam(name="am_pm", required=false, defaultValue="am") String am_pm) {

        return "Service checks: No power until " + time + am_pm;
    }



}
