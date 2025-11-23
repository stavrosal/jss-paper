public class Vehicle{
	private String VIN;
	private int cc;
	private String type;
	private String transport;
	
	public Vehicle(String VIN, int cc, String type, String trans){
		this.VIN = VIN;
		this.cc = cc;
		this.type = type;
		this.transport = trans;
	}
	
	public  void moveVehicle(){
		if (type.equals("CAR")){
			if (transport.equals("HIGHWAY"){
				System.out.println("Car is moving on highway");
			}
			else if (transport.equals("RURAL")){
				System.out.println("Car is moving on rural road");
			}
			else if (transport.equals("OFF-ROAD")){
				System.out.println("Car is moving off-road");
			}
		}
		else if (type.equals("TRUCK")){
			if (transport.equals("HIGHWAY"){
				System.out.println("Truck is moving on highway");
			}
			else if (transport.equals("RURAL")){
				System.out.println("Truck is moving on rural road");
			}
			else if (transport.equals("OFF-ROAD")){
				System.out.println("Truck is moving off-road");
			}
		}
	}
				

	public void horn(){
		if (type.equals("CAR"){
			System.out.println("Beep!");
		}
		else if (type.equals("TRUCK"){
			System.out.println("BEEP BEEP!");
		}
	}
}

