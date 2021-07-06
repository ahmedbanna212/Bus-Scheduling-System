package busschedulingg;

import java.util.ArrayList;
import java.util.Random;

public class Bus implements ScheduleReadOnly{
    
    private ArrayList<Schedule> schedules;
    private ArrayList<Passenger> AssignedPassengers;
    private int Id;
    private int FreeSeats;
    private ArrayList<Route> routes;
    public ArrayList<Driver> AssignedDrivers = new ArrayList();
    
    public Bus(int Id, int FreeSeats) {
        schedules = new ArrayList<>();
        AssignedPassengers = new ArrayList<>();
        routes = new ArrayList<>();
        this.Id = Id;
        this.FreeSeats = FreeSeats;
    }
   
    public Bus(ArrayList<Schedule> schedules, ArrayList<Passenger> AssignedPassengers, int Id, int FreeSeats, ArrayList<Route> routes) {
        this.schedules = schedules;
        this.AssignedPassengers = AssignedPassengers;
        this.Id = Id;
        this.FreeSeats = FreeSeats;
        this.routes = routes;
    }

    public int getFreeSeats() {
        return FreeSeats;
    }

    public void setFreeSeats(int FreeSeats) {
        this.FreeSeats = FreeSeats;
    }    

    
        public ArrayList<Driver> getAssignedDrivers() {
        return AssignedDrivers;
    }

    public void setAssignedDrivers(ArrayList<Driver> AssignedDrivers) {
        this.AssignedDrivers = AssignedDrivers;
    }
    
    public void getRoutes() {
        routes.forEach((route) -> {
            System.out.println(route);
        });
    }

      public ArrayList<Route> getRoute() {
      return routes;
    }

    
    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }

    public void getSchedules() {
        schedules.forEach((schedule) -> {
            System.out.println(schedule);
        });
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<Passenger> getAssignedPassengers() {
        return AssignedPassengers;
    }
  

    public void setAssignedPassengers(ArrayList<Passenger> AssignedPassengers) {
        this.AssignedPassengers = AssignedPassengers;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public void AddPassenger(Passenger passenger){
       if(AssignedPassengers.contains(passenger)){
           System.out.println("This passenger is already assigned to this bus.");
       }
       else {
           AssignedPassengers.add(passenger);
       }
    }
    
    public void AssignBusRout(Route routes){
        if(this.routes.contains(routes)){
           System.out.println("This bus already goes through this route.");
       }
       else {
           this.routes.add(routes);
       }
    }
    
    public void AssignBusSchedules(Schedule schedule){
        if(CheckBusSchedules(schedule)){
           System.out.println("This schedule is already assigned to this bus.");
       }
       else {
       this.schedules.add(schedule);
            System.out.println("Schedule added successfully.");
       }
    }
    
    public boolean CheckBusSchedules(Schedule schedule){
        if(this.schedules.contains(schedule)){
            System.out.println("This schedule already exists.");
            return true;
        }
        else{
            System.out.println("This schedule is assigned to a bus yet.");
            return false;
        
        }
    }
    
    public void GetBusGps(){
        int minLatitude = -90;
        int maxLatitude = 90;
        int minLongitude = -180;
        int maxLongitude = 180;
        Random rng = new Random();
        double latitude = minLatitude + rng.nextInt(maxLatitude-minLatitude+1);
        double longitude = minLongitude + rng.nextInt(maxLongitude-minLongitude+1);
  
 
        System.out.println("Latiude: "+latitude);
        System.out.println("Longitude: "+longitude);
    }
    
    @Override
    public void ViewBus(){ 
        for(int i = 0; i < schedules.size(); i++){
            System.out.println(schedules.get(i).getArrivesAt());
            System.out.println(schedules.get(i).getLeavesAt());
            System.out.println(schedules.get(i).getRoute().getDestination());
        }
    }
    
    public void Viewpassangers(){ 
        for(int i = 0; i < AssignedPassengers.size(); i++){
            System.out.println(AssignedPassengers.get(i).getName());
            System.out.println(AssignedPassengers.get(i).getId());
            System.out.println(AssignedPassengers.get(i).getType());
        }
    }
}
