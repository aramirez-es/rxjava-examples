package example3;

import base.ExecutableExample;
import rx.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ObservableDefer implements ExecutableExample
{
    public void execute() {
        Person person = new Person();

        Observable<String> justObservable = person.justObservable();
        Observable<String> deferredJustObservable = person.deferredJustObservable();
        Observable<String> createdObservable = person.createObservable();

        /**
         * Since we set the name of the person after the observables were created,
         * only the 'deferred' and 'created' version have the name "John" emitted to subscribers.
         */
        person.setName("John");

        justObservable.subscribe(s -> System.out.println("Just: " + s));
        deferredJustObservable.subscribe(s -> System.out.println("Deferred: " + s));
        createdObservable.subscribe(s -> System.out.println("Create: " + s));
    }
}
