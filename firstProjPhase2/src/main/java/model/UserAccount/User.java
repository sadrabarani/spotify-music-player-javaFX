package model.UserAccount;
import model.SubscriptionPlan;

import java.util.Date;
abstract public class User {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private SubscriptionPlan subscription;
    private User user;
    private boolean isLogin;

    public User(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        isLogin=true;
    }

    @Override
    public String toString(){
        StringBuilder result=new StringBuilder("name : ");
        result.append(fullName).append(" phone number : ").append(phoneNumber).append(" email : ").append(email).append(" user name : ").append(username);
        return String.valueOf(result);
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean login) {
        isLogin = login;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public SubscriptionPlan getSubscription() {
        return subscription;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSubscription(SubscriptionPlan subscription) {
        this.subscription = subscription;
    }
}
