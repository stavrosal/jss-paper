enum Transport{
	HIGHWAY,
	RURAL,
	OFF-ROAD
}

public interface Vehicle(){
	private String VIN;
	private int cc;
	private Transport transport;
	
	public void moveVehicle();
	public void horn();
}

public class Car implements Vehicle{
	
	public Car(String VIN, int cc, Transport transport){
		this.VIN = VIN;
		this.cc = cc;
		this.transport = transport
	}
	
	@Override
	public void moveVehicle(){
	if (this.transport == Transport.HIGHWAY){
			System.out.println("Car is moving on highway");
		}
		else if (this.transport == Transport.RURAL)){
			System.out.println("Car is moving on rural road");
		}
		else if (this.transport == Transport.OFF-ROAD)){
			System.out.println("Car is moving off-road");
		}
	}
	
	@Override
	public void horn(){
		System.out.println("Beep!")
	}
}

public class Truck implements Vehicle{
	
	public Truck(String VIN, int cc, Transport transport){
		this.VIN = VIN;
		this.cc = cc;
		this.transport = transport
	}
	
	@Override
	public void moveVehicle(){
			if (this.transport == Transport.HIGHWAY){
			System.out.println("Truck is moving on highway");
		}
		else if (this.transport == Transport.RURAL)){
			System.out.println("Truck is moving on rural road");
		}
		else if (this.transport == Transport.OFF-ROAD)){
			System.out.println("Truck is moving off-road");
		}
	}
	
	@Override
	public void horn(){
		System.out.println("BEEP BEEP!");
	}
}