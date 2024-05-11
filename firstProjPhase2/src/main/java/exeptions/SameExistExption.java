package exeptions;

public class SameExistExption extends RuntimeException {
    public SameExistExption (String msg){
        super(msg);
    }
    public SameExistExption (){
        super(" same thing exist!!");
    }
}
