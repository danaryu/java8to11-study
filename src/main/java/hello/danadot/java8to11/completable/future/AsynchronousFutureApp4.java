package hello.danadot.java8to11.completable.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AsynchronousFutureApp4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        boolean throwError = false;

        /* ERROR 처리 */

        //exceptionally
        CompletableFuture<String> dana = CompletableFuture.supplyAsync(() -> {
            if(throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello ! " + Thread.currentThread().getName());
            return "DanaDot!!";
        }).exceptionally(ex -> {
            System.out.println("ex = " + ex);
            return "ERROR!!";
        });

        //handle
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if(throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello ! " + Thread.currentThread().getName());
            return "DanaDot!!";
        }).exceptionally(ex -> {
            System.out.println("ex = " + ex);
            return "ERROR!!";
        }).handle((result, ex) -> {
            if(ex != null) {
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });

        System.out.println(hello.get());
/*
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello ! " + Thread.currentThread().getName());
            return "Helloworld!!";
        });
*/
    }

}
