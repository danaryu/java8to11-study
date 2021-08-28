package hello.danadot.java8to11.completable.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableApp3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

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

        //invokeAny : 완료된 결과 값이 하나라도 있으면 가져온다
        //Blocking Call
        String futureStr = executorService.invokeAny(Arrays.asList(hello, java, dana));
        System.out.println("futureString = " + futureStr);

        executorService.shutdown();

    }

}
