package uiLayer.studentDashboard;

import middleLayer.FeesDetailsML;
import creationValidator.OnlyInt;

import java.sql.ResultSet;

import java.util.Scanner;

public class Fees {

    public void showFeesDetails()
    {
        FeesDetailsML feesDetailsMLObj=new FeesDetailsML();
        System.out.println();
        System.out.printf("%3s : %-20s  : %-15s : %-15s","S.No","Particulars","Amount","Last Date");
        System.out.println();
        int count=0;
        if(feesDetailsMLObj.isParticularAvailable()) {

            try {
                ResultSet rs = feesDetailsMLObj.getFeesDetail();
                while (rs.next()) {
                    count++;
                   //System.out.println("Particular : "+rs.getString("Particulars") + "  ||  Amount   :  " + rs.getLong("Amount") + "  ||  Last Date : " + rs.getString("LastDate"));
                    System.out.printf("%3s  : %-20s  : %-15s : %-15s",count,rs.getString("Particulars"),rs.getLong("Amount"),rs.getString("LastDate"));
                }

                System.out.println();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else
        {
            System.out.println("No Fees are Available now");
        }
    }
    public  void payFees(String rollNoOrName)
    {
        System.out.print("Please Enter Which Fees to be Pay like HostelFees : ");
        Scanner sc=new Scanner(System.in);
        String particularName=sc.nextLine();

        FeesDetailsML feesDetailsMLObj =new FeesDetailsML();
        if(feesDetailsMLObj.isColumnNameExists(particularName,rollNoOrName))
        {
            System.out.println("Paid Successfully");

        }
        else {
            System.out.println("No fees available like that");
            System.out.println();
            if(choose())
            {
                payFees(rollNoOrName);
            }
        }

    }
    public void unpaidFeesOnly(String rollNoOrName)
    {
        int count=0;
        FeesDetailsML feesDetailsMLObj=new FeesDetailsML();
        ResultSet columnNamesRS=feesDetailsMLObj.getColumnNames();

        try {
            while (columnNamesRS.next()) {
                if (feesDetailsMLObj.getUnpaidColumnNames(rollNoOrName, columnNamesRS.getString("COLUMN_NAME"))) {
                    count++;
                    System.out.println(columnNamesRS.getString("COLUMN_NAME"));
                }

             }
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Exception in PayFees : "+e);
        }
        if(count==0)
        {
            System.out.println("You Paid All the fees");
            System.out.println();
        }
    }
    public boolean choose()
    {
        System.out.println("Try Again-------------->1");
        System.out.println("Leave From this Page--->2");
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
