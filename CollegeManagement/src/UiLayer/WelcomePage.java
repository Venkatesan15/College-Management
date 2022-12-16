package UiLayer;

import CreationValidator.GetOnlyInt;

public class WelcomePage {
    public  void welcomePage()
    {
        int adminOrStuOrExit=1;
        while (adminOrStuOrExit>=1&&adminOrStuOrExit<=2)
        {
            System.out.println("Admin------>1");
            System.out.println("Student---->2");
            System.out.println("Exit------->3");
            adminOrStuOrExit= GetOnlyInt.onlyInt();
            if(adminOrStuOrExit==1)
            {
                AdminLogin adminLoginObj=new AdminLogin();
                adminLoginObj.adminLogin();
                return;
            }
            else if (adminOrStuOrExit==2) {
                StudentLogin studentLoginObj=new StudentLogin();
                studentLoginObj.studentLogin();
                return;

            }
            else if (adminOrStuOrExit!=3)
            {
                System.out.println("Please Enter Valid Input");
                adminOrStuOrExit=1;
            }

        }
        if(adminOrStuOrExit==3)
        {
            System.out.println("Thank You");

        }
    }
}
