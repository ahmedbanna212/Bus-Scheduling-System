package busschedulingg;

import java.util.Scanner;

public class DriverManager extends Employee {

  private Admin admin;

    public DriverManager( ManageBehaviour manageBehaviour, String Name, int Id, String Email_Address, String Password, String Address) {
        super(manageBehaviour, Name, Id, Email_Address, Password, Address);
    
    }

    public void HireDriver(){
         Scanner sc = new Scanner (System.in);
        System.out.println("Enter the driver name ");
        String name = sc.nextLine();
       
      
        System.out.println("Enter the drivers id ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the drivers phonenumber ");
        String phoneNumber = sc.nextLine();
        Driver x=new Driver(name, id, phoneNumber, false, "hello");
          admin = Admin.getInstance();
          admin.getDrivers().add(x);
    }
    
    public void SuspendDriver(int id){
        admin = Admin.getInstance();
       Driver drivers = new Driver("makka", 190, "hajdoa", true, "anla");
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the id of the driver to be removed");
        int x = sc.nextInt();
       admin.getDrivers().remove(admin.FindDriverIdexBbyID(x));
    }
    
    public void SearchRedFlag(){
     admin = Admin.getInstance();
     for(int i=0;i<admin.getDrivers().size();i++){
         if(admin.getDrivers().get(i).isRedFlag()==true)
            admin.getDrivers().get(i).viewdriver();
     
     }
    }
}
