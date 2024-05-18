import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int listSize = 10000;
        int[] toWithdraw = new int[listSize];
        int[] toDeposit = new int[listSize];
        int result=10000;
        for (int i = 0; i < listSize; i++) {
            toWithdraw[i] = random.nextInt(500);
            toDeposit[i] = random.nextInt(500);
            result+= toDeposit[i] - toWithdraw[i];
        }

        Account account = new Account(10000);

        Thread depositThread = new DepositThread(account, toDeposit);
        Thread withdrawThread = new WithdrawThread(account, toWithdraw);

        depositThread.start();
        withdrawThread.start();
        depositThread.join();
        withdrawThread.join();
        System.out.println("Threads finished");
        System.out.println("Starting test");
        System.out.println("Final balance is : " + account.getBalance());
    }
}
class Account {
    private int balance;
    private static Object obj=new Object();
    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        synchronized (obj) {
            balance += amount;
        }
        System.out.println("Deposited " + amount);
    }

    public synchronized void withdraw(int amount) {
        synchronized (obj) {
            balance -= amount;
        }
        System.out.println("Withdrew " + amount);
    }

    public int getBalance() {
        return balance;
    }
}
class DepositThread extends Thread {
    private Account account;
    private int[] depositAmount;

    public DepositThread(Account account, int[] depositAmount) {
        this.account = account;
        this.depositAmount = depositAmount;
    }

    public Account getAccount() {
        return account;
    }

    public int[] getDepositAmount() {
        return depositAmount;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setDepositAmount(int[] depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int amount : depositAmount) {
            account.deposit(amount);
        }
    }
}
class WithdrawThread extends Thread {
    private Account account;
    private int[] withdrawAmounts;

    public WithdrawThread(Account account, int[] withdrawAmounts) {
        this.account = account;
        this.withdrawAmounts = withdrawAmounts;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setWithdrawAmounts(int[] withdrawAmounts) {
        this.withdrawAmounts = withdrawAmounts;
    }

    public Account getAccount() {
        return account;
    }

    public int[] getWithdrawAmounts() {
        return withdrawAmounts;
    }

    @Override
    public void run() {
        for (int amount : withdrawAmounts) {
            account.withdraw(amount);
        }
    }
}
