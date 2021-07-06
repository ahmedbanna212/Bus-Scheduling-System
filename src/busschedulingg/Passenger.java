package busschedulingg;

import java.util.Scanner;

public class Passenger extends User implements Observer{

    private String Type;
    private boolean IsSubscribed;
    private Subscription subscription;
    private ScheduleReadOnly scheduleReadOnly;
    private Admin admin;

    public Passenger(String Type, boolean IsSubscribed, Subscription subscription, String driver, String Name, int Id, String UserName, String Password, String Address) {
        super(Name, Id, UserName, Password, Address);
        this.Type = Type;
        this.IsSubscribed = IsSubscribed;
        this.subscription = subscription;
    }
    public Passenger(String Type,  String Name, int Id, String UserName, String Password, String Address,ScheduleReadOnly scheduleReadOnly) {
        super(Name, Id, UserName, Password, Address);
        this.Type = Type;
        this.IsSubscribed = false;
        this.scheduleReadOnly = scheduleReadOnly;
    }

    public Passenger(String Name, int Id, String UserName, String Password, String Address) {
        super(Name, Id, UserName, Password, Address);
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public boolean isIsSubscribed() {
        return IsSubscribed;
    }

    public void setIsSubscribed(boolean IsSubscribed) {
        this.IsSubscribed = IsSubscribed;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

        
    public void Subscribe(){
        Admin admin = Admin.getInstance();
        System.out.println("please pick a route by preasing the route number");
        
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the destination");
        String x =sc.nextLine();
        if(admin.searchRoutes(x) != null){
            Subscription s =new Subscription(1,admin.searchRoutes(x),"30/2/2021","30/6/2021",1);
            setSubscription(s);
            boolean state=true;
            setIsSubscribed(state);
        }
        else{
             System.out.println("Destination isn't available");
        }       
    }
    
    public void CancelSubscription(){
        boolean state=false;
        setIsSubscribed(state);
    }
    
    public void UpdateInfo(int choice){
        Scanner sc = new Scanner (System.in);
        switch(choice){
            case '1':
               System.out.println("You Just pressed to change your name");
               String name=sc.nextLine(); 
               this.setName(name);
               break;
            case'2':
               String email=sc.nextLine(); 
               this.setName(email);
               break;
            case'3':
               String address=sc.nextLine(); 
               this.setName(address);
               break;
            case'4':
               String password=sc.nextLine(); 
               this.setName(password);
               break;
            default:
               break; 
        }
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
    }

    public void viewBus(){
        scheduleReadOnly.ViewBus();
    }
    
    @Override
    public void Update(Message m) {
        System.out.println("The message update is: " + m);
    }

}
