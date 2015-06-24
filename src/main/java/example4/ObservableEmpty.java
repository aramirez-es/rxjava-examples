package example4;

import base.ExecutableExample;
import rx.Observable;

public class ObservableEmpty implements ExecutableExample
{
    public void execute() {
        Observable.empty().subscribe(
                item -> System.out.println("This will never happen"),
                (error) -> System.out.println("This will never happen"),
                () -> System.out.println("Observable was completed")
        );
    }
}
