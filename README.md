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

### Example 7
This example is generating a range of 10 elements and for every element we generate four Strings with the prefix of integer range and the String itself, let's put an example:
We have this important info
```java
 private final String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };
```
And we have an Observable generating 10 int elements
```java
TestSubscriber testSubscriber = new TestSubscriber();

        Observable.range(1,10)
            .flatMap(this::transformIntToStringUsingDelayOperator)
            .doOnNext(System.out::println)
            .subscribe(testSubscriber)
            ;
        testSubscriber.awaitTerminalEvent();
```
The expected behaviour is see something like this
```
1-Mares eat oats
1-Does eat oats
1-Little lambs eat ivy
1-A kid will eat ivy too

2-Mares eat oats
2-Does eat oats
2-Little lambs eat ivy
2-A kid will eat ivy too
```
A demonstration of how using FlatMap operator you could get unordered elements.
* The first example is using a function inside FlatMap that is generating elements with an Observable with Delay operator,
```java
    return Observable.from(importantInfo)
        .map(data -> value+"-"+data)
        .delay(1,TimeUnit.SECONDS);
```
this means that the operation of emitting the four elements will run in the Computation Scheduler and the MERGE operator inside FlatMap is not controlling the order of elements coming.

* The second example uses ConcatMap operator and is taking care of the order of the elements.
* The last example is using FlatMap operator again but this time is generating all elements in order because there is no Scheduling strategy and all is running in main thread.