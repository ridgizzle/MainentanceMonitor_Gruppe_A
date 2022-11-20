package fhtw.bic.maintenancemonitor.Model;

import java.time.LocalDateTime;

public class Maintenancemonitor {

    private String status;
    private LocalDateTime statusDateTime;

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
        return statusDateTime;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDateTime = statusDate;
    }

}
