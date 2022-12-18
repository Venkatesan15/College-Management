package uiLayer.adminDashboard;

import dataLayer.IsExistsInDB;
import middleLayer.AttendanceML;
import creationValidator.StudentInfo;
import middleLayer.StudentsProfile;
import uiLayer.AttendanceCl;

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
            System.out.printf("%-10s  :   %-18s  :  %s","--------","----","------");
            System.out.println();

            StudentsProfile studentsProfileObj=new StudentsProfile();
            ResultSet rs= studentsProfileObj.getName();
            try {
                while (rs.next())
                {
                    System.out.printf("%-10s  :   %-18s  :  ",rs.getString("RollNumber"),rs.getString("Name"));


                    String rollNumber=rs.getString("RollNumber");
                    String strDate= String.valueOf(date);
                    String status=pOrA();

                    AttendanceCl attendanceClObj=new AttendanceCl(rollNumber,strDate,status);


                    AttendanceML attendanceMLObj =new AttendanceML();
                    attendanceMLObj.attendanceML(attendanceClObj);
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
        StudentInfo studentInfoObj =new StudentInfo();
        System.out.println("Please Enter a date(YYYY-MM-DD)");
        String date= studentInfoObj.getDate();

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
        System.out.printf("%4s : %-12s : %-12s : %s","S.No","Roll Number","Date","Status");
        System.out.println();
        System.out.printf("%4s : %-12s : %-12s : %s","----","-----------","----","------");
        System.out.println();
        try
        {
            while (attendanceHistory.next())
            {
                String rollNo=attendanceHistory.getString("RollNumber");
                String date=attendanceHistory.getString("Date");
                String status=attendanceHistory.getString("Status");

                AttendanceCl attendanceCl=new AttendanceCl(rollNo,date,status);
                System.out.printf("%4s : %-12s : %-12s : %s",count,attendanceCl.getRollNumber(),attendanceCl.getDate(),attendanceCl.getStatus());

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
