package pharmacy.managment.system;


import java.util.Date;


public abstract class Report {
    
    private String reportType;
    private Date creationDate;

    public Report(String reportType, Date creationDate) {
        this.reportType = reportType;
        this.creationDate = creationDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public abstract void generateReport();  

    
}