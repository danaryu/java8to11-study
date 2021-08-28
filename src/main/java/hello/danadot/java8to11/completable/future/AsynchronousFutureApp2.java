package hello.danadot.java8to11.completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynchronousFutureApp2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> dana = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello ! " + Thread.currentThread().getName());
            return "DanaDot!!";
        });

        //resultofdana -> dana future가 return한 값
        CompletableFuture<String> future = dana.thenCompose(AsynchronousFutureApp2::getHelloworld);

        System.out.println("future.get() = " + future.get());

    }

    private static CompletableFuture<String> getHelloworld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(message + " Helloworld! " + Thread.currentThread().getName());
            return message + " heloworld!!";
        });
    }

}
