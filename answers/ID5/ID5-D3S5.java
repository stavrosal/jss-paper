import java.util.*;

interface StateMachine {
    void start();
    boolean isFinished();
    void execute();
    void finish();
    void run(); // default behavior
}

abstract class AbstractStateMachine implements StateMachine {
    protected int threshold;
    protected int counter;

    public AbstractStateMachine(int threshold) {
        this.threshold = threshold;
        this.counter = 0;
    }

    public void run() {
        start();
        while (!isFinished()) {
            execute();
        }
        finish();
    }
}

// ============================
// DivisibleNumbersMachine
// ============================
class DivisibleNumbersMachine extends AbstractStateMachine {

    public DivisibleNumbersMachine(int threshold) {
        super(threshold);
    }

    @Override
    public void start() {
        System.out.println("Starting to find numbers divisible by 4 until " + threshold);
    }

    @Override
    public boolean isFinished() {
        return counter >= threshold;
    }

    @Override
    public void execute() {
        if (counter % 4 == 0) {
            System.out.println(counter + " is divisible by 4");
        }
        counter++;
    }

    @Override
    public void finish() {
        System.out.println("DivisibleNumbersMachine finished.");
    }
}

// ============================
// PushDownAutomaton
// ============================
class PushDownAutomaton extends AbstractStateMachine {

    private List<Integer> stack;

    public PushDownAutomaton(int threshold) {
        super(threshold);
        this.stack = new ArrayList<>();
    }

    @Override
    public void start() {
        System.out.println("Started pushing numbers up to " + threshold + " to stack");
    }

    @Override
    public boolean isFinished() {
        return counter >= threshold;
    }

    @Override
    public void execute() {
        stack.add(counter);
        counter++;
    }

    @Override
    public void finish() {
        int sum = stack.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum = " + sum);
        System.out.println("PushDownAutomaton finished.");
    }
}

// ============================
// Χρήση
// ============================
public class Main {
    public static void main(String[] args) {
        StateMachine machine1 = new DivisibleNumbersMachine(20);
        StateMachine machine2 = new PushDownAutomaton(10);

        machine1.run();
        machine2.run();
    }
}
