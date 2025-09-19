package pharmacy.managment.system;


import java.util.ArrayList;
import java.util.Date;


public class UserReport extends Report {
    private ArrayList<User> users;

    public UserReport(String reportType, Date creationDate, ArrayList<User> users) {
        super(reportType, creationDate);
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public void generateReport() {
        System.out.println("Generating User Report...");
    }

}