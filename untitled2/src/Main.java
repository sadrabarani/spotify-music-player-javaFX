import java.awt.datatransfer.FlavorListener;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("13/02/2022", formatter);
        Flight f1=null,f2=null,f3=null;
        try {
            f1 = new Flight(date, LocalTime.parse("23:00"), "isfahan", "tehran",
                    320.5, 55, 780.3, 2);
            f2 = new Flight(date, LocalTime.parse("21:00"), "isfahan", "mashhad", 900d, 110, 1570.5, 50);
            f3 = new Flight(date, LocalTime.parse("23:00"), "isfahan", "tehran", 320.5, 55, 780.3, 87);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }


        String name1 = sc.next();
        String name2 = sc.next();

        String phone1 = sc.next();
        String phone2 = sc.next();

        String email1 = sc.next();
        String email2 = sc.next();

        double balance1 = sc.nextDouble();
        double balance2 = sc.nextDouble();
        try {
            Passenger p1 = new Passenger(name1, phone1, email1, balance1);
            Passenger p2 = new Passenger(name2, phone2, email2, balance2);
            Passenger p3 = new Passenger("ali", "9301112233", "abc@gmail.com", 2000.5);
            Passenger p4 = new Passenger("zahra", "989301112233", "abcgl.com", 3000d);

            p1.reserveFlight(f1);
            p1.reserveFlight(f2);

            p2.reserveFlight(f3);
            p2.reserveFlight(f2);

            p3.reserveFlight(f1);
            p3.reserveFlight(f3);

            p4.reserveFlight(f1);
            p4.reserveFlight(f2);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

class Flight {
    private LocalDate date;
    private LocalTime time;
    private ArrayList<Passenger> passengers;
    private String origin;
    private String destination;
    private double distance;
    private int duration;
    private int speed;
    private double cost;
    private int capacity;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public int getSpeed() {
        return speed;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public Flight(LocalDate date, LocalTime time, String origin, String destination, double distance, int duration, double cost, int capacity) {
            this.date = date;
            this.time = time;
            this.destination = destination;
            this.distance = distance;
            this.duration = duration;
            if(duration == 0)
                throw new ArithmeticException("zero");
            this.speed = (int)distance / duration;
            this.passengers = new ArrayList<>();
            this.origin = origin;
            this.cost = cost;
            this.capacity = capacity;
    }
}

class Passenger {
    private String name;
    private String phoneNumber;
    private String email;
    private double balance;
    private ArrayList<Flight> flights;

    public Passenger(String name, String phoneNumber, String email, double balance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
        checkEmail(email);
        checkPhone(phoneNumber);
        checkInitialBalance(balance);
    }

    private void checkEmail(String email) {
        if(!Regex.emailRegex(email))
            throw new InvalidEmailException("Email invalid");
    }

    private void checkPhone(String phone) {
        if(!Regex.phoneRegex(phone))
            throw new InvalidPhoneException("Phone num invalid");
    }

    private void checkInitialBalance(double balance) {
        if(balance < 0)
            throw new InvalidBalanceException("balance is invalid");
    }

    public void reserveFlight(Flight flight) {
        if(flights.size() > 0)
            if(!flights.get(flights.size()-1).getDestination().equals(flight.getOrigin()))
            throw new DestenationConflictException("Dest Shit");
        if(Double.valueOf(balance) < this.balance)
            throw new NotEnoughBalanceException("Shit");
        for(Flight tmpFlight : flights) {
            if(flight.getTime().getSecond() - tmpFlight.getTime().getSecond() < 7200) throw new TimeConflictException("Time conflict");
        }
        for(Flight tmpFlight : flights) {
            if(flight.getDestination().equals(tmpFlight.getDestination()))
                throw new DestenationConflictException("Dest conflict");
        }
        if(flight.getCapacity() <= flight.getPassengers().size())
            throw new IndexOutOfBoundsException("Index out of bounds ");
        flights.add(flight);
    }
}

class  InvalidInfoExeption extends RuntimeException{
    public InvalidInfoExeption(String string){
        super(string);
    }
}
class InvalidEmailException extends InvalidInfoExeption {
    public InvalidEmailException(String string) {
        super(string);
    }
}
class InvalidPhoneException extends InvalidInfoExeption {
    public InvalidPhoneException(String string) {
        super(string);
    }
}
class NotEnoughBalanceException extends InvalidInfoExeption {
    public NotEnoughBalanceException(String string) {
        super(string);
    }
}

class ReservationExetion extends RuntimeException {
    public ReservationExetion(String string) {
        super(string);
    }
}

class InvalidBalanceException extends ReservationExetion {
    public InvalidBalanceException(String string) {
        super(string);
    }
}

class TimeConflictException extends ReservationExetion {
    public TimeConflictException(String string) {
        super(string);
    }
}

class DestenationConflictException extends ReservationExetion {
    public DestenationConflictException(String string) {
        super(string);
    }
}
class Regex {
    public static boolean phoneRegex(String phoneNumber) {
        Pattern pattern = Pattern.compile("^98+\\d{12}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean emailRegex(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._+-]+@[a-zA-Z0-9._]+\\.[a-zA-z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}