package hello.danadot.java8to11.completable.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AsynchronousFutureApp3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> dana = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello ! " + Thread.currentThread().getName());
            return "DanaDot!!";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello ! " + Thread.currentThread().getName());
            return "Helloworld!!";
        });


        CompletableFuture<Integer> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello ! " + Thread.currentThread().getName());
            return 1;
        });

        // 서로가 서로에게 의존적이지 않은 경우 : Combine (조합)
        // dana 실행 후, combine
        CompletableFuture<String> future = dana.thenCombine(world, (resultofdana, resultofworld) -> resultofdana + " " + resultofworld);
        System.out.println("future.get() = " + future.get());

        // subtask가 모두 끝났을 때...
        CompletableFuture<Void> futureVoid = CompletableFuture.allOf(dana, world)
                .thenAccept(System.out::println);


        System.out.println("futureVoid = " + futureVoid.get());

        // task들의 결과 값을 Collection으로..?
        List<CompletableFuture> futures = Arrays.asList(dana, hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        System.out.println("futuresArray = " + futuresArray);
        
        CompletableFuture<List<Object>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList()));

        results.get().forEach(System.out::println);

        // 아무거나 .. 빨리끝나는 작업 하나 받아서 get.......
        CompletableFuture<Void> future001 = CompletableFuture.anyOf(hello, dana, world).thenAccept(System.out::println);
        System.out.println("future001.get() = " + future001.get());

    }

}
