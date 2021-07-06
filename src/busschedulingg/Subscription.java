package busschedulingg;


public class Subscription {
    private int Id;
    private Route routes;
    private String StartDate;
    private String EndDate;
    private Passenger passenger;
    private int AssignedBus;

     public Subscription(int Id, Route routes, String StartDate, String EndDate,  int AssignedBus) {
        this.Id = Id;
        this.routes = routes;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.AssignedBus = AssignedBus;
    }
    
    public Subscription(int Id, Route routes, String StartDate, String EndDate, Passenger passenger, int AssignedBus) {
        this.Id = Id;
        this.routes = routes;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.passenger = passenger;
        this.AssignedBus = AssignedBus;
    }

    public int getAssignedBus() {
        return AssignedBus;
    }

    public void setAssignedBus(int AssignedBus) {
        this.AssignedBus = AssignedBus;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Route getRoutes() {
        return routes;
    }

    public void setRoutes(Route routes) {
        this.routes = routes;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
    public boolean CheckSubscription(String EndDate, Passenger passenger){
    
        return !"30/6/2021".equals(getEndDate());     
    }

}
