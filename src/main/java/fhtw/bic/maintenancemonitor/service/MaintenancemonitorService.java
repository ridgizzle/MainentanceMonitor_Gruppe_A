package fhtw.bic.maintenancemonitor.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Service for maintenenaceMonitor with default status "Everything works as expected"
 */
@Service
public class MaintenancemonitorService {

    public static final String defaultStatus = "Everything works as expected";

    /**
     * @return returns current datetime as string
     */
    public String dateTimeNowString(){
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return dateTime.format(formatter);
    }

    /**
     * @return returns default status message
     */
    public String getDefaultStatus(){
        return this.defaultStatus;
    }
}
