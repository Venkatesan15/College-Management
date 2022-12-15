package UiLayer;

import MiddleLayer.GetOnlyInt;
import UiLayer.AdminDashboard.*;
import UiLayer.StudentDashboard.StudentDashboard;
import UiLayer.StudentDashboard.StudentInterface;

import java.util.Scanner;

public class AdminLogin {
    public void adminLogin()
    {
        AdminInterface adminDashBoardObj=new AdminDashBoard();
        System.out.println("Please Enter Admin Password");
        Scanner sc=new Scanner(System.in);
        String pass=sc.nextLine();
        if(pass.equals("ZOHO"))
        {

            int processInput=1;
            while (processInput>0&&processInput<=9)
            {
                System.out.println("Student Info------------->1");
                System.out.println("Add New Student---------->2");
                System.out.println("Display Students List---->3");
                System.out.println("Attendance--------------->4");
                System.out.println("Fees Details------------->5");
                System.out.println("Show Queries Received---->6");
                System.out.println("Edit Student Details----->7");
                System.out.println("Set Time Table----------->8");
                System.out.println("Show Time Table---------->9");
                System.out.println("Exit--------------------->10");
                processInput= GetOnlyInt.onlyInt();

                if(processInput>0&&processInput<=9)
                {
                    switch (processInput)
                    {
                        case 1:
                            adminDashBoardObj.studentInfo();
                            break;
                        case 2:
                            adminDashBoardObj.addNewJoiners();
                            break;
                        case 3:
                            adminDashBoardObj.displayStudentsList();
                            break;
                        case 4:
                            adminDashBoardObj.attendance();
                            break;
                        case 5:
                            adminDashBoardObj.feesDetails();
                            break;
                        case 6:
                            adminDashBoardObj.studentQueries();
                            break;
                        case 7:
                            adminDashBoardObj.editStudentDetails();
                            break;
                        case 8:
                            adminDashBoardObj.timeTable();
                            break;
                        case 9:
                            StudentInterface studentDashboardObj=new StudentDashboard();
                            studentDashboardObj.showTimeTable();
                            break;

                    }
                }
                else if (!(processInput>0&&processInput<=10))
                {
                    System.out.println("Please Enter valid input");
                    processInput=1;
                }

            }
            if(processInput==10)
            {
                WelcomePage welcomePageObj=new WelcomePage();
                welcomePageObj.welcomePage();
            }
        }
        else
        {
            System.out.println("The password is Wrong");
            System.out.println();
            choose();

        }
    }
    private void choose()
    {
        System.out.println("Try Again-------------->1");
        System.out.println("Leave From this Page--->2");
        int ui=GetOnlyInt.onlyInt();
        if(ui==1)
        {
            adminLogin();
        }
        else if(ui!=2)
        {
            System.out.println("Please Enter Valid Input");
            choose();
        }
    }

}
