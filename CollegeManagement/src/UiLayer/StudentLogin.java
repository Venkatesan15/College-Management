package UiLayer;

import MiddleLayer.AddOrGetStudentsML;
import CreationValidator.GetOnlyInt;
import UiLayer.StudentDashboard.*;

import java.util.Scanner;

public class StudentLogin {
    public void studentLogin()
    {
        StudentInterface studentDashboardObj=new StudentDashboard();
        System.out.print("Please Enter Your Roll Number Or Name : ");
        Scanner sc=new Scanner(System.in);
        String nameOrRollNo=sc.nextLine();
        AddOrGetStudentsML addOrGetStudentsMLObj=new AddOrGetStudentsML();
        if(addOrGetStudentsMLObj.isRollNumberOrNameExists(nameOrRollNo))
        {
            int processInput = 1;
            while (processInput > 0 && processInput <= 4) {
                System.out.println("Show Profile---------->1");
                System.out.println("Pay Fees---------->2");
                System.out.println("Send Query------->3");
                System.out.println("Show Time Table---->4");
                System.out.println("Exit--------------------->5");
                processInput = GetOnlyInt.onlyInt();

                if (processInput > 0 && processInput <= 4) {
                    switch (processInput) {
                        case 1:
                            studentDashboardObj.studentProfile(nameOrRollNo);
                            break;
                        case 2:
                            studentDashboardObj.feesDetails(nameOrRollNo);
                            break;
                        case 3:
                            studentDashboardObj.sendQuery(nameOrRollNo);
                            break;
                        case 4:
                            studentDashboardObj.showTimeTable();
                            break;
                    }
                }
                else if (!(processInput > 0 && processInput <=5)) {
                    System.out.println("Please Enter valid input");
                    processInput = 1;
                }

            }

            if (processInput == 5) {
                WelcomePage welcomePageObj = new WelcomePage();
                welcomePageObj.welcomePage();
            }
        }
        else {
            System.out.println("Please Enter Valid Name or Roll Number");

            if(choose())
            {
                studentLogin();
            }
            else
            {
                WelcomePage welcomePageObj=new WelcomePage();
                welcomePageObj.welcomePage();
            }

        }
    }
    public boolean choose()
    {
        System.out.println("Try Again-------------->1");
        System.out.println("Leave From this Page--->2");
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
