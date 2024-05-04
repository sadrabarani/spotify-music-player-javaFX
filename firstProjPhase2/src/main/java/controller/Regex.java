package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public Regex() {
    }

    public static Regex getRegex1() {
        if (regex1 == null)
            regex1=new Regex();
        return regex1;
    }

    private static Regex regex1;
    public static boolean phoneRegex(String phoneNumber) {
        Pattern pattern = Pattern.compile("^09+\\d{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean emailRegex(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._+-]+@[a-zA-Z0-9._]+\\.[a-zA-z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean passwordRegex(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+-=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
