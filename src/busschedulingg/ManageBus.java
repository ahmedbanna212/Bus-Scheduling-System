package busschedulingg;

import java.util.Scanner;

public class ManageBus implements ManageBehaviour {
    
    private Admin admin;
    
    public void AddBus(int id, int freeseats){
        Bus bus = new Bus(id, freeseats);
        //For Testing
        Driver drivers = new Driver("AHNSJS", 122, "1729081", true, "anka");
        Schedule schedules = new Schedule("11:00", "1:00", drivers, 1);
        bus.AssignBusSchedules(schedules);
        bus.ViewBus();
        admin = Admin.getInstance();
        admin.getWorkingBuses().add(bus);
    }
    
    public void AddSchedule(int Busid,int Did,String leavesAt,String arrivesAt){
        admin = Admin.getInstance();
        Schedule x=new Schedule(leavesAt,arrivesAt,admin.FindDriverIdexBbyID(Did));
        admin.FindBusIdexBbyID(Busid).AssignBusSchedules(x);
    }
    
    public void AddPassenger(int PID,int BusID){
        admin = Admin.getInstance();
        admin.FindBusIdexBbyID(BusID).AddPassenger(admin.FindPassangerIdexBbyID(PID));
    }
    
    @Override
    public void Modify(int option){
         
        Scanner sc = new Scanner (System.in);
        switch(option){
            case 1:
                System.out.println("Enter the bus ID");
                int id = sc.nextInt();
                System.out.println("Enter the number of seats in bus");
                int freeSeats = sc.nextInt();
                AddBus(id, freeSeats);
                break;
                
            case 2:
                System.out.println("Enter Bus iD");
                int Bid = sc.nextInt();
                System.out.println("Enter driver iD");
                int Did=sc.nextInt();
                sc.nextLine();
                System.out.println("When does the Bus leave");
                String leavesat=sc.nextLine();
                System.out.println("When does the Bus arrive");
                String arrivesat=sc.nextLine();
                      
                AddSchedule(Bid,Did,leavesat,arrivesat);
                break;
                
            case 3:
                System.out.println("what is the passanger ID");     
                int PID=sc.nextInt();
                System.out.println("what is his BUS ID");
                int BID=sc.nextInt();
                AddPassenger(PID, BID);
                break;
        }
    }
}
