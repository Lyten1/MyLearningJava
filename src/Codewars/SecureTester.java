package Codewars;

public class SecureTester {

    public static boolean alphanumeric(String s){
        if(s == null || s.length() < 1)
            return false;
        String regSpaceUnder = "[\s]|[_]+";
        String regex = "([A-Z, a-z, 0-9])\\w+";
        System.out.println(s);
        if(s.matches(regSpaceUnder)) return false;
        if(s.matches(regex)) return true;
        return false;
    }
}
