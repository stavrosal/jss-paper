public abstract class Vehicle{
	private String VIN;
	private int cc;
	private Road road;
	
	public Vehicle(String VIN, int cc,, Road road ){
		this.VIN = VIN;
		this.cc = cc;
		this.road = road;
	}
	
	public abstract void moveVehicle(){				

	public abstract void horn()
}

public class Car extend Vehicle{

    //constructor
    public void moveVehicle() {
        System.out.println("Car is moving on " +road.getName());
    }

    public void horn() {
        System.out.println("Beep!");
    }

}
public class truck extend Vehicle{
    //constructor

     public void moveVehicle() {
        System.out.println("Truck is moving on " +road.getName();
    }

    public void horn() {
	System.out.println("BEEP BEEP!");
    }
}

public class Road{
    private String name;

    public String getName(){
	return name;
    }
}
