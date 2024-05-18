import java.util.Arrays;

public class Main {
        static double mid,min,first;
    public static void main(String[] args) throws InterruptedException {
        int[] array1 = {2, 1, 3, 4};
        int[] array2 = {2, 3, 22, 1};
        int[] array3 = {11, 2, 3, 4};

        new Thread() {
            @Override
            public void run() {
                int min1 = Integer.MAX_VALUE;
                for (int num : array1) {
                    min1 = Math.min(min1, num);
                }
                min  = min1;
            }
        }.start();
        Thread.sleep(1000);
        new Thread() {
            @Override
            public void run() {
                Arrays.sort(array2);
                int middleIndex = (array2.length-1) / 2;
                mid = (array2[middleIndex]+array2[middleIndex+1])/2.0;
            }
        }.start();
        Thread.sleep(1000);

        new Thread() {
            @Override
            public void run() {
                first = array3[0];
            }
        }.start();
        Thread.sleep(1000);
        double average = (min + mid+ first) / 3.0;
        System.out.println( average);
    }
}