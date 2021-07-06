package busschedulingg;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    private static Admin admin = null;
    private ArrayList<Passenger> SubscripedPassengers;
    private ArrayList<Bus> WorkingBuses;
    private ArrayList<Report> reports;
    private ArrayList<Driver> drivers;
    
    private Admin(String Name, int Id, String Email_Address, String Password, String Address){
        super(Name, Id, Email_Address, Password, Address);
        SubscripedPassengers = new ArrayList<>();
        WorkingBuses = new ArrayList<>();
        reports = new ArrayList<>();
        drivers = new ArrayList<>();
    }
    
    private Admin(ArrayList<Passenger> SubscripedPassengers, ArrayList<Bus> WorkingBuses, String Name, int Id, String Email_Address, String Password, String Address) {
        super(Name, Id, Email_Address, Password, Address);
        this.SubscripedPassengers = SubscripedPassengers;
        this.WorkingBuses = WorkingBuses;
    }

    public ArrayList<Bus> getWorkingBuses() {
        return WorkingBuses;
    }

    public void setWorkingBuses(ArrayList<Bus> WorkingBuses) {
        this.WorkingBuses = WorkingBuses;
    }

    public ArrayList<Passenger> getSubscripedPassengers() {
        return SubscripedPassengers;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setSubscripedPassengers(ArrayList<Passenger> SubscripedPassengers) {
        this.SubscripedPassengers = SubscripedPassengers;
    }
   
    public static Admin getInstance(){  
    if(admin == null){
        admin = new Admin("Ahmed", 1, "admin@bus.com", "admin1234", "Home");    
    }
    return admin;
    }
    
    public void ViewReports(){
        reports.stream().map((report) -> {
            System.out.println(report.getId());
            return report;
        }).forEachOrdered((report) -> {
            System.out.println(report.getDescription());
        });
        
    }
    
    public void DeleteReport(int Id){
        
         for(int i = 0; i< reports.size();i++){
                if(reports.get(i).getId()==Id){
                reports.remove(i);
                }
        }
    }
    
    public void ManageReports(int option){
        Scanner sc = new Scanner (System.in);
        switch(option){
            case 1:
                ViewReports();
                break;
            case 2:
                System.out.println("Enter the id ");
                int x = sc.nextInt();
                DeleteReport(x);
                break;
        };
        
    }
        
    public void ViewDriversBus(){
        for(int i = 0; i < drivers.size(); i++){
            System.out.println(drivers.get(i).getName());  
        
        }
    }
        
    public void ViewWorkingBus(){
        for(int i = 0; i < WorkingBuses.size(); i++){
            System.out.println(WorkingBuses.get(i).getId());  
            System.out.println(WorkingBuses.get(i).getFreeSeats());  
        }
    }
    
    public Bus FindBusIdexBbyID(int id){
        for(int i=0;i<WorkingBuses.size();i++){
            if(WorkingBuses.get(i).getId()==id){  
                return WorkingBuses.get(i);
            }
        }    
        return null;
    }
       
    public Driver FindDriverIdexBbyID(int id){
        for(int i=0;i<drivers.size();i++){
            if(drivers.get(i).getId()==id){
                return drivers.get(i);    
            }
        } 
        return null;
    }
            
       
    public Passenger FindPassangerIdexBbyID(int id){
        for(int i = 0;i<SubscripedPassengers.size();i++){
            if(SubscripedPassengers.get(i).getId()==id){
                return SubscripedPassengers.get(i);
            }
        }    
        return null;
    }
       
    public void addreport(Report a){
        reports.add(a);
    }
    
    public Route searchRoutes(String desc){
        
       for(int i=0;i<admin.getWorkingBuses().size();i++){
           for(int j=0;j<admin.getWorkingBuses().get(i).getRoute().size();j++){  
               if(admin.getWorkingBuses().get(i).getRoute().get(j).getDestination().equals(desc)){
                   return admin.getWorkingBuses().get(i).getRoute().get(j);
               }
           }    
       }
        return null;
    }
}
    

