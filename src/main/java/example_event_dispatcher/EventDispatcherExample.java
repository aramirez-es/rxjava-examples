package example_event_dispatcher;

import base.ExecutableExample;
import example_event_dispatcher.core.AsyncEventDispatcher;
import example_event_dispatcher.core.PipelineEventDispatcher;
import example_event_dispatcher.subscribers.AsyncSubscriberExample1;
import example_event_dispatcher.subscribers.AsyncSubscriberExample2;
import example_event_dispatcher.subscribers.SubscriberExample1;
import example_event_dispatcher.subscribers.SubscriberExample2;
import example_event_dispatcher.subscribers.SubscriberExample3;

public class EventDispatcherExample implements ExecutableExample {
    @Override
    public void execute() {


        AsyncEventDispatcher asyncEventDispatcher = new AsyncEventDispatcher();
        asyncEventDispatcher.addSubscriber(new AsyncSubscriberExample1());
        asyncEventDispatcher.addSubscriber(new AsyncSubscriberExample2());
        asyncEventDispatcher.dispatch("Message async");




        PipelineEventDispatcher eventDispatcher = new PipelineEventDispatcher();
        eventDispatcher.addSubscriber(new SubscriberExample1());
        eventDispatcher.addSubscriber(new SubscriberExample2());
        eventDispatcher.addSubscriber(new SubscriberExample3());
        eventDispatcher.dispatch("Myevent!");

        // Needed to see async subscribers finish their job!
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
