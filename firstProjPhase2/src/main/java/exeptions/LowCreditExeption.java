package exeptions;

public class LowCreditExeption extends RuntimeException{
    public LowCreditExeption (String msg){
        super(msg);
    }
    public LowCreditExeption(){
        super("you dont have enough credit");
    }
}
