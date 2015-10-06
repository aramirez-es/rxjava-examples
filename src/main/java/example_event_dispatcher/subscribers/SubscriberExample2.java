package example_event_dispatcher.subscribers;

import example_event_dispatcher.events.ExampleEvent;
import rx.Subscriber;

public class SubscriberExample2<T extends ExampleEvent> extends Subscriber<T> {
  @Override
  public void onCompleted() {
    System.out.println("Completed invoked! Pipeline broken");
  }

  @Override
  public void onError(Throwable e) {

  }

  @Override
  public void onNext(T t) {

    System.out.println("Subscriber2!!");
    t.getPipelineEventDispatcher().complete();

    //we are not calling the next subscriber, we broke the pipeline!
//    PipelineEventDispatcher eventDispatcher = t.getPipelineEventDispatcher();
//    eventDispatcher.dispatch("Subscriber2!!");

  }

}
