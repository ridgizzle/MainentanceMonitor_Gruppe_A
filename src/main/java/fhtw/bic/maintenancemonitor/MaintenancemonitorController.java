package fhtw.bic.maintenancemonitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenancemonitorController {

    private Maintenancemonitor rechner = new Maintenancemonitor();

    @GetMapping("/api/message")
    public long addNumbers(@RequestParam(name="numberOne") int numberOne, @RequestParam(name="numberTwo") int numberTwo){
        //return rechner.add(numberOne, numberTwo);
        return 1;
    }
}
