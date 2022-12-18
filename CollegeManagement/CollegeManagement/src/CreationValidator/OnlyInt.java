package CreationValidator;

import java.util.Scanner;

public class OnlyInt {
    public static int onlyInt()
    {
        Scanner sc=new Scanner(System.in);
        int input=1;
        try
        {
            input=sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Please Enter Valid Input");
            return  onlyInt();
        }
        return input;

    }
}
