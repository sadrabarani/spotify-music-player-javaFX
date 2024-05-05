package exeptions;

public class FreeAccountLimitException extends Exception{
    public FreeAccountLimitException (){
        super("play list limit error . buy premium");
    }
    public FreeAccountLimitException (String msg){
        super(msg);
    }
}
