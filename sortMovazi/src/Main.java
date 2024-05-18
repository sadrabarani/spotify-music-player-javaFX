import java.util.Arrays;
import java.util.Random;

public class Main {
    static int th1P = 50;
    static int th2P= 20;
    static int th3P = 30;
    static long startTime = System.currentTimeMillis();
    public static void main(String[] args) {
        int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            array[i] = random.nextInt();
        }
        Threadss threadss=new Threadss(array,0,5000);
        Thread t1 = new Thread(threadss);
        t1.setPriority(Thread.MAX_PRIORITY);

        Threadss threadss2=new Threadss(array,5000,7000);
        Thread t2 = new Thread(threadss2);
        t2.setPriority(Thread.MIN_PRIORITY*4);

        Threadss threadss3=new Threadss(array,7000,10000);
        Thread t3 = new Thread(threadss3);
        t3.setPriority(Thread.MIN_PRIORITY*6);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("All threads " + (System.currentTimeMillis() - startTime) + " mls");
    }
}
class Threadss implements Runnable{
    int[] arr;
    int start;
    int finish;
    public Threadss(int[] arr,int start,int finish) {
        this.arr=arr;
        this.start=start;
        this.finish=finish;
    }
    @Override
    public void run() {
        Arrays.sort(arr,start,finish);
        System.out.println(Thread.currentThread().getName()  + "   %"+ ((finish-start)/100) + "     "+(System.currentTimeMillis() - Main.startTime) + " mls");
    }
}