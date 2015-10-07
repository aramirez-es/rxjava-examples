package example_event_dispatcher.subscribers;

import example_event_dispatcher.core.PipelineEventDispatcher;
import example_event_dispatcher.events.ExampleEvent;
import rx.Subscriber;

public class SubscriberExample3<T extends ExampleEvent> extends Subscriber<T> {
  @Override
  public void onCompleted() {

  }

  @Override
  public void onError(Throwable e) {

  }

  @Override
  public void onNext(T t) {

    System.out.println("Subscriber3!!");
    PipelineEventDispatcher eventDispatcher = t.getPipelineEventDispatcher();
    eventDispatcher.dispatch("Subscriber3!!");

  }

}
