package fhtw.bic.maintenancemonitor.model;

import fhtw.bic.maintenancemonitor.service.MaintenancemonitorService;

import java.time.LocalDateTime;

/**
 * Model for the body of the website - is used to set the status, date of last status change and error indicator
 */
public class Maintenancemonitor {

    private String status;
    private String statusDateTime;
    private boolean isErrorPage;

    public Maintenancemonitor(){
    };

    /**
     * @param status status of the maintenance
     * @param statusDateTime current date
     */
    public Maintenancemonitor(String status, String statusDateTime){
        this.status = status;
        this.statusDateTime = statusDateTime;
        this.isErrorPage = false;
    };

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status set status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return returns the status date time
     */
    public String getStatusDateTime() {
        return statusDateTime;
    }

    /**
     * @param statusDateTime sets status date time
     */
    public void setStatusDateTime(String statusDateTime) {
        this.statusDateTime = statusDateTime;
    }

    /**
     * @return returns indicator if page should change to status "error"
     */
    public boolean isErrorPage() {
        return isErrorPage;
    }

    /**
     * @param errorPage sets indicator if page should change to status "error"
     */
    public void setErrorPage(boolean errorPage) {
        isErrorPage = errorPage;
    }
}
