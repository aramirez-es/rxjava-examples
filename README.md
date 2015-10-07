# RxJava Examples

Just a list of examples found in official documentation: http://reactivex.io/documentation/operators.html

## How to execute

```java
./gradlew run -Dexample=example1
```

### Example 1
Create an Observable from scratch, by using create operator and then by calling the observer's ```onNext```,  ```onError``` and  ```onComplete```.

### Example 2
Like Example 1 but using lambdas instead.

### Example 4
Create an Observable that emits no items but terminates normally.

### Example "example_event_dispatcher"
It creates:
* An asynchronous event dispatcher, using PublishSubject from Rx, that executes all subscriber asynchronously (in Computation Scheduler). On the other hand, subscriber extend from Subscriber (form Rx) what means that they follow a well-known interface.
* A sequential pipeline that it executes a set of ordered Subscribers synchronously. Subscribers also extend from Subscriber (Rx) class so that implements method like ```onNext```, ```onError``` and ```onCompleted```. Subscriber may break the pipeline o continue the circuit. 