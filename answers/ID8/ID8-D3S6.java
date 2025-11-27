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

public abstract class StateMachine {
    protected int threshold;
    protected int counter;

    public StateMachine(int threshold) {
        this.threshold = threshold;
        this.counter = 0;
    }

    public final void run() {
        start();
        while (!isFinished()) {
            execute();
        }
        finish();
    }

    protected abstract void start();
    protected abstract boolean isFinished();
    protected abstract void execute();
    protected abstract void finish();
}

public class DivisibleNumbersMachine extends StateMachine {

    public DivisibleNumbersMachine(int threshold) {
        super(threshold);
    }

    @Override
    protected void start() {
        System.out.println("Starting to find numbers divisible by 4 until " + threshold);
    }

    @Override
    protected boolean isFinished() {
        return counter >= threshold;
    }

    @Override
    protected void execute() {
        if (counter % 4 == 0) {
            System.out.println(counter + " is divisible by 4");
        }
        counter++;
    }

    @Override
    protected void finish() {
        System.out.println("DivisibleNumbersMachine finished");
    }
}

import java.util.ArrayList;
import java.util.List;

public class PushDownAutomaton extends StateMachine {
    private List<Integer> stack;

    public PushDownAutomaton(int threshold) {
        super(threshold);
        this.stack = new ArrayList<>();
    }

    @Override
    protected void start() {
        System.out.println("Started pushing numbers up to " + threshold + " to stack");
    }

    @Override
    protected boolean isFinished() {
        return counter >= threshold;
    }

    @Override
    protected void execute() {
        stack.add(counter++);
    }

    @Override
    protected void finish() {
        int sum = stack.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum = " + sum);
        System.out.println("PushDownAutomaton finished");
    }
}
