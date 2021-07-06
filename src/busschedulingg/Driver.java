package busschedulingg;

import java.util.Scanner;

public class Driver {
    private String Name;
    private int Id;
    private String PhoneNumber;
    private boolean RedFlag;
    private String Issue;
    private Admin admin;

    public Driver(String Name, int Id, String PhoneNumber, boolean RedFlag, String Issue) {
        this.Name = Name;
        this.Id = Id;
        this.PhoneNumber = PhoneNumber;
        this.RedFlag = RedFlag;
        this.Issue = Issue;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public boolean isRedFlag() {
        return RedFlag;
    }

    public void setRedFlag(boolean RedFlag) {
        this.RedFlag = RedFlag;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String Issue) {
        this.Issue = Issue;
    }


     public void report(){
     Scanner sc = new Scanner (System.in);
     admin = Admin.getInstance();
       System.out.println("Enter the report description ");
       String desc=sc.nextLine();
       System.out.println("Enter the report id ");
       int id=sc.nextInt();
       Report xReports=new Report(id, desc);
       admin.addreport(xReports);
       
    };
     
    public void viewdriver(){
    
        System.out.println(this.Name);
    System.out.println(this.Id);
    }


    
}
