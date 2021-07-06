package busschedulingg;

import java.util.Scanner;

public class ManageDriver implements ManageBehaviour {
    
    private Admin admin;
    
    public void RemoveDriver(){   
        admin = Admin.getInstance();
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the id of the driver to be removed");
        int x = sc.nextInt();
        admin.getDrivers().remove(admin.FindDriverIdexBbyID(x));
   
    }
    
    public void setDriver(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the driver name ");
        String name = sc.nextLine();
        System.out.println("Enter the drivers id ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the drivers phonenumber ");
        String phoneNumber = sc.nextLine();
        Driver x = new Driver(name, id, phoneNumber, false, "hello");
          admin = Admin.getInstance();
          admin.getDrivers().add(x);
    }
    
    @Override
    public void Modify(int option){
     
        switch(option){
            case 1:
                RemoveDriver();
                break;
                
            case 3:
                setDriver();
                break;
        };
    }
}