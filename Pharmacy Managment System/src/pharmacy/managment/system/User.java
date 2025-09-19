package pharmacy.managment.system;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class User {
	
    private int userId;
    private String userName;
    private String userType;

    public User() {}
    
    public User(int userId, String userName, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userType=" + userType + '}';
    }
    
    
	
	
}