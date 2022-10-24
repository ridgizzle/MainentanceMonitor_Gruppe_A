package fhtw.bic.maintenancemonitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenancemonitorController {

    private Maintenancemonitor mm = new Maintenancemonitor();

    @GetMapping("/api/message/set")
    public String setMessage(@RequestParam(name="m", required=false, defaultValue="Everything works as expected") String message){
        return mm.setMessage(message);
    }
}
