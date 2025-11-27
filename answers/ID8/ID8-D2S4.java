/*
We want to model a system that stores vehicles.
All vehicles have some common attributes, like
VIN number (unique) (String) and engine size 
in cubic centimeters (cc) (int). There are
2 types of vehicles (Car and Truck) where the
type is saved in a String field. Each vehicle
can only move on a specific type of road. There
are 3 types of roads (Highway, rural, off-road).
Each vehicle has 2 actions (methods). The first 
one moves the vehicle (moveVehicle), and its a 
void method with no parameters that prints a message
of the following format:
"<Vehicle Type> is moving on <Road Type>"
There is also a horn method, which is void and also
takes no parameter and just prints a horn imitation
sound ("Beep!") for cars and a louder sound 
("BEEP BEEP!") for trucks.
*/

public enum VehicleType {
	Car("Beep!"),
	Truck("BEEP BEEP!");

	private final String hornSound;

    Transport(String hornSound) {
        this.hornSound = hornSound;
    }

	public String getHornSound() {
		return hornSound;
	}
}

public enum Transport {
	Highway("Highway"),
	RuralRoad("Rual Road"),
	OffRoad("Off Road");

	private final String displayName;

    Transport(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

public class Vehicle{
	private String VIN;
	private int cc;
	private VehicleType type;
	private Transport transport;

	public Vehicle(String VIN, int cc, VehicleType type, Transport trans){
		this.VIN = VIN;
		this.cc = cc;
		this.type = type;
		this.transport = trans;
	}

	public void moveVehicle(){
		System.out.println(String.format("%s is moving on %s", type.name(), transport.toString()));
	}

	public void horn(){
		System.out.println(type.getHornSound());
	}
}
