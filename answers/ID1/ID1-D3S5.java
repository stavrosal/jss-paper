/*
We want to simulate a system of FiniteStateMachines.
There are a lot of FSMs where each one performs an operation.
After a machine starts (start()), it runs until a finish 
condition is met (isFinished()), and the finish method 
is called (finish()). For now, our system has two machines:
A DivisibleNumbersMachine, where it calculates all numbers 
divisible by 4 up to a threshold (specified by the user)
and a PushDownAutomaton, where it calculates the sum of
numbers up to a threshold (specified by the user). The 
PushDown Machine has an ArrayList<Integer> as a stack. 
*/

public class StateMachine{
	String name;
	String machineType;
	
	private int counter;
	
	private int threshold;
	
	private List<Integer> stack;
	
	public StateMachine(int thresh, String machine){
		this.threshold = thresh;
		this.machineType = machine;
		this.counter = 0;
		if (machineType.equals("PushDownAutomaton")){
			this.stack = new ArrayList<Integer>();
		}
	}
	
	public void run(){
		start();
		while (!isFinished()){
			execute();
		}
		finish();
	}
	
	public void start(){
		if (machineType.equals("DivisibleNumbersMachine")){
			System.out.println("Starting to find numbers divisible by 4 until " + threshold);
		}
		else if (machineType.equals("PushDownAutomaton")){
			System.out.println("Started pushing numbers up to " + threshold + " to stack");
		}
	}
		
	public boolean isFinished(){
		return counter >= threshold;
	}
	
	public void execute(){
		if (machineType.equals("DivisibleNumbersMachine")){
			if (counter % 4 == 0){
				System.out.println(counter + " is divisible by 4");
			}
			counter++;
		}
		else if (machineType.equals("PushDownAutomaton")){
			stack.add(counter);
			counter++;
		}
	}
			
	public void finish(){
		if (machineType.equals("DivisibleNumbersMachine")){
			System.out.println("Automaton finished");
		}
		else if (machineType.equals("PushDownAutomaton")){
			int sum = 0;
			for (int num : stack){
				sum += num;
			}
			System.out.println("Sum = " + sum);
			System.out.println("Automaton finished");
		}
	}
}
