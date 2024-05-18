public class Main{
    static StringBuilder str = new StringBuilder();
    static int num=0;
    static Object ob=new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread("th1"){
            @Override
            public void run(){
                counter(Thread.currentThread().getName());
            }
        };
        Thread thread2 = new Thread("th2"){
            @Override
            public void run(){
                counter(Thread.currentThread().getName());
            }
        };
        Thread thread3 = new Thread("th3"){
            @Override
            public void run(){
                counter(Thread.currentThread().getName());
            }
        };
        Thread thread4 = new Thread("th4"){
            @Override
            public void run(){
                counter(Thread.currentThread().getName());
            }
        };
        Thread thread5 = new Thread("th5"){
            @Override
            public void run(){
                counter(Thread.currentThread().getName());
            }
        };
        Thread thread6 = new Thread("th6"){
            @Override
            public void run(){
                counter(Thread.currentThread().getName());
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        System.out.println(str);
    }
    private static void counter(String threadName) {
        long count = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < 200000; ++i) {
            for (int j = 0; j < 200000; ++j) {
                count++;
            }
        }
        long end = System.currentTimeMillis();
        synchronized (ob) {
            num++;
            str = str.append(threadName).append(" ").append(num).append(" ").append(end - start).append("\n");
        }
    }
}