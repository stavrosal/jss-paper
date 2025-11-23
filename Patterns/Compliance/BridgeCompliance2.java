/* All vehichles have some common attributes
 * like VIN number and cc. Each vehicle 
 * can move in specific roads (highway,
 * rural and off-road) which are specified
 * by a Transport object 
 */
 

public abstract class Transport{
	public abstract void moveCar();
	public abstract void moveTruck();
}

public class Highway extends Transport{
	public void moveCar(){
		System.out.println("Car is moving on highway");
	}
	
	public void moveTruck(){
		System.out.println("Truck is moving on highway");
	}
}

public class Rural extends Transport{
	public void moveCar(){
		System.out.println("Car is moving on rural road");
	}
	
	public void moveTruck(){
		System.out.println("Truck is moving on rural road");
	}
}

public class Offroad extends Transport{
	public void moveCar(){
		System.out.println("Car is moving off-road");
	}
	
	public void moveTruck(){
		System.out.println("Truck is moving off-road");
	}
}
	

	

public abstract class Vehicle{
	protected String VIN;
	protected int cc;
	protected Transport trans;
	
	public Vehicle(String VIN, int cc, Transport trans){
		this.VIN = VIN;
		this.cc = cc;
		this.trans = trans;
	}
	
	public abstract void moveVehicle();

	public abstract void horn();
}


public class Car extends Vehicle{
	
	public Car(String VIN, int cc, Transport trans){
		super(VIN,cc,trans);
	}
	
	@Override
	public void moveVehicle(){
		trans.moveCar();
	}
	
	public void horn(){
		System.out.println("Beep!");
	}
}


public class Truck extends Vehicle{
	
	public Truck(String VIN, int cc, Transport trans){
		super(VIN,cc,trans);
	}
	
	@Override
	public void moveVehicle(){
		trans.moveTruck();
	}
	
	public void horn(){
		System.out.println("BEEP BEEP!");
	}
}
