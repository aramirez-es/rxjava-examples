package example_event_dispatcher.subscribers;

import rx.Subscriber;

public class SubscriberExample1 extends Subscriber {
    @Override
    public void onCompleted() {
        System.out.println(this.getClass().getName()+" Completed!");
    }

    @Override
    public void onError(Throwable e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void onNext(Object o) {
        System.out.println("subscriber 1");
    }
}
