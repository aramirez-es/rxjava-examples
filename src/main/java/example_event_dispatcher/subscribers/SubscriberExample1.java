package example_event_dispatcher.subscribers;

import example_event_dispatcher.core.PipelineEventDispatcher;
import example_event_dispatcher.events.ExampleEvent;
import rx.Subscriber;

public class SubscriberExample1<T extends ExampleEvent> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        System.out.println(this.getClass().getName()+" Completed!");
    }

    @Override
    public void onError(Throwable e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void onNext(T o) {
        System.out.println("subscriber 1 String");

        PipelineEventDispatcher eventDispatcher = o.getPipelineEventDispatcher();
        eventDispatcher.dispatch("Subscriber1!!");

    }
}
