package fhtw.bic.maintenancemonitor.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MaintenancemonitorService {

    public static final String defaultStatus = "Everything works as expected";

    public String dateTimeNowString(){
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return dateTime.format(formatter);
    }

    public String getDefaultStatus(){
        return this.defaultStatus;
    }
}
