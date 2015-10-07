package example_event_dispatcher.core;


import rx.Subscriber;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class AsyncEventDispatcher {

    private PublishSubject<Object> subject;


    public AsyncEventDispatcher() {
        this.subject = PublishSubject.create();

    }

    public void dispatch(String message){
        this.subject.onNext(message);
    }

    public void addSubscriber(Subscriber subscriber){
        subject.observeOn(Schedulers.computation()).subscribe(subscriber);
    }
}
