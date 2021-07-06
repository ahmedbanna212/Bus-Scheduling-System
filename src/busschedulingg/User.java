package busschedulingg;

public class User {
    private String Name;
    private int Id;
    private String UserName;
    private String Password;
    private String Address;
    
    public User(String UserName, String Password){
        this.UserName = UserName;
        this.Password = Password;
    }

    public User(String Name, int Id, String UserName, String Password, String Address) {
        this.Name = Name;
        this.Id = Id;
        this.UserName = UserName;
        this.Password = Password;
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public int LoginVerification(String username, String password){
        int x = 0;
        
        String name = "admin";
        String pass = "1234";
        
        String name2 = "BusManager";
        String pass2 = "7896";
        
        String name3 = "DriverManager";
        String pass3 = "6182";
        
        if(name.equals(username) && pass.equals(password)){
            x =  1;
        }
        if (name2.equals(username) && pass2.equals(password)){
            x = 2;
        }
        if (name3.equals(username) && pass3.equals(password)){
            x = 3;
        }       
        return x;
    }    
}
