public interface FiniteStateMachine {
    void start();
    boolean isFinished();
    void execute();
    void finish();
}

public class DivisibleNumbersMachine implements FiniteStateMachine {
    private int counter = 0;
    private final int threshold;

    public DivisibleNumbersMachine(int threshold) {
        this.threshold = threshold;
    }

    public void start() {
        System.out.println("Starting to find numbers divisible by 4 until " + threshold);
    }

    public boolean isFinished() {
        return counter >= threshold;
    }

    public void execute() {
        if (counter % 4 == 0) {
            System.out.println(counter + " is divisible by 4");
        }
        counter++;
    }

    public void finish() {
        System.out.println("Automaton finished");
    }
}

public class PushDownAutomaton implements FiniteStateMachine {
    private int counter = 0;
    private final int threshold;
    private final List<Integer> stack = new ArrayList<>();

    public PushDownAutomaton(int threshold) {
        this.threshold = threshold;
    }

    public void start() {
        System.out.println("Started pushing numbers up to " + threshold + " to stack");
    }

    public boolean isFinished() {
        return counter >= threshold;
    }

    public void execute() {
        stack.add(counter++);
    }

    public void finish() {
        int sum = stack.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum = " + sum);
        System.out.println("Automaton finished");
    }
}

public class StateMachineRunner {
    private final FiniteStateMachine machine;

    public StateMachineRunner(FiniteStateMachine machine) {
        this.machine = machine;
    }

    public void run() {
        machine.start();
        while (!machine.isFinished()) {
            machine.execute();
        }
        machine.finish();
    }
}
