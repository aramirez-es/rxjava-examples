package example_event_dispatcher.subscribers;

import rx.Subscriber;

public class AsyncSubscriberExample1 extends Subscriber {
  @Override
  public void onCompleted() {

  }

  @Override
  public void onError(Throwable e) {

  }

  @Override
  public void onNext(Object o) {
    System.out.println(Thread.currentThread().getName());
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Async 1 with sleep!");
  }
}
