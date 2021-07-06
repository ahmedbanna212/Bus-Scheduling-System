package busschedulingg;

public  class Report {
    private int Id;
    private String Description;

    public Report(int Id, String Description) {
        this.Id = Id;
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }
 
 
public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
 
}
