package hello.danadot.java8to11.completable.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableApp2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> dana = () -> {
            Thread.sleep(1000L);
            return "Dana";
        };

        //invokeAll은 모든 future가 끝날 때 까지 기다림
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, dana));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();

    }

}
