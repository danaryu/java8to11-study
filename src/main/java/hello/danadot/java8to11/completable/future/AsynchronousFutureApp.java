package hello.danadot.java8to11.completable.future;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynchronousFutureApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // callBack
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return "danadotttt";
        }).thenApply((str) -> {
            System.out.println(Thread.currentThread().getName());
            return str.toUpperCase(Locale.ROOT);
        });
       //.thenAccept((str) -> {}); 결과값을 리턴하지 않음
       //.thenRun(() -> {}); 결과 값을 참고할 필요도 없는 경우...

        // future가 get을 호출하기 전에, 위의 코드처럼 다른 작업이 가능함
        System.out.println("supplyAsync.get() = " + supplyAsync.get());

    }


}
