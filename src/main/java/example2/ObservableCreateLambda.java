package example2;

import base.ExecutableExample;
import rx.Observable;

public class ObservableCreateLambda implements ExecutableExample
{
    public void execute() {
        Observable.create(observer -> {
            if (!observer.isUnsubscribed()) {
                for (int i = 1; i < 5; i++) {
                    observer.onNext(i);
                }
                observer.onCompleted();
            }
        }).subscribe(item -> System.out.println("Next: " + item));
    }
}
