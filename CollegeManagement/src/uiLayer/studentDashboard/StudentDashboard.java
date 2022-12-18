package uiLayer.studentDashboard;

import middleLayer.StudentsProfile;
import creationValidator.OnlyInt;
import middleLayer.Complaints;
import middleLayer.TimeTableML;
import uiLayer.Complaint;
import uiLayer.Student;
import uiLayer.TimeTableCl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentDashboard implements StudentPage {
    @Override
    public void feesDetails(String rollNoOrName) {
        Fees feesObj =new Fees();
        int userInput=1;
        while(userInput==1||userInput==2||userInput==3)
        {
            System.out.println("-------------------------------------------------");
            System.out.println("||     Show Fees particulars------------>1     ||");
            System.out.println("||     Show Unpaid Fees Details Only---->2     ||");
            System.out.println("||     Pay Fees------------------------->3     ||");
            System.out.println("||     Back----------------------------->4     ||");
            System.out.println("-------------------------------------------------");

            userInput= OnlyInt.onlyInt();
            if(userInput==1)
            {
                feesObj.showFeesDetails();
            }
            else if (userInput==2)
            {
                feesObj.unpaidFeesOnly(rollNoOrName);
            } else if(userInput==3)
            {
                feesObj.payFees(rollNoOrName);

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

        Complaint complaintObj=new Complaint(strDate,rollNumber,comp);

        Complaints complaintsObj=new Complaints();
        complaintsObj.sendQuery(complaintObj);
        System.out.println("Sent Successfully");

    }
    public void studentProfile(String rollNoOrName)
    {
        try
        {
            StudentsProfile studentsProfileObj =new StudentsProfile();
            ResultSet rs= studentsProfileObj.getStudentProfile(rollNoOrName);

            rs.next();
            String rollNo=rs.getString("RollNumber");
            String name=rs.getString("Name");
            String gender=rs.getString("Gender");
            String phNo=rs.getString("PhoneNumber");
            String dob=rs.getString("DOB");
            int age=rs.getInt("Age");

            Student studentObj=new Student(rollNo,name,gender,phNo,dob,age);

            System.out.println("******************************");
            System.out.println("Roll Number   : "+studentObj.getRollNo());
            System.out.println("Name          : "+studentObj.getName());
            System.out.println("Gender        : "+studentObj.getGender());
            System.out.println("Phone Number  : "+studentObj.getPhNo());
            System.out.println("Date Of Birth : "+studentObj.getDob());
            System.out.println("Age           : "+studentObj.getAge());
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
            System.out.printf("%3s : %-10s : %-10s : %-10s : %-10s","--","---","---","---","---");
            System.out.println();
            while (rs.next())
            {
                count++;
                int dO=rs.getInt("DayOrder");
                String f=rs.getString("FirstPeriod");
                String s=rs.getString("SecondPeriod");
                String t=rs.getString("ThirdPeriod");
                String fo=rs.getString("FourthPeriod");

                TimeTableCl ttObj =new TimeTableCl(dO,f,s,t,fo);

                System.out.printf("%3s : %-10s : %-10s : %-10s : %-10s", ttObj.getDayOrder(), ttObj.getFirstPeriod(), ttObj.getSecondPeriod(), ttObj.getThirdPeriod(), ttObj.getFourthPeriod());

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
