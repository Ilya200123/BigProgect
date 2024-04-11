import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checking {
    public static boolean RegulStaticSurname3 (String data) {
        String str = data;
        Pattern pattern = Pattern.compile("^[^.,\\s]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean RegulStaticSurname (String data){
        String str = data;
        Pattern pattern = Pattern.compile("^([^\\s,]+),[^\\s,]+(?:,[^\\s,]+)*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean RegulStaticSurname2 (String surname) {
        String s = surname;
        String str = s;
        Pattern pattern = Pattern.compile("^\\s*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }



    public static boolean RegulStatic (String data){
        String str = data;
        Pattern pattern = Pattern.compile("^([\\p{L}\\s]+)(?:,[\\p{L}\\s]+)*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    public static boolean RegulStatic2 (String surname) {
        String s = surname;
        String str = s;
        Pattern pattern = Pattern.compile("^\\s*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean RegulCreate(String data){
        String s = data;
        String str = s;
        Pattern pattern = Pattern.compile("^([\\p{L}\\s]+),([\\p{L}\\s]+),([\\p{L}\\s]+),([\\p{L}\\s]+),(\\d+)$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean RegulUpdate(String data) {

        String s = data;
        String str = s;
        Pattern pattern = Pattern.compile("^(\\d+),([\\p{L}\\s]+),([\\p{L}\\s]+),([\\p{L}\\s]+),([\\p{L}\\s]+),(\\d+)$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();

    }

    public static boolean RegulDeete(String data) {
        String s = data;
        String str = s;
        Pattern pattern = Pattern.compile("^(\\d+)$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


}
