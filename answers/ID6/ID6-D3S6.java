// Interface defining the strategy for state machine behavior
interface MachineStrategy {
    void start();
    boolean isFinished();
    void execute();
    void finish();
}

// Concrete strategy for DivisibleNumbersMachine
class DivisibleNumbersMachine implements MachineStrategy {
    private int counter;
    private int threshold;

    public DivisibleNumbersMachine(int threshold) {
        this.threshold = threshold;
        this.counter = 0;
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
        System.out.println("Automaton finished");
    }
}

// Concrete strategy for PushDownAutomaton
class PushDownAutomaton implements MachineStrategy {
    private int counter;
    private int threshold;
    private List<Integer> stack;

    public PushDownAutomaton(int threshold) {
        this.threshold = threshold;
        this.counter = 0;
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
        System.out.println("Automaton finished");
    }
}

// Context class that uses the strategy
public class StateMachine {
    private MachineStrategy strategy;

    public StateMachine(MachineStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        strategy.start();
        while (!strategy.isFinished()) {
            strategy.execute();
        }
        strategy.finish();
    }

    // Optional: Allow changing strategy at runtime
    public void setStrategy(MachineStrategy strategy) {
        this.strategy = strategy;
    }

    // Example main method to demonstrate usage
    public static void main(String[] args) {
        // Create a DivisibleNumbersMachine
        StateMachine divisibleMachine = new StateMachine(new DivisibleNumbersMachine(10));
        divisibleMachine.run();

        // Create a PushDownAutomaton
        StateMachine pushDownMachine = new StateMachine(new PushDownAutomaton(10));
        pushDownMachine.run();
    }
}