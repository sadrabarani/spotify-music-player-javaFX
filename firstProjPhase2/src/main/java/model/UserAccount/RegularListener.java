package model.UserAccount;

import java.util.Date;

public class RegularListener extends Listener{
    final private int playListLimit;
    final private int addLimit;

   // public RegularListener(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth) {
    //    super(username, password, fullName, email, phoneNumber, dateOfBirth);
    //}


    public RegularListener(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth, int credit) {
        super(username, password, fullName, email, phoneNumber, dateOfBirth, credit);
        this.playListLimit = 3;
        this.addLimit = 10;
    }
    @Override
    public String toString() {
        return super.toString()+"\n"+"addLimit"+addLimit;
    }
    public int getPlayListLimit() {
        return playListLimit;
    }

    public int getAddLimit() {
        return addLimit;
    }
}
