package fhtw.bic.maintenancemonitor.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Maintenancemonitor {

    private String status;
    private LocalDateTime statusDate;

    public Maintenancemonitor(){};


    public String setMessage(String message){

        return message;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

}
