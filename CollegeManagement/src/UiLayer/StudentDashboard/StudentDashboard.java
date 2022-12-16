package UiLayer.StudentDashboard;

import MiddleLayer.AddOrGetStudentsML;
import CreationValidator.GetOnlyInt;
import MiddleLayer.SendQueryML;
import MiddleLayer.TimeTableML;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentDashboard implements StudentInterface{
    @Override
    public void feesDetails(String rollNoOrName) {
        PayFees payFeesObj=new PayFees();
        int userInput=1;
        while(userInput==1||userInput==2||userInput==3)
        {
            System.out.println("Show Fees particulars--->1");
            System.out.println("Show Unpaid Fees Details Only---->2");
            System.out.println("Pay Fees------------>3");
            System.out.println("Back---------------->4");
            userInput= GetOnlyInt.onlyInt();
            if(userInput==1)
            {
                payFeesObj.showFeesDetails();
            }
            else if (userInput==2)
            {
                payFeesObj.unpaidFeesOnly(rollNoOrName);
            } else if(userInput==3)
            {
                payFeesObj.payFees(rollNoOrName);

            }
            else if(!(userInput>0&&userInput<=4))
            {
                System.out.println("Please Enter Valid Input");
                userInput=1;
            }
        }
    }

    @Override
    public void sendQuery(String rollNumber)
    {
        System.out.println("Please Enter Your Complaints or Queries About Our College");
        Scanner sc=new Scanner(System.in);
        String comp=sc.nextLine();

        LocalDate date=LocalDate.now();
        String strDate=String.valueOf(date);

        SendQueryML sendQueryMLObj=new SendQueryML();
        sendQueryMLObj.sendQuery(strDate,rollNumber,comp);
        System.out.println("Sent Successfully");

    }
    public void studentProfile(String rollNoOrName)
    {
        try
        {
            AddOrGetStudentsML addOrGetStudentsMLObj=new AddOrGetStudentsML();
            ResultSet rs=addOrGetStudentsMLObj.getStudentProfile(rollNoOrName);

            rs.next();
            String rollNo=rs.getString("RollNumber");
            String name=rs.getString("Name");
            String gender=rs.getString("Gender");
            String phNo=rs.getString("PhoneNumber");
            String dob=rs.getString("DOB");
            int age=rs.getInt("Age");

            System.out.println("******************************");
            System.out.println("Roll Number   : "+rollNo);
            System.out.println("Name          : "+name);
            System.out.println("Gender        : "+gender);
            System.out.println("Phone Number  : "+phNo);
            System.out.println("Date Of Birth : "+dob);
            System.out.println("Age           : "+age);
            System.out.println("******************************");


        }
        catch (Exception e)
        {
            System.out.println("Exception In StudentProfile : "+e);
        }
    }
    public void showTimeTable()
    {
        int count=0;
        TimeTableML timeTableMLObj=new TimeTableML();
        try {
            ResultSet rs = timeTableMLObj.getTimeTable();
            System.out.printf("%3s : %-10s : %-10s : %-10s : %-10s","dO","F.P","S.P","T.P","F.P");
            System.out.println();
            while (rs.next())
            {
                count++;
                int dO=rs.getInt("DayOrder");
                String f=rs.getString("FirstPeriod");
                String s=rs.getString("SecondPeriod");
                String t=rs.getString("ThirdPeriod");
                String fo=rs.getString("FourthPeriod");

                System.out.printf("%3s : %-10s : %-10s : %-10s : %-10s",dO,f,s,t,fo);

                System.out.println();


            }
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Exception In Show Time Table : "+e);
        }
        if(count==0)
        {
            System.out.println("The Time Table Not Available Right Now");
            System.out.println();
        }
    }
}
