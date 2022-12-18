package uiLayer.adminDashboard;

import creationValidator.StudentInfo;
import middleLayer.StudentsProfile;
import creationValidator.OnlyInt;
import middleLayer.Complaints;
import middleLayer.TimeTableML;
import uiLayer.Complaint;
import uiLayer.Student;
import uiLayer.studentDashboard.StudentDashboard;
import uiLayer.studentDashboard.StudentPage;

import java.sql.ResultSet;
import java.util.Scanner;

public class AdminDashBoard implements AdminPage {
    public void studentInfo()
    {
        StudentsProfile studentsProfileObj =new StudentsProfile();
        Scanner sc=new Scanner(System.in);
        System.out.print("Please Enter Student Name Or RollNumber   :  ");
        String rollNoOrName=sc.nextLine();
        if(studentsProfileObj.isRollNumberOrNameExists(rollNoOrName))
        {
            StudentPage studentDashboardObj=new StudentDashboard();
            studentDashboardObj.studentProfile(rollNoOrName);
        }
        else
        {
            System.out.println("This Roll Number or Name Not In the list");
            System.out.println();
           choose();
        }
    }
    public void choose()
    {
        System.out.println("Try Again-------------->1");
        System.out.println("Leave From this Page--->2");
        int ui= OnlyInt.onlyInt();
        if(ui==1)
        {
            studentInfo();
        }
        else if(ui!=2)
        {
            System.out.println("Please Enter Valid Input");
            choose();
        }
    }
    public void studentQueries()
    {
        try
        {
            Complaints complaintsObj =new Complaints();
            if(complaintsObj.isQueryAvailable()) {
                ResultSet rs = complaintsObj.getQueries();
                while (rs.next()) {
                    int sNo = rs.getInt("SNo");
                    String date = rs.getNString("Date");
                    String rollNo = rs.getString("RollNo");
                    String query = rs.getString("Query");

                    Complaint complaint=new Complaint(date,rollNo,query);

                    System.out.println("Serial Number            : " + sNo);
                    System.out.println("Date                     : " + complaint.getDate());
                    System.out.println("Student Roll Number/Name : " + complaint.getRollNumber());
                    System.out.println("Query                    : " + complaint.getQuery());
                    System.out.println("************************************");
                }
            }
            else {
                System.out.println("No Queries Available Right Now");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void timeTable()
    {
        TimeTable timeTableObj =new TimeTable();
        TimeTableML timeTableMLObj=new TimeTableML();
        int userInput=1;
        while (userInput==1||userInput==2||userInput==3) {

            System.out.println("-------------------------------------------------");
            System.out.println("||     Set New Time Table--------------->1     ||");
            System.out.println("||     Delete Time Table---------------->2     ||");
            System.out.println("||     Edit Time Table Using Day Order-->3     ||");
            System.out.println("||     Back----------------------------->4     ||");
            System.out.println("-------------------------------------------------");

            System.out.println();

            userInput= OnlyInt.onlyInt();

            if(userInput==1)
            {
                timeTableMLObj.deleteTimeTable();
                timeTableObj.createNewTimeTable();

            }
            else if (userInput==2)
            {
                timeTableMLObj.deleteTimeTable();
                System.out.println("Deleted Successfully");
            }
            else if (userInput==3)
            {
                timeTableObj.editTimeTable();

            }
            else if (userInput!=4) {
                System.out.println("Please Enter Valid Process");
                userInput=1;
            }

        }
    }
    public void feesDetails() {
        int userInput = 1;
        FeesDetails feesDetailsObj=new FeesDetails();
        while (userInput == 1 || userInput == 2 || userInput == 3) {

            System.out.println("-----------------------------------------------------");
            System.out.println("||     Add Particular------------------------>1     ||");
            System.out.println("||     Show/Delete Particulars--------------->2     ||");
            System.out.println("||     Show Students paid/unpaid Details----->3     ||");
            System.out.println("||     Quit---------------------------------->4     ||");
            System.out.println("------------------------------------------------------");


            userInput = OnlyInt.onlyInt();
            if (userInput == 1) {
                feesDetailsObj.addParticulars();

            } else if (userInput == 2) {
                feesDetailsObj.showAndDeleteParticulars();

            } else if (userInput == 3) {
                feesDetailsObj.studentPaidStatus();

            } else if (userInput != 4) {
                System.out.println("Please Enter valid Process");
                userInput = 1;
            }
        }
    }
    public void editStudentDetails()
    {
        StudentDetailChange studentDetailChangeObj =new StudentDetailChange();
        int userInput=1;
        while(userInput==1||userInput==2)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("||     Using Student Roll Number------>1     ||");
            System.out.println("||     Using Student Name------------->2     ||");
            System.out.println("||     Back--------------------------->3     ||");
            System.out.println("-----------------------------------------------");

            userInput= OnlyInt.onlyInt();
            if(userInput==1)
            {
                studentDetailChangeObj.usingRollNumber();

            }
            else if(userInput==2)
            {
                studentDetailChangeObj.usingName();
            }
            else if (userInput!=3)
            {
                System.out.println("Please Enter valid input");
                userInput=1;
            }
        }

    }
    public void displayStudentsList()
    {
        int count=0;
        StudentsProfile studentsProfileObj =new StudentsProfile();
        try
        {
            System.out.printf("  %3s  :  %-12s :   %-10s","S.No","Roll Number","Name");
            System.out.println();
            System.out.printf("  %3s  :  %-12s :   %-10s","----","-----------","----");
            System.out.println();
            ResultSet studentsList= studentsProfileObj.getStudentsList();
            while (studentsList.next())
            {
                count++;
                //System.out.println(studentsList.getInt("Id")+"  :  "+studentsList.getString("RollNumber")+"  :  "+studentsList.getString("Name"));
                System.out.printf("  %3s   :  %-12s :   %-10s  \n",studentsList.getInt("Id"),studentsList.getString("RollNumber"),studentsList.getString("Name"));
            }
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Exception in DisplayStudents : "+e);
        }
        if(count==0)
        {
            System.out.println("The Students List is Empty");
            System.out.println();
        }

    }
    public void attendance()
    {
        Attendance attendanceObj=new Attendance();
        int userInput=1;
        while (userInput==1||userInput==2||userInput==3)
        {
            System.out.println("------------------------------------------------------");
            System.out.println("||     Take Attendance----------------------->1     ||");
            System.out.println("||     Display Attendance History By Date---->2     ||");
            System.out.println("||     Attendance History By Roll Number----->3     ||");
            System.out.println("||     Back---------------------------------->4     ||");
            System.out.println("------------------------------------------------------");

            userInput= OnlyInt.onlyInt();
            if(userInput==1)
            {
                attendanceObj.takeAttendance();
                System.out.println();
            }
            else if (userInput==2)
            {
                attendanceObj.attendanceHistoryByDate();
                System.out.println();
            }
            else if (userInput==3)
            {
                attendanceObj.attendanceHistoryByRollNo();
                System.out.println();

            }
            else if(userInput!=4)
            {
                System.out.println("Please enter valid input");
                attendance();
            }
        }
    }
    public void addNewJoiners()
    {
        StudentInfo studentInfoObj =new StudentInfo();
        System.out.println("");
        String rollNumber= studentInfoObj.enterRollNumber();
        String studentName= studentInfoObj.enterName();
        String studentGender= studentInfoObj.enterGender();
        String studentPhNum= studentInfoObj.enterPhoneNumber();
        String studentDOB= studentInfoObj.studentDOB();
        int studentAge= studentInfoObj.getAge(studentDOB);

        Student studentInfo=new Student(rollNumber,studentName,studentGender,studentPhNum,studentDOB,studentAge);


        System.out.println("Student Age : "+studentAge);
        System.out.println("Successfully Added");
        System.out.println();
        StudentsProfile.addStudent(studentInfo);
    }

}
