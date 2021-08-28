package hello.danadot.java8to11.completable.callable;

import java.util.concurrent.*;

public class CallableApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println("submit = " + submit.isDone());

        System.out.println("Started !!");

        // 결과 값을 가질 때 까지 기다림. Blocking
        System.out.println("submit.get() = " + submit.get());
        // 작업 취소 true:
        submit.cancel(true);

        System.out.println("submit = " + submit.isDone());

        //작업이 cancel되어서 가져올 수 없음
        //submit.get();

        System.out.println("End!!!");

        executorService.shutdown();

    }

}
