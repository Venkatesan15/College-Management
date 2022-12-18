package uiLayer;

import middleLayer.StudentsProfile;
import creationValidator.OnlyInt;
import uiLayer.studentDashboard.*;

import java.util.Scanner;

public class StudentLogin {
    public void studentLogin()
    {
        StudentPage studentDashboardObj=new StudentDashboard();
        System.out.print("Please Enter Your Roll Number Or Name : ");
        Scanner sc=new Scanner(System.in);
        String nameOrRollNo=sc.nextLine();
        StudentsProfile studentsProfileObj =new StudentsProfile();
        if(studentsProfileObj.isRollNumberOrNameExists(nameOrRollNo))
        {
            int processInput = 1;
            while (processInput > 0 && processInput <= 4) {

                System.out.println("**************************************");
                System.out.println("**     Show Profile---------->1     **");
                System.out.println("**     Pay Fees-------------->2     **");
                System.out.println("**     Send Query------------>3     **");
                System.out.println("**     Show Time Table------->4     **");
                System.out.println("**     Exit------------------>5     **");
                System.out.println("**************************************");

                processInput = OnlyInt.onlyInt();

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
        int ui= OnlyInt.onlyInt();
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
