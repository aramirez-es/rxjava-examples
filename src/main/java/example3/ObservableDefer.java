package example3;

import base.ExecutableExample;
import rx.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ObservableDefer implements ExecutableExample
{
    public void execute() {
//        Observable<Long> notDeferredObservable = Observable.interval(1L, TimeUnit.SECONDS);
        Observable<Integer> notDeferredObservable = Observable.create(observer -> {
            System.out.println("Creating a non defer observable.");

//            observer.onNext((new Random()).nextInt());
            for (int i = 0; i < 10; i++) {
                observer.onNext(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            observer.onCompleted();
        });

        Observable<Integer> deferredObservable = Observable.defer(
            () -> {
                System.out.println("Creating a defer observable.");
                return Observable.create(observer -> {
                    for (int i = 0; i < 10; i++) {
                        observer.onNext(i);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {}
                    }
                    observer.onCompleted();
                });
            }
        );

        System.out.println("Subscribe to a non deferred observable");
        notDeferredObservable.subscribe(item -> {
            System.out.println("Subscriber1: " + item);
            System.out.println("");
        });

        System.out.println("Subscribe to a deferred observable");
        deferredObservable.subscribe(item -> {
            System.out.println("Deferred Subscriber1: " + item);
            System.out.println("");
        });


        try {
            System.out.println("Awaiting for 5 seconds...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        System.out.println("Subscribe to a non deferred observable");
        notDeferredObservable.subscribe(item -> {
            System.out.println("Subscriber2: " + item);
            System.out.println("");
        });

        System.out.println("Subscribe to a deferred observable");
        deferredObservable.subscribe(item -> {
            System.out.println("Deferred Subscriber2: " + item);
            System.out.println("");
        });
    }
}
