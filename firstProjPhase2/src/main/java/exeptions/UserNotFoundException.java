package exeptions;

public class UserNotFoundException extends FailedLoginException{
    public UserNotFoundException(String msg){
        super(msg);
    }
    public UserNotFoundException(){
        super("user not found!");
    }
}
