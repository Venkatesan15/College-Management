package uiLayer;

import creationValidator.OnlyInt;

public class WelcomePage {
    public  void welcomePage()
    {
        int admin_Stu_Exit =1;
        while (admin_Stu_Exit >=1&& admin_Stu_Exit <=2)
        {
            System.out.println("***********WELCOME**************");
            System.out.println("||      Admin------>1         ||");
            System.out.println("||      Student---->2         ||");
            System.out.println("||      Exit------->3         ||");
            System.out.println("********************************");

            admin_Stu_Exit = OnlyInt.onlyInt();
            if(admin_Stu_Exit ==1)
            {
                AdminLogin adminLoginObj=new AdminLogin();
                adminLoginObj.adminLogin();
                return;
            }
            else if (admin_Stu_Exit ==2) {
                StudentLogin studentLoginObj=new StudentLogin();
                studentLoginObj.studentLogin();
                return;

            }
            else if (admin_Stu_Exit !=3)
            {
                System.out.println("Please Enter Valid Input");
                admin_Stu_Exit =1;
            }

        }
        if(admin_Stu_Exit ==3)
        {
            System.out.println("Thank You");

        }
    }
}
