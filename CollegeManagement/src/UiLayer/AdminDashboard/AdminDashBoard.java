package UiLayer.AdminDashboard;

import CreationValidator.AddStuEnterDetails;
import MiddleLayer.AddOrGetStudentsML;
import MiddleLayer.GetOnlyInt;
import MiddleLayer.GetQueries;
import MiddleLayer.TimeTableML;
import UiLayer.Student;
import UiLayer.StudentDashboard.StudentDashboard;
import UiLayer.StudentDashboard.StudentInterface;

import java.sql.ResultSet;
import java.util.Scanner;

public class AdminDashBoard implements AdminInterface{
    public void studentInfo()
    {
        AddOrGetStudentsML addOrGetStudentsMLObj=new AddOrGetStudentsML();
        Scanner sc=new Scanner(System.in);
        System.out.print("Please Enter Student Name Or RollNumber   :  ");
        String rollNoOrName=sc.nextLine();
        if(addOrGetStudentsMLObj.isRollNumberOrNameExists(rollNoOrName))
        {
            StudentInterface studentDashboardObj=new StudentDashboard();
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
        int ui=GetOnlyInt.onlyInt();
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
            GetQueries getQueriesObj=new GetQueries();
            if(getQueriesObj.isQueryAvailable()) {
                ResultSet rs = getQueriesObj.getQueries();
                while (rs.next()) {
                    int sNo = rs.getInt("SNo");
                    String date = rs.getNString("Date");
                    String rollNo = rs.getString("RollNo");
                    String query = rs.getString("Query");

                    System.out.println("Serial Number            : " + sNo);
                    System.out.println("Date                     : " + date);
                    System.out.println("Student Roll Number/Name : " + rollNo);
                    System.out.println("Query                    : " + query);
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
        SetTimeTable setTimeTableObj=new SetTimeTable();
        TimeTableML timeTableMLObj=new TimeTableML();
        int userInput=1;
        while (userInput==1||userInput==2||userInput==3) {
            System.out.println("Set New Time Table-------------->1");
            System.out.println("Delete Time Table--------------->2");
            System.out.println("Edit Time Table Using Day Order-->3");
            System.out.println("Back----------------------------->4");
            System.out.println();

            userInput= GetOnlyInt.onlyInt();

            if(userInput==1)
            {
                timeTableMLObj.deleteTimeTable();
                setTimeTableObj.createNewTimeTable();

            }
            else if (userInput==2)
            {
                timeTableMLObj.deleteTimeTable();
                System.out.println("Deleted Successfully");
            }
            else if (userInput==3)
            {
                setTimeTableObj.editTimeTable();

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

            System.out.println("**********************");
            System.out.println("Add Particular------------------------>1");
            System.out.println("Show/Delete Particulars--------------->2");
            System.out.println("Show Students paid/unpaid Details----->3");
            System.out.println("Quit---------------------------------->4");
            System.out.println("**********************");


            userInput = GetOnlyInt.onlyInt();
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
        EditStudentDetails editStudentDetailsObj=new EditStudentDetails();
        int userInput=1;
        while(userInput==1||userInput==2)
        {
            System.out.println("Using Student Roll Number------>1");
            System.out.println("Using Student Name------------->2");
            System.out.println("Back--------------------------->3");
            userInput= GetOnlyInt.onlyInt();
            if(userInput==1)
            {
                editStudentDetailsObj.usingRollNumber();

            }
            else if(userInput==2)
            {
                editStudentDetailsObj.usingName();
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
        AddOrGetStudentsML addOrGetStudentsMLObj=new AddOrGetStudentsML();
        try
        {
            ResultSet studentsList= addOrGetStudentsMLObj.getStudentsList();
            while (studentsList.next())
            {
                count++;
                //System.out.println(studentsList.getInt("Id")+"  :  "+studentsList.getString("RollNumber")+"  :  "+studentsList.getString("Name"));
                System.out.printf("  %3s   :  %-10s :   %-10s  \n",studentsList.getInt("Id"),studentsList.getString("RollNumber"),studentsList.getString("Name"));
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
            System.out.println("Take Attendance----------------------->1");
            System.out.println("Display Attendance History By Date---->2");
            System.out.println("Attendance History By Roll Number----->3");
            System.out.println("Back---------------------------------->4");
            userInput= GetOnlyInt.onlyInt();
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
        AddStuEnterDetails addStuEnterDetailsObj =new AddStuEnterDetails();
        System.out.println("");
        String rollNumber=addStuEnterDetailsObj.enterRollNumber();
        String studentName= addStuEnterDetailsObj.enterName();
        String studentGender= addStuEnterDetailsObj.enterGender();
        String studentPhNum= addStuEnterDetailsObj.enterPhoneNumber();
        String studentDOB= addStuEnterDetailsObj.studentDOB();
        int studentAge= addStuEnterDetailsObj.getAge(studentDOB);

        Student studentInfo=new Student(rollNumber,studentName,studentGender,studentPhNum,studentDOB,studentAge);


        System.out.println("Student Age : "+studentAge);
        System.out.println("Successfully Added");
        System.out.println();
        AddOrGetStudentsML.addStudent(studentInfo);
    }

}
