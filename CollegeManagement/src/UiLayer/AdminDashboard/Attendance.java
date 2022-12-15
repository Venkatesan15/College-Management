package UiLayer.AdminDashboard;

import DataLayer.IsExistsInDB;
import MiddleLayer.AttendanceML;
import MiddleLayer.GetName;
import CreationValidator.AddStuEnterDetails;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class Attendance {

    public void takeAttendance()
    {
        LocalDate date=LocalDate.now();
        String date1=String.valueOf(date);
        String query="SELECT EXISTS(SELECT * FROM Attendance WHERE Date='"+date1+"') AS res";
        if(IsExistsInDB.isExistsInDB(query))
        {
            System.out.println("**********************************");
            System.out.println("You Already Taken Attendance Today");
            System.out.println("**********************************");
            System.out.println();

            return;
        }
        else {
            System.out.println("Today Date is : "+date);
            System.out.println();
            System.out.println("Please Enter P Or A");
            System.out.println();
            System.out.printf("%-10s  :   %-18s  :  %s","Roll Num","Name","P(or)A");
            System.out.println();
            GetName getNameObj=new GetName();
            ResultSet rs=getNameObj.getName();
            try {
                while (rs.next())
                {
                    System.out.printf("%-10s  :   %-18s  :  ",rs.getString("RollNumber"),rs.getString("Name"));


                    String rollNumber=rs.getString("RollNumber");
                    String strDate= String.valueOf(date);

                    String status=pOrA();


                    AttendanceML attendanceMLObj =new AttendanceML();
                    attendanceMLObj.attendanceML(rollNumber,strDate,status);
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception In Attendance : "+e);

            }
        }
    }
    public String pOrA()
    {
        Scanner sc=new Scanner(System.in);
        String status=sc.nextLine();
        if(status.equals("P")||status.equals("p"))
        {
            return "P";
        } else if (status.equals("A")||status.equals("a")) {
            return "A";
        }
        else
        {
            System.out.print("Please enter valid Input  :  ");
            return pOrA();
        }
    }
    public void attendanceHistoryByDate()
    {
        AddStuEnterDetails addStuEnterDetailsObj=new AddStuEnterDetails();
        System.out.println("Please Enter a date(YYYY-MM-DD)");
        String date= addStuEnterDetailsObj.getDate();

        AttendanceML attendanceMLObj=new AttendanceML();
        if(attendanceMLObj.isAttendanceHistoryAvailable(date))
        {
            ResultSet attendanceHistory=attendanceMLObj.getAttendanceHistory(date);
            display(attendanceHistory);
        }
        else
        {
            System.out.println("No history Available in this Date");
            System.out.println();
        }

    }
    public void attendanceHistoryByRollNo()
    {
        System.out.print("Please Enter RollNumber  : ");
        Scanner sc=new Scanner(System.in);
        String rollNo=sc.nextLine();
        AttendanceML attendanceMLObj=new AttendanceML();
        if(attendanceMLObj.isRollNoAvailOnAttendance(rollNo))
        {
            ResultSet attendance=attendanceMLObj.getAttendanceHistoryByRollNo(rollNo);
            display(attendance);
        }
        else
        {
            System.out.println("Check The Roll Number,It is Not Available");
        }

    }
    public int display(ResultSet attendanceHistory)
    {
        int count=1;
        try
        {
            while (attendanceHistory.next())
            {
                System.out.printf("%s : %-12s : %-12s : %s",count,attendanceHistory.getString("RollNumber"),attendanceHistory.getString("Date"),attendanceHistory.getString("Status"));
                count++;
                System.out.println();
            }
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Exception in  attendance history : "+e);

        }
        return count;
    }
}
