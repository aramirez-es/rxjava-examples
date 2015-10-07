package example_event_dispatcher.subscribers;

import rx.Subscriber;

public class AsyncSubscriberExample2 extends Subscriber {
  @Override
  public void onCompleted() {

  }

  @Override
  public void onError(Throwable e) {

  }

  @Override
  public void onNext(Object o) {
    System.out.println(Thread.currentThread().getName());
    System.out.println("Async 2");
  }

}
