import java.util.*;
import java.util.EmptyStackException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        XPCON xpcon = new XPCON();

        for (int i = 0; i < n; i++) {
            String studentID = scanner.nextLine();
            String fullName = scanner.nextLine();
            if(!xpcon.signStudent(studentID, fullName)){
            }
        }
        while (scanner.hasNext()){
            xpcon.fillQueue(scanner.nextLine());
        }
        System.out.println(xpcon);
    }
}


class XPCON {
    private Queue<String> studentQueue;
    private Map<String, String> studentsName;
    private TreeSet<String> idStudents;

    public XPCON() {
        studentQueue =new LinkedList<>();
        studentsName= new HashMap<>();
        idStudents = new TreeSet<>();
    }
    public boolean signStudent(String id,String name){
        if(idStudents.contains(id))
            return false;
        idStudents.add(id);
        studentsName.put(id,name);
        return true;
    }
    public void fillQueue(String id1) {
        studentQueue.add(id1);
    }
    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        for (String str1:studentQueue){
            str.append(str1).append("\n");
            str.append(studentsName.get(str1)).append("\n");
        }
        return String.valueOf(str);
    }
}
/*
5
1100
ali vaziri
1101
reza kiani
1102
hasan zamani
1100
bb
1103
saman mohtasham
1102
1101
1100
1103
 */