import java.util.ArrayList;
import java.util.List;

// Template / Strategy Interface
abstract class FiniteStateMachine {
    protected int counter = 0;
    protected int threshold;

    public FiniteStateMachine(int threshold) {
        this.threshold = threshold;
    }

    public final void run() {
        start();
        while (!isFinished()) {
            execute();
        }
        finish();
    }

    protected abstract void start();
    protected boolean isFinished() {
        return counter >= threshold;
    }
    protected abstract void execute();
    protected abstract void finish();
}

// FSM Type 1: DivisibleNumbersMachine
class DivisibleNumbersMachine extends FiniteStateMachine {
    public DivisibleNumbersMachine(int threshold) {
        super(threshold);
    }

    @Override
    protected void start() {
        System.out.println("Starting to find numbers divisible by 4 until " + threshold);
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

// FSM Type 2: PushDownAutomaton
class PushDownAutomaton extends FiniteStateMachine {
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
        System.out.println("PushDownAutomaton finished");
    }
}

// Runner Class
public class Main {
    public static void main(String[] args) {
        FiniteStateMachine fsm1 = new DivisibleNumbersMachine(20);
        FiniteStateMachine fsm2 = new PushDownAutomaton(10);

        fsm1.run();
        System.out.println("-----");
        fsm2.run();
    }
}