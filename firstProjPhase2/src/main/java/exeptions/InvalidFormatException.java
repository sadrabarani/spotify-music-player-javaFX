package exeptions;

public class InvalidFormatException extends FailedLoginException{
    public InvalidFormatException(String msg){
        super(msg);
    }
    public InvalidFormatException(){
        super("wrong format for phone number or email");
    }
}
