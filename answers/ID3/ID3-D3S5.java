import java.util.ArrayList;
import java.util.List;

// Abstract base class defining the skeleton
public abstract class StateMachine {
    protected int counter = 0;
    protected int threshold;

    public StateMachine(int threshold) {
        this.threshold = threshold;
    }

    public void run() {
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

// Concrete implementation for DivisibleNumbersMachine
class DivisibleNumbersMachine extends StateMachine {

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
        System.out.println("Automaton finished");
    }
}

// Concrete implementation for PushDownAutomaton
class PushDownAutomaton extends StateMachine {
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
        stack.add(counter);
        counter++;
    }

    @Override
    protected void finish() {
        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        System.out.println("Sum = " + sum);
        System.out.println("Automaton finished");
    }
}
