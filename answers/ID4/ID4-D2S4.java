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

public abstract class Vehicle{
	private String VIN;
	private int cc;
	private String transport;


       public abstract void moveVehicle();
       public abstract void horn();

	public Vehicle(String VIN, int cc, String trans){
		this.VIN = VIN;
		this.cc = cc; 
		this.transport = trans;
	}
					
}

public class Car extends Vehicle{
    
     public Car(String VIN, int cc, String trans){
           super(VIN, cc, trans)
     }

     print moveVehicle(){
        System.out.println("Car is moving on "+ trans);
    }

    public horn(){
        System.out.println("Beep!");
    }  
}

public class Truck extends Vehicle{

       public Car(String VIN, int cc, String trans){
           super(VIN, cc, trans)
     }

     print moveVehicle(){
        System.out.println("Truck is moving on "+ trans);
    }

     public horn(){
        System.out.println("BEEP BEEP!");
    } 
}
