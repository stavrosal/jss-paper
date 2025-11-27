abstract class StateMachine {
    public void run() {
        start();
        while (!isFinished()) {
            execute();
        }
        finish();
    }

    protected abstract void start();
    protected abstract void execute();
    protected abstract boolean isFinished();
    protected abstract void finish();
}

// Machine that finds numbers divisible by 4
class DivisibleNumbersMachine extends StateMachine {
    private int counter = 0;
    private final int threshold;

    public DivisibleNumbersMachine(int threshold) {
        this.threshold = threshold;
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
    protected boolean isFinished() {
        return counter >= threshold;
    }

    @Override
    protected void finish() {
        System.out.println("Automaton finished");
    }
}

// Machine that uses a stack and computes the sum
class PushDownAutomaton extends StateMachine {
    private int counter = 0;
    private final int threshold;
    private final List<Integer> stack = new ArrayList<>();

    public PushDownAutomaton(int threshold) {
        this.threshold = threshold;
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
    protected boolean isFinished() {
        return counter >= threshold;
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

// Main class
public class Main {
    public static void main(String[] args) {
        StateMachine machine1 = new DivisibleNumbersMachine(20);
        machine1.run();

        System.out.println("-----------");

        StateMachine machine2 = new PushDownAutomaton(10);
        machine2.run();
    }
}