package model.UserAccount;

import java.util.Date;

public class Admin extends User {
    private static Admin admin;
    @Override
    public String toString() {
        return super.toString();
    }
    private Admin(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth) {
        super(username, password, fullName, email, phoneNumber, dateOfBirth);
    }

    public static Admin getAdmin(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth) {
        if (admin == null) {
            admin = new Admin(username, password, fullName, email, phoneNumber, dateOfBirth);
        }
            return admin;
    }
}
