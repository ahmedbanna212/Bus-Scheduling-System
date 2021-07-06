package busschedulingg;

public abstract class Employee extends User{
    private ManageBehaviour manageBehaviour;

    public Employee(ManageBehaviour manageBehaviour, String Name, int Id, String Email_Address, String Password, String Address) {
        super(Name, Id, Email_Address, Password, Address);
        this.manageBehaviour = manageBehaviour;
    }
    
    public ManageBehaviour getManageBehaviour() {
        return manageBehaviour;
    }

    public void setManageBehaviour(ManageBehaviour manageBehaviour) {
        this.manageBehaviour = manageBehaviour;
    }
    
}
