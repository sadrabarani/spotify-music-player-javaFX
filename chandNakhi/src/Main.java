public class Main {

    public static void main(String[] args) {
        Child c = new Child(400, 1200); //money=400,cost=1200
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
class Child {
    private int cost;
    private int money;

    public Child(int money, int cost) {
        this.cost = cost;
        this.money = money;
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
    }
    synchronized public void add(int amount){
        money+=amount;
        if(money>cost) {
            System.out.println("money is more than price");
            System.out.println("notify all Thread");
            notifyAll();
        }
    }

    public void newWish(int cost) {
        this.cost = cost;
    }
}
