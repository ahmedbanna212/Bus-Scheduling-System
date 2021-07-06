package busschedulingg;

import java.util.Scanner;

public class BusManager extends Employee{

    private Admin admin;

    public BusManager(ManageBehaviour manageBehaviour, String Name, int Id, String Email_Address, String Password, String Address) {
        super(manageBehaviour, Name, Id, Email_Address, Password, Address);
    }
    
    public void AssignDriverToBus(Driver drivers, Bus bus){
        bus.getAssignedDrivers().add(drivers);
    }
     
    public void AssignPassengerToBus(Passenger passenger, Bus bus){
        bus.getAssignedPassengers().add(passenger);
    }
    
    public void AddBus(Bus bus){
        admin = Admin.getInstance();
        admin.getWorkingBuses().add(bus);
    }
    
    public void DisableBus(Bus bus){
        admin = Admin.getInstance();
        admin.getWorkingBuses().remove(bus);
    }
    
    public void RemovePassenger(Passenger passenger, Bus bus){
        bus.getAssignedPassengers().remove(passenger);
    }
    
    public void ViewPassengers(Bus b){
        System.out.println("The list of passengers:");
        for (int i = 0; i < b.getAssignedPassengers().size();i++) 
            { 		      
                System.out.println(b.getAssignedPassengers().get(i)); 		
            }   
    }
    
    public void ViewDrivers(Bus b){
        System.out.println("The list of Drivers:");
	    for (int i = 0; i < b.AssignedDrivers.size();i++) 
	    { 		      
	        System.out.println(b.AssignedDrivers.get(i)); 		
	    }   
    }
    
    public void AddEventBusSchedule(Bus b ,Schedule s){
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Enter the event ID");
        String ID = myObj.nextLine();
        int i=Integer.parseInt(ID);  
        s.setEventId(i);
        b.AssignBusSchedules(s);
    }
 
}
