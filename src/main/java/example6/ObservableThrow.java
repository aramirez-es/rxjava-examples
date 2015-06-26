package example6;

import base.ExecutableExample;
import rx.Observable;

public class ObservableThrow implements ExecutableExample
{
    public void execute() {
        Observable.error(new Exception("Whatever")).subscribe(
            item -> System.out.println("No items"),
            error -> System.err.println(error),
            () -> System.out.println("Never happen")
        );
    }
}
