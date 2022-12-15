package CreationValidator;

import java.time.LocalDate;

import static java.lang.String.valueOf;

public class AddStuCreationValidator {
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
        int c1=0;
        int numberCount=0;
        char[] arr =phoneNumber.toCharArray();
        try {
            for (int i=0;i<arr.length;i++) {
                int i1 = Integer.parseInt(valueOf(arr[i]));
                if (i1>=0 && i1<=9) {
                    numberCount++;
                }
            }
        }
        catch (Exception e)
        {

        }
        if((phoneNumber.length()==10)&&numberCount==10) {
            return true;
        }
        return false;
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
