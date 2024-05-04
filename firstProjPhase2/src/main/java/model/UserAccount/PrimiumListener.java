package model.UserAccount;

import java.util.Date;

public class PrimiumListener extends Listener {
    private int numOfSub;


    public PrimiumListener(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth, int credit) {
        super(username, password, fullName, email, phoneNumber, dateOfBirth, credit);
    }
    @Override
    public String toString() {
        return super.toString()+"\n"+"you have "+numOfSub+" until your subscription plan edned";
    }
    public void setNumOfSub(int numOfSub) {
        this.numOfSub = numOfSub;
    }

    public int getNumOfSub() {
        return numOfSub;
    }
}
