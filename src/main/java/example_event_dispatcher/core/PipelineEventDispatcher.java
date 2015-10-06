package example_event_dispatcher.core;

import example_event_dispatcher.events.ExampleEvent;
import java.util.ArrayList;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.PublishSubject;

public class PipelineEventDispatcher {

  private PublishSubject<ExampleEvent> subject;
  private ArrayList<Subscriber> subscribers;
  private Subscription subscription;
  private int subscriberIndex = 0;

  public PipelineEventDispatcher() {
    this.subject = PublishSubject.create();
    this.subscribers = new ArrayList();
  }


  public void dispatch(String message){
    ExampleEvent exampleEvent = new ExampleEvent(message,this);
    if (subscriberIndex > 0) {
      this.subscription.unsubscribe();
    }

    try {
      Subscriber currentSubscriber = this.subscribers.get(subscriberIndex++);
      this.subscription = this.subject.subscribe(currentSubscriber);
      this.subject.onNext(exampleEvent);
    }catch(IndexOutOfBoundsException e){
      this.subject.onCompleted();
    }

  }

  public void addSubscriber(Subscriber subscriber){
    this.subscribers.add(subscriber);
  }

  public void complete(){
    this.subject.onCompleted();
    this.subscription.unsubscribe();
  }




}
