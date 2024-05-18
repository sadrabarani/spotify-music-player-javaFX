public class Main {
    public static void main(String[] args) {
        Father father=new Father();
        new Thread() {
            @Override
            public void run() {
                father.buy();
            }
        }.start();

        Child c = new Child(400, 1200,father); //money=400,cost=1200
        new Thread() {
            @Override
            public void run() {
                c.buy();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.add(500);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.add(500);
            }
        }.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.getMoney());
        c.newWish(2000);
    }
}
class Child extends Father{
    private int cost;
    private int money;
    private Father father;
    public Child(int money, int cost,Father father) {
        this.cost = cost;
        this.money = money;
        this.father=father;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    synchronized public void buy(){
        System.out.println("buy method is runing");
        if(cost>money) {
            try {
                System.out.println("money is not enough");
                System.out.println("Buy Thread is going to wait ");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        money-=cost;
        synchronized (ob) {
            ob.notify();
        }
    }
    synchronized public void add(int amount){
        money+=amount;
        if(money>cost) {
            System.out.println("money is more than price");
            System.out.println("notify all Thread");
            notify();
        }
    }

    public void newWish(int cost) {
        this.cost = cost;
    }
}

class Father{
    static Object ob=new Object();
    public void buy(){
        try {
            synchronized (ob) {
                ob.wait();
            }
            System.out.println("father wake up");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}