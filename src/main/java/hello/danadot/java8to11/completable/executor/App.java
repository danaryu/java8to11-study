package hello.danadot.java8to11.completable.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 계속 대기, 명시적인 Shutdown 필요
        executorService.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));

        executorService.shutdown();

        ScheduledExecutorService executorService01 = Executors.newSingleThreadScheduledExecutor();
        executorService01.scheduleAtFixedRate(getRunnable("hello"), 1, 2, TimeUnit.SECONDS);

        Executors.newSingleThreadExecutor();

        /*
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread " + Thread.currentThread().getName());
                }
            });
        */
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }

}
