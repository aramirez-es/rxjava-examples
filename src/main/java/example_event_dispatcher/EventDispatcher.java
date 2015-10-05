package example_event_dispatcher;


import rx.subjects.BehaviorSubject;

public class EventDispatcher{

    private BehaviorSubject<Object> subject;

    public EventDispatcher(BehaviorSubject<Object> subject) {
        this.subject = BehaviorSubject.create();
    }

    public void dispatch(String message){
        this.subject.subscribe();
        this.subject.onNext(message);
    }
}
