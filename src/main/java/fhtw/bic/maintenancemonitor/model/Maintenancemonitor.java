package fhtw.bic.maintenancemonitor.model;

import fhtw.bic.maintenancemonitor.service.MaintenancemonitorService;

import java.time.LocalDateTime;

public class Maintenancemonitor {

    private String status;
    private String statusDateTime;
    private boolean isErrorPage;

    public Maintenancemonitor(){
    };

    public Maintenancemonitor(String status, String statusDateTime){
        this.status = status;
        this.statusDateTime = statusDateTime;
        this.isErrorPage = false;
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDateTime() {
        return statusDateTime;
    }

    public void setStatusDateTime(String statusDateTime) {
        this.statusDateTime = statusDateTime;
    }

    public boolean isErrorPage() {
        return isErrorPage;
    }

    public void setErrorPage(boolean errorPage) {
        isErrorPage = errorPage;
    }
}
