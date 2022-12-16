package UiLayer.AdminDashboard;

import MiddleLayer.EditStudentDetailsMl;
import CreationValidator.GetOnlyInt;
import CreationValidator.AddStuEnterDetails;

import java.sql.ResultSet;
import java.util.Scanner;

public class EditStudentDetails {
    public void usingName()
    {
        System.out.println("Please Enter Student Name");
        Scanner sc=new Scanner(System.in);
        String rollNumberOrName =sc.nextLine();
        int res= editUsingRollNoOrName(rollNumberOrName);
        if(res==0)
        {
            System.out.println("The Name Is Wrong");
            if(choose()) {
                usingName();
            }
            else {
                return;
            }
        }
    }
    public void usingRollNumber()
    {
        System.out.println("Please Enter Student Roll Number");
        Scanner sc=new Scanner(System.in);
        String rollNumberOrName =sc.nextLine();
        int res= editUsingRollNoOrName(rollNumberOrName);
        if(res==0)
        {
            System.out.println("The Roll Number Is Wrong");

            if(choose()) {
                usingRollNumber();
            }
            else {
                return;
            }
        }
    }
    public void showDetails(ResultSet rs)
    {
        try {
            rs.next();
            System.out.println("Name         : " + rs.getString("Name"));
            System.out.println("Roll Number  : " + rs.getString("RollNumber"));
            System.out.println("Gender       : " + rs.getString("Gender"));
            System.out.println("Phone Number : " + rs.getString("PhoneNumber"));
            System.out.println("DOB          : " + rs.getString("DOB"));
            System.out.println("*************************");

        }
        catch (Exception e)
        {

        }
    }
    public void edit(String rollNoOrName)
    {
        System.out.println("Please Enter Which One You Want(Name||RollNumber||Gender||PhoneNumber||DOB)");
        Scanner sc=new Scanner(System.in);
        String process=sc.nextLine();
        EditStudentDetailsMl editStudentDetailsMlObj =new EditStudentDetailsMl();
        AddStuEnterDetails addStuEnterDetailsObj=new AddStuEnterDetails();
        switch (process)
        {
            case "Name":
                String name=addStuEnterDetailsObj.enterName();
                editStudentDetailsMlObj.editStudentDetail("Name",name, rollNoOrName);
                editStudentDetailsMlObj.changeNameInStudentFeesTable(rollNoOrName,name);

                System.out.println("Changed Successfully");

                break;
            case "Gender":
                String gender=addStuEnterDetailsObj.enterGender();
                editStudentDetailsMlObj.editStudentDetail("Gender",gender, rollNoOrName);
                System.out.println("Changed Successfully");
                break;
            case "PhoneNumber":
                String phNo=addStuEnterDetailsObj.enterPhoneNumber();
                editStudentDetailsMlObj.editStudentDetail("PhoneNumber",phNo, rollNoOrName);
                System.out.println("Changed Successfully");
                break;
            case "DOB":
                String dob= addStuEnterDetailsObj.studentDOB();
                editStudentDetailsMlObj.editStudentDetail("DOB",dob, rollNoOrName);

                int age= addStuEnterDetailsObj.getAge(dob);
                editStudentDetailsMlObj.editAge(age, rollNoOrName);
                System.out.println("Changed Successfully");
                break;
            case "RollNumber":
                String newRollNumber= addStuEnterDetailsObj.enterRollNumber();
                editStudentDetailsMlObj.editStudentDetail("RollNumber",newRollNumber, rollNoOrName);

                editStudentDetailsMlObj.changeRegInStudentFeesTable(rollNoOrName,newRollNumber);
                System.out.println("Changed Successfully");
                break;
            default:
                System.out.println("Please Enter Valid Process");
                edit(rollNoOrName);
        }
    }
    public int editUsingRollNoOrName(String rollNumberOrName)
    {
        EditStudentDetailsMl editStudentDetailsMlObj =new EditStudentDetailsMl();
        if(editStudentDetailsMlObj.isRollNoOrNameExists(rollNumberOrName))
        {
            try {
                ResultSet rs = editStudentDetailsMlObj.getDetailsUsingRNOrName(rollNumberOrName);
                showDetails(rs);
                int userInput=1;
                while (userInput == 1) {
                    System.out.println("Edit----->1");
                    System.out.println("Back----->2");
                    userInput = GetOnlyInt.onlyInt();
                    if (userInput == 1) {
                        edit(rollNumberOrName);
                    } else if (userInput == 2) {
                        return 1;
                    } else {
                        System.out.println("Please Enter Valid Input");
                        userInput = 1;
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Something Went Wrong");
            }
            return  1;
        }
        else
        {
            return 0;
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

