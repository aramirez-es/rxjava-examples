package example5;

import base.ExecutableExample;
import rx.Observable;

public class ObservableNever implements ExecutableExample
{
    public void execute() {
        Observable.never().subscribe(
            item -> System.out.println("Does not happen ever"),
            error -> System.out.println("Does not happen ever"),
            () -> System.out.println("Does not terminate ever")
        );
    }
}
