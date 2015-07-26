package example3;

import rx.Observable;

public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creation methods like 'just' or 'from' store data when the observable is created, not when subscribed.
     * This doesn't mean that it starts emitting values on creation. It's still a cold observable.
     */
    public Observable<String> justObservable() {
        return Observable.just(name);
    }

    /**
     * Defer do not create the Observable until a Subscriber subscribes (lambda inside defer won't be executed until Subscriber subscribes).
     * Waiting until the last minute (that is, until subscription time) to generate the Observable can ensure that this Observable contains the freshest data.
     * Defer creates a fresh Observable on each subscription.
     */
    public Observable<String> deferredJustObservable() {
        return Observable.defer(() -> Observable.just(name));
    }

    /**
     * Lambda inside create won't be executed until subscription either. It re-uses the same function for all subscriptions.
     * Create will emit the current name when subscribed (cold observable).
     * Downside: Verbose.
     */
    public Observable<String> createObservable() {
        return Observable.create(
                subscriber -> {
                    subscriber.onNext(name);
                    subscriber.onCompleted();
                }
        );
    }
}
