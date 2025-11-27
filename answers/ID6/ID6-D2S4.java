public class Vehicle{
	private String VIN;
	private int cc;
	private VehcleFactory strat;
	
	public Vehicle(String VIN, int cc,VehcleFactory strategy){
		this.VIN = VIN;
		this.cc = cc;
		this.strat=strategy;
	}
	
	public  void moveVehicle(){
		strat.move();
	}
				

	public void horn(){
		strat.horn();
	}
}
interface VehcleFactory{
	void move();
	void horn();
}

class CarStrategy implements VehcleFactory{
	private String transport;
	
	public CarStrategy(String transport){
		this.transport = transport;
	}
	
	@override
	public move(){
		System.out.println("Car is moving " + transport.toLowerCase());
	}	
	@override
	public horn(){
		System.out.println("Beep");
	}
}

class TruckStrategy implements VehcleFactory{
	private String transport;
	
	public TruckStrategy(String transport){
		this.transport = transport;
	}
	
	@override
	public move(){
		System.out.println("Truck is moving " + transport.toLowerCase());
	}	
	@override
	public horn(){
		System.out.println("Beep Beep");
	}
}