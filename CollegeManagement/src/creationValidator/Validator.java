package creationValidator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class Validator {
    public static boolean checkValidGender(int gender)
    {
        if(gender==1||gender==2||gender==3) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isPhNoHaveTenDigit(String phoneNumber)
    {
        Pattern p=Pattern.compile("[0-9]{10}");
        Matcher m=p.matcher(phoneNumber);
        return m.matches();

    }
    public static boolean checkValidName(String name)
    {
        if(name.length()==0)
        {
            return false;
        }
        int upperCaseCountInName=0;
        for(char i:name.toCharArray())
        {
            if((i>=65&&i<=90)||i==' ')
            {
                upperCaseCountInName++;
            }
        }
        if(upperCaseCountInName==name.length()) {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean checkValidDate(String strDate)
    {

        LocalDate date;
        try
        {
            date= LocalDate.parse(strDate);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
