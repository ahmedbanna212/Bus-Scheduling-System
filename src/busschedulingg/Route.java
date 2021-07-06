package busschedulingg;

import java.util.ArrayList;
import java.util.Scanner;

public class Route {
    private int price;
    private ArrayList<String> BusStops;
    private String Destination;

    public Route(int price, ArrayList<String> BusStops, String Destination) {
        this.price = price;
        this.BusStops = BusStops;
        this.Destination = Destination;
    }
    
    public Route(){
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getBusStops() {
        return BusStops;
    }

    public void setBusStops(ArrayList<String> BusStops) {
        this.BusStops = BusStops;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }
      
    public boolean CheckBusRoute(String BusStop){
        if(BusStops.contains(BusStop)){
            System.out.println("This bus stop is already in the route.");
                
            return true;
        }
    else{
        System.out.println("This bus route doesn't have this stop.");
        return false;
        }
    }
    
    public void CreateNewRoute(String BusStop){
        if(!CheckBusRoute(BusStop)){
            Scanner sc = new Scanner(System.in); 
            BusStops.add(BusStop);
            System.out.println("Enter the destination of this route: ");
            Destination = sc.nextLine();
            System.out.println("Enter the price for this route: ");
            price = sc.nextInt();           
        }
        else{
            System.out.println("This bus stop already exists.");
        }
    }
    
}
