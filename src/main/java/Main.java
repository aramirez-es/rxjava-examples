import base.ExecutableExample;

public class Main {
    private enum Examples {
        EXAMPLE1 (example1.ObservableCreate.class),
        EXAMPLE2 (example2.ObservableCreateLambda.class),
        EXAMPLE_EVENT_DISPATCHER (example_event_dispatcher.EventDispatcherExample.class),
        EXAMPLE4 (example4.ObservableEmpty.class),
        EXAMPLE5 (example5.ObservableNever.class),
        EXAMPLE6 (example6.ObservableThrow.class),
        EXAMPLE7 (example7.FlatMapOperator.class),

        ;

        private Class classToExecute = example1.ObservableCreate.class;

        Examples(Class classToExecute) {
            this.classToExecute = classToExecute;
        }
    }
    public static void main(String[] args) {
        try {
            String exampleToExecute = System.getProperty("example", "example1").toUpperCase();
            Class toExecute = Examples.valueOf(exampleToExecute).classToExecute;
            ((ExecutableExample) toExecute.getConstructor().newInstance()).execute();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Don't troll, mother f*cker!");
        }
    }
}
