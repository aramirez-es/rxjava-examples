package example7;

import base.ExecutableExample;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.concurrent.TimeUnit;

public class FlatMapOperator implements ExecutableExample {

    private final String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };

    @Override
    public void execute() {
        TestSubscriber testSubscriber = new TestSubscriber();

        Observable.range(1,10)
            .flatMap(this::transformIntToStringUsingDelayOperator)
            .doOnNext(System.out::println)
            .subscribe(testSubscriber)
            ;
        testSubscriber.awaitTerminalEvent();

        testSubscriber = new TestSubscriber();
        Observable.range(1,10)
                .concatMap(this::transformIntToStringUsingDelayOperator)
                .doOnNext(System.out::println)
                .subscribe(testSubscriber)
        ;

        testSubscriber.awaitTerminalEvent();

        System.out.println("**transformIntToStringUsingMainThread **");

        testSubscriber = new TestSubscriber();
        Observable.range(1,10)
                .flatMap(this::transformIntToStringUsingMainThread)
                .doOnNext(System.out::println)
                .subscribe(testSubscriber)
        ;

        testSubscriber.awaitTerminalEvent();

    }

    private Observable<String> transformIntToStringUsingMainThread(int value) {

        System.out.println("FLATMAP IN THREAD:"+Thread.currentThread().getName());

        if (2 == value) {
            return Observable.from(importantInfo)
                    .map(data -> value+"-"+data)
                    ;
        } else {
            return Observable.from(importantInfo)
                    .map(data -> value+"-"+data)
                    ;
        }
    }

    private Observable<String> transformIntToStringUsingDelayOperator(int value){

        System.out.println("FLATMAP IN THREAD:"+Thread.currentThread().getName());

        if (2 == value) {
            return Observable.from(importantInfo)
                    .map(data -> value+"-"+data)
                    .delay(4,TimeUnit.SECONDS);
        } else {
            return Observable.from(importantInfo)
                    .map(data -> value+"-"+data)
                    .delay(1,TimeUnit.SECONDS);
        }
    }



}
