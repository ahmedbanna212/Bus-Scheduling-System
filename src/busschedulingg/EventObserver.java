package busschedulingg;

public interface EventObserver {
    public void AddObserver(Observer observer);
    public void RemoveObserver(Observer observer);  
    public void UpdateAll(Message m);
}