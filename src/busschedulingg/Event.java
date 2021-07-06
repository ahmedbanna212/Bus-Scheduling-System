package busschedulingg;

import java.util.ArrayList;

public class Event implements EventObserver{
    private int Id;
    private String Location;
    private int NumberOfPassengers;
    private ArrayList<Bus> GoingBuses;
    private ArrayList<EventDate> eventDate = new ArrayList();
    private ArrayList<Observer> observer;

    public Event(){
    }
    
    public Event(int Id, String Location, int NumberOfPassengers){
        this.Id = Id;
        this.Location = Location;
        this.NumberOfPassengers = NumberOfPassengers;
    }
    
    public Event(int Id, String Location, int NumberOfPassengers, ArrayList<Bus> GoingBuses, ArrayList<EventDate> eventDate, ArrayList<Observer> observer) {
        this.Id = Id;
        this.Location = Location;
        this.NumberOfPassengers = NumberOfPassengers;
        this.GoingBuses = GoingBuses;
        this.eventDate = eventDate;
        this.observer = observer;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getNumberOfPassengers() {
        return NumberOfPassengers;
    }

    public void setNumberOfPassengers(int NumberOfPassengers) {
        this.NumberOfPassengers = NumberOfPassengers;
    }

    public ArrayList<Bus> getGoingBuses() {
        return GoingBuses;
    }

    public void setGoingBuses(ArrayList<Bus> GoingBuses) {
        this.GoingBuses = GoingBuses;
    }

    public ArrayList<EventDate> getEventDate() {
        return eventDate;
    }

    public void setEventDate(ArrayList<EventDate> eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<Observer> getObserver() {
        return observer;
    }

    public void setObserver(ArrayList<Observer> observer) {
        this.observer = observer;
    }
     
    public void AddEventDate(EventDate Eventdate){
        eventDate.add(Eventdate);
    }
    
    @Override
    public void AddObserver(Observer observer){
        this.observer.add(observer);
    }
    
    @Override
    public void RemoveObserver(Observer observer){
        this.observer.remove(observer);
    }
    
    
    @Override
    public void UpdateAll(Message m){
    for(int i = 0; i < observer.size(); i++){
        observer.get(i).Update(m);
    }
    }
}