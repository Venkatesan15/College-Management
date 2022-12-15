package UiLayer.AdminDashboard;

import MiddleLayer.GetOnlyInt;
import MiddleLayer.TimeTableML;

import java.util.Scanner;

public class SetTimeTable {
    public void createNewTimeTable()
    {
        System.out.println("Enter Maximum Day Orders You Want(only 5,6,7)");
        int userInput=GetOnlyInt.onlyInt();
        int a=1;
        if(userInput==5||userInput==6||userInput==7) {
            while (a <= userInput) {
                Scanner sc = new Scanner(System.in);
                String fP, sP, tP, foP;
                System.out.println("Day Order : " + a);
                System.out.print("First Period : ");
                fP = sc.nextLine();
                System.out.print("Second Period : ");
                sP = sc.nextLine();
                System.out.print("Third Period : ");
                tP = sc.nextLine();
                System.out.print("Fourth Period : ");
                foP = sc.nextLine();
                TimeTableML timeTableMLObj=new TimeTableML();
                timeTableMLObj.insertIntoTimeTable(a,fP,sP,tP,foP);
                System.out.println("************************");
                a++;
            }
            System.out.println("Time Table Set Successfully");
        }
        else
        {
            System.out.println("Please Enter Valid Day Order");
            createNewTimeTable();
        }

    }
    public void editTimeTable()
    {
        System.out.println("Please Enter Day Order");
        Scanner sc = new Scanner(System.in);
        int dO=sc.nextInt();
        TimeTableML timeTableMLObj=new TimeTableML();
        if(dO<=7) {
            String fP, sP, tP, foP;

            System.out.print("First Period : ");
            sc.nextLine();
            fP = sc.nextLine();
            System.out.print("Second Period : ");
            sP = sc.nextLine();
            System.out.print("Third Period : ");
            tP = sc.nextLine();
            System.out.print("Fourth Period : ");
            foP = sc.nextLine();
            if (timeTableMLObj.isDayOrderAvailable(dO)) {

                timeTableMLObj.editUsingDayOrder(dO, fP, sP, tP, foP);
                System.out.println("Successfully Edited");
            }
            else {
                timeTableMLObj.insertIntoTimeTable(dO,fP,sP,tP,foP);
                System.out.println("Successfully Created");
            }
        }
        else
        {
            System.out.println("You can Edit Or Create only Day order<=7");
            System.out.println("");

            if(choose())
            {
                editTimeTable();
            }
            else {
                return;
            }
        }
    }
    public boolean choose()
    {
        System.out.println("Continue Edit---------->1");
        System.out.println("Back------------------->2");
        int ui=GetOnlyInt.onlyInt();
        if(ui==1)
        {
            return true;
        }
        else if(ui!=2)
        {
            System.out.println("Please Enter Valid Input");
            choose();
        }
        return false;
    }
}
