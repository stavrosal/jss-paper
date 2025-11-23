public abstract class StateMachine{
	String name;
	
	public void run(){
		start();
		while (!isFinished()){
			execute();
		}
		finish();
	}
	
	public abstract void start();
	public abstract boolean isFinished();
	public abstract void execute();
	public abstract void finish();

}

public class DivisibleNumbersMachine extends StateMachine{
	private int threshold;
	private int counter;
	
	public FiniteStateMachine(int threshold){
		this.threshold = threshold;
		this.counter = 0;
	}
	
	public void start(){
		System.out.println("Starting to find numbers divisible by 4 until " + threshold);
	}
	
	public boolean isFinished(){
		return counter >= threshold;
	}
	
	public void execute(){
		if (counter % 4 == 0){
			System.out.println(counter + " is divisible by 4");
		}
		counter++;
	}
	
	public void finish(){
		System.out.println("Automaton finished");
	}
		

}

public class PushDownAutomaton extends StateMachine{
	private List<Integer> stack;
	private int stackSize;
	private int counter;
	
	public PushDownAutomaton(int size){
		this.stackSize = size;
		this.counter = 0;
	}
	
	public void start(){
		System.out.println("Started pushing numbers up to " + stackSize + " to stack");
	}
	
	public boolean isFinished(){
		return counter >= stackSize;
	}
	
	public void execute(){
		stack.add(counter);
		counter++;
	}
	
	public void finish(){
		int sum = 0;
		for (int num : stack){
			sum += num;
		}
		System.out.println("Sum = " + sum);
		System.out.println("Automaton finished");
	}
	
}
