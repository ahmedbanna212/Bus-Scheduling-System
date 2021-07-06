package busschedulingg;

import java.util.ArrayList;
import java.util.Scanner;

public class BusSchedulingSystem {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        boolean Exit  = true;
        while(Exit){
        System.out.println("------------ Welcome to the Bus Scheduling System ------------");
        System.out.print("\n");       
        System.out.println("------------ Choose menu options ------------");
        System.out.println("1. Manager  \n2. Passenger \n3. Exit Menu");
        int x = sc.nextInt();
        
        switch(x){
            case 1:
                 System.out.println("------------ Enter the login info ------------");
                 System.out.println("Enter your username ");
                 sc.nextLine();
                 String UserName = sc.nextLine();
                 System.out.println("Enter your password ");
                 String Password = sc.nextLine();
                 User user = new User(UserName, Password);
                 int option = user.LoginVerification(UserName, Password);
                 System.out.println(option);
                 
                 switch(option){
                    case 1:
                         Admin admin = Admin.getInstance();
                         System.out.println("------------ Welcome to adminstartion page ------------");
                         System.out.println("Please choose an option");
                         System.out.println("1. View reports \n2. Delete Report \n3. View Drivers");
                         System.out.println("4. View Working Buses \n5. Add Report");
                         int Choice = sc.nextInt();
                         switch(Choice){
                             case 1:
                                 admin.ManageReports(1);
                                 break;
                             case 2:
                                 admin.ManageReports(2);
                                 break;
                             case 3:
                                 admin.ViewDriversBus();
                                 break;
                             case 4: 
                                 admin.ViewWorkingBus();
                                 break;
                             case 5:
                                 System.out.println("Please enter the report \n");
                                 System.out.println("Enter the report id ");
                                 int id = sc.nextInt();
                                 sc.nextLine();
                                 System.out.println("Enter the project description");
                                 String des = sc.nextLine();
                                 Report reports = new Report(id, des);
                                 admin.addreport(reports);
                                 System.out.println("Successfully added report");
                                 break;
                         }
                          break; 
                    case 2:
                         ManageBus manageBuses = new ManageBus();
                         BusManager busManager = new BusManager(manageBuses, "BusManager", 89, "busManager", "4718", "avjkda");                         
                         Bus bus = new Bus(102, 20);
                         System.out.println("------------ Welcome to Bus Manager page ------------");
                         System.out.println("Please choose an option");
                         System.out.println("1. Assign Driver to Bus \n2. Assign Passenger to bus ");
                         System.out.println("3. Add Bus \n4. Disable Bus \n5 Remove Passenger ");
                         System.out.println("6. View Passengers \n7. View Drivers \n8. Add Event Bus Schedule");
                         System.out.println("9. Manage Drivers \n10. Create route \n11. Update event to passenger (Commented)");
                         int choice = sc.nextInt();
                         switch(choice){
                            case 1:
                                 System.out.println("Please enter the driver info");
                                 System.out.println("Enter the driver name");
                                 String naame = sc.nextLine();
                                 System.out.println("Enter the driver id");
                                 int iidd = sc.nextInt();
                                 sc.nextLine();
                                 System.out.println("Enter the driver phone number");
                                 String phoneNUmber = sc.nextLine();
                                 Driver drivers = new Driver(naame, iidd, phoneNUmber, false, "");
                                 busManager.AssignDriverToBus(drivers, bus);
                                 System.out.println("Successfully assigned ");
                                 break;
                                 
                            case 2:
                                System.out.println("Please enter the passenger info");
                                System.out.println("Enter the passenger type ");
                                String type = sc.nextLine();
                                sc.nextLine();
                                System.out.println("Enter the passenger name ");
                                String nname = sc.nextLine();
                                System.out.println("Enter the passenger id");
                                int idd = sc.nextInt();
                                Passenger passenger = new Passenger(type, nname, idd, "Dhsj", "69ad", "aka", bus);
                                busManager.AssignPassengerToBus(passenger, bus);
                                System.out.println("Passenger successfully assigned");
                                break;
                                
                            case 3:
                                System.out.println("Enter the bus id");
                                int bid = sc.nextInt();
                                System.out.println("Enter number of free seats");
                                int freeseats = sc.nextInt();
                                Bus buss = new Bus(bid, freeseats);
                                busManager.AddBus(buss);
                                System.out.println("Bus Successfully added");
                                break;
                                
                            case 4:
                                System.out.println("Enter the bus id and number of free seats to diable");
                                int busid = sc.nextInt();
                                int frreseats = sc.nextInt();
                                Bus bus1 = new Bus(busid, frreseats);
                                busManager.DisableBus(bus1);
                                System.out.println("Bus Successfully disabled");
                                break;
                                
                            case 5:
                                System.out.println("Remove Passenger");
                                break;
                                
                            case 6:
                                busManager.ViewPassengers(bus);
                                break;
                                
                            case 7:
                                busManager.ViewDrivers(bus);
                                break;
                                
                            case 8:
                                System.out.println("Enter the bus to add");
                                System.out.println("Enter bus id and freeseats");
                                int busidd = sc.nextInt();
                                int freeSeatts = sc.nextInt();
                                Bus bus2 = new Bus(busidd, freeSeatts);
                                Driver drivers1 = new Driver("ahmed", 618, "011890222", false, "");
                                Schedule schedules = new Schedule("11:00", "4:00", drivers1, 1);
                                busManager.AddEventBusSchedule(bus2, schedules);
                                System.out.println("Event Schedule successfully added");
                                break;
                                
                            case 9:
                                ManageDriver manageDrivers = new ManageDriver();
                                BusManager busManage1 = new BusManager(manageDrivers, "BusManager", 89, "busManager", "4718", "avjkda");
                                
                                System.out.println("Manage Driver option");
                                System.out.println("1. Remove Driver \n2. Add driver");
                                int opp = sc.nextInt();
                                busManage1.getManageBehaviour().Modify(opp);
                                break;
                                
                            case 10:
                                ArrayList<String> list = new ArrayList<>();
                                list.add("nasr city");
                                list.add("shrouk");
                                Route routes = new Route(702202,list,"Home");
                                System.out.println("Enter the bus stop");
                                String busstop = sc.nextLine();
                                routes.CreateNewRoute(busstop);
                                break;
                                
//                            case 11:
//                                Passenger passenger1 = new Passenger("Name", 35325, "Email Address", "232424", "shrouk");
//                                Event events = new Event();
//                                events.AddObserver(passenger1);
//                                events.UpdateAll(new Message("First Message"));
//                                break;
                        }
                          break;                         
                    case 3:
                        ManageDriver manageDrivers = new ManageDriver();
                        DriverManager driverManager = new DriverManager(manageDrivers, "Belal", 7280, "ahuadi", "adnka", "ajoa");
                         System.out.println("------------ Welcome to Driver Manager page ------------");
                         System.out.println("Please choose an option");
                         System.out.println("1. Hire Driver \n2. Suspend Driver");
                         System.out.println("3. Search red flaged drivers \n4. Manage Buses");
                         int oopt = sc.nextInt();
                         switch(oopt){
                            case 1:
                                 driverManager.HireDriver();
                                 System.out.println("Successfully Hired");
                                 break;
                            case 2:
                                System.out.println("Enter the id of the driver to suspend");
                                int sid = sc.nextInt();
                                driverManager.SuspendDriver(sid);
                                break;
                            
                            case 3:
                                System.out.println("List of red flagged drivers");
                                driverManager.SearchRedFlag();
                                break;
                            case 4:
                                ManageBus manageBuses1 = new ManageBus();
                                DriverManager driverManager1 = new DriverManager(manageBuses1, "Belal", 7280, "ahuadi", "adnka", "ajoa");
                                System.out.println("Manage Bus Options");
                                System.out.println("1. Add Bus \n2. Add Scheule \n3. Add Passenger");
                                int moption = sc.nextInt();
                                driverManager1.getManageBehaviour().Modify(moption);
                                break;
                         }
                         break;  
                         
                    default:
                        System.out.println("Not valid login info");
                        break;
                 }
                 break;
        case 2:
                String n;
                System.out.println("------------ Enter the Registeration info ------------");
                System.out.println("Enter your type \n1. Student \n2. Staff");
                int ttype = sc.nextInt();
                System.out.println("Enter your name");
                String nnamee = sc.nextLine();
                sc.nextLine();
                System.out.println("Enter your id");
                int Paid = sc.nextInt();
                System.out.println("Enter your username");
                String uusername = sc.nextLine();
                sc.nextLine();
                System.out.println("Enter your password");
                String ppassword = sc.nextLine();               
                System.out.println("Enter your address");   
                String addresss = sc.nextLine();
                if(ttype == 1){
                    n = "Student";
                }
                else{
                    n = "Staff";
                }
                Bus bus1 = new Bus(819, 30);
                Passenger passenger = new Passenger(n, nnamee, Paid, uusername, ppassword, addresss, bus1);
                switch(ttype){
                    case 1:
                        System.out.println("------------ Welcome to Passenger page ------------");
                        System.out.println("Please choose an option");
                        System.out.println("1. Subscribe \n2. Cancel Subscription ");
                        System.out.println("3. Update \n4. Report problem \n5. View Bus info");
                        int Poption = sc.nextInt();
                        switch(Poption){
                            case 1:
                                passenger.Subscribe();
                                System.out.println("Successfully subscribed");
                                break;
                            case 2:
                                passenger.CancelSubscription();
                                System.out.println("Successfully cancelled subscription");
                                break;
                            case 3:
                                System.out.println("Enter the option to update");
                                System.out.println("1. Change name \n2. Change Mail \n3. Address \n 4. password");
                                int Coption = sc.nextInt();
                                passenger.UpdateInfo(Coption);
                                break;
                            case 4:
                                passenger.report();
                                break;
                            case 5:
                                passenger.viewBus();
                                break;
                        }
                        break;
                    case 2:
                        Passenger passenger1 = new Passenger(n, nnamee, Paid, uusername, ppassword, addresss,bus1);
                        System.out.println("------------ Welcome to Passenger page ------------");
                        System.out.println("Please choose an option");
                        System.out.println("1. Subscribe \n2. Cancel Subscription ");
                        System.out.println("3. Update \n4. Report problem \n5. View Bus info");
                        int Ppoption = sc.nextInt();
                        switch(Ppoption){
                            case 1:
                                passenger1.Subscribe();
                                System.out.println("Successfully subscripied");
                                break;
                            case 2:
                                passenger1.CancelSubscription();
                                System.out.println("Successfully cancelled subscription");
                                break;
                            case 3:
                                System.out.println("Enter the option to update");
                                System.out.println("1. Change name \n2. Change Mail \n3. Address \n4. password");
                                int Coption = sc.nextInt();
                                passenger1.UpdateInfo(Coption);
                                break;
                            case 4:
                                passenger1.report();
                                break;
                            case 5:
                                passenger1.viewBus();
                                break;
                        }
                }
                break;
    case 3:
        System.exit(0);
        Exit = false;
        break;

    default:
        System.out.println("Please enter a valid option");
        break;
        } 
        }
    }  
}