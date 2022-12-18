package UiLayer.AdminDashboard;

import MiddleLayer.FeesDetailsML;
import CreationValidator.OnlyInt;
import CreationValidator.StudentInfo;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class FeesDetails {
    public void addParticulars()
    {
        System.out.print("Please Enter Particular Like HostelFee(Without Space) : ");
        Scanner sc=new Scanner(System.in);
        String particular=sc.nextLine();
        while (particular.contains(" "))
        {
            System.out.print("Please Don't Use Space : ");
            particular=sc.nextLine();
        }

        System.out.print("Please Enter Amount : ");
        long amount=sc.nextLong();

        System.out.print("Please Enter Last Date to Pay Fee(yyyy-mm-dd) : ");
        StudentInfo studentInfoObj =new StudentInfo();
        String date= studentInfoObj.getDate();
        LocalDate date1= LocalDate.parse(date);
        LocalDate localDate=LocalDate.now();
        while (localDate.isAfter(date1))
        {
            System.out.print("Please Enter Future date : ");
            date= studentInfoObj.getDate();
            date1= LocalDate.parse(date);
        }

        FeesDetailsML feesDetailsMLObj =new FeesDetailsML();
        feesDetailsMLObj.setFees(particular,amount,date);
        System.out.println("Successfully Added");
    }



    public  void showAndDeleteParticulars()
    {
        FeesDetailsML feesDetailsMLObj=new FeesDetailsML();
        System.out.println();
        if(feesDetailsMLObj.isParticularAvailable()) {

            System.out.printf("%-15s : %-10s : %-12s","PARTICULARS","AMOUNT","LAST DATE");
            System.out.println();
            System.out.printf("%-15s : %-10s : %-12s","-----------","------","---------");
            System.out.println();
            try {
                ResultSet rs = feesDetailsMLObj.getFeesDetail();
                while (rs.next()) {
                    System.out.printf("%-15s : %-10s : %-12s",rs.getString("Particulars") , rs.getLong("Amount") , rs.getString("LastDate"));
                    System.out.println();
                }
                System.out.println();


                if(choose()) {
                    deleteParticular();
                }

            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        else
        {
            System.out.println("No Fees Details Added,Please Add Particulars First");
        }
    }




    public void studentPaidStatus()
    {
        FeesDetailsML feesDetailsMLObj=new FeesDetailsML();
        try {
            ResultSet columnNamesRS=feesDetailsMLObj.getColumnNames();

            int c=0;

            while (columnNamesRS.next()) {
                if(!(columnNamesRS.getString("COLUMN_NAME").equals("RollNumber")||columnNamesRS.getString("COLUMN_NAME").equals("Name")))
                {
                    c=1;
                    //System.out.println(columnNamesRS.getString("COLUMN_NAME")+ "  :  Paid Or unpaid Students Details");
                    System.out.printf("%-15s : %-15s : %-10s","Roll Number","Name",columnNamesRS.getString("COLUMN_NAME"));
                    System.out.println();
                    System.out.printf("%-15s : %-15s : %-10s","-----------","----","----------------");
                    System.out.println();

                    ResultSet rs = feesDetailsMLObj.getStudentsPaidDetails();
                    while (rs.next()) {
                        System.out.printf("%-15s : %-15s : %-10s",rs.getString("RollNumber") , rs.getString("Name") , rs.getString( columnNamesRS.getString("COLUMN_NAME")));
                        System.out.println();

                    }
                    System.out.println("**************************************************");
                }
            }
            if(c==0)
            {
                System.out.println("No Fees are available");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void deleteParticular()
    {
        System.out.print("Enter Particular Want to Delete : ");
        Scanner sc=new Scanner(System.in);
        String particular=sc.nextLine();

        FeesDetailsML feesDetailsMLObj =new FeesDetailsML();

        if(feesDetailsMLObj.isParticularAvailable(particular))
        {
            feesDetailsMLObj.deleteParticular(particular);
            System.out.println("Successfully Deleted");
            System.out.println();
        }
        else
        {
            System.out.println("The Particular Not Available");
            deleteParticular();

        }
    }
    public boolean choose()
    {
        System.out.println("Delete------>1");
        System.out.println("Back-------->2");
        int ui= OnlyInt.onlyInt();
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
