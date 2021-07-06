package busschedulingg;


public class Schedule {    
    private String LeavesAt;
    private String ArrivesAt;
    private int EventId;
    private Route route;

    public Schedule(String LeavesAt, String ArrivesAt,Driver drivers, int EventId) {
        this.LeavesAt = LeavesAt;
        this.ArrivesAt = ArrivesAt;
        this.EventId = EventId;
    }
       public Schedule(String LeavesAt, String ArrivesAt,Driver drivers) {
        this.LeavesAt = LeavesAt;
        this.ArrivesAt = ArrivesAt;
        this.EventId = 0;
    }

    public Route getRoute() {
        return route;
    }  
       
    public int getEventId() {
        return EventId;
    }

    public void setEventId(int EventId) {
        this.EventId = EventId;
    }

    public String getLeavesAt() {
        return LeavesAt;
    }

    public void setLeavesAt(String LeavesAt) {
        this.LeavesAt = LeavesAt;
    }

    public String getArrivesAt() {
        return ArrivesAt;
    }

    public void setArrivesAt(String ArrivesAt) {
        this.ArrivesAt = ArrivesAt;
    }
    
}
