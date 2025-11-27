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
		System.out.println(this.type+ " is moving on " + this.transport);
		
	}
				

	public void horn(){
		if (type.equals("CAR"){
			System.out.println("Beep!");
		}
		else{
			System.out.println("BEEP BEEP!");
		}
	}
}
