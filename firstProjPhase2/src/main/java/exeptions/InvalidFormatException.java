package exeptions;

public class InvalidFormatException extends FailedLoginException{
    InvalidFormatException(String msg){
        super(msg);
    }
    InvalidFormatException(){
        super("wrong format for phone number or email");
    }
}
