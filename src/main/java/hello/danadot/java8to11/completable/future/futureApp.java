package hello.danadot.java8to11.completable.future;

import java.util.concurrent.*;

public class futureApp {

    /**
     * future에서 하기 어렵던 작업들
     * future를 외부에서 완료시킬 수 없다. 취소하거나, get()에 timeout을 실행할 수는 있다.
     * Blocking Code(get())를 사용하지 않고는, 작업이 끝났을 때 콜백을 실행할 수 없다.
     * 여러 Future를 조합할 수 없다. 예) Event정보 가져온 다음, Event에 참석하는 회원 목록 가져오기
     * 예외 처리용 API를 제공하지 않는다.
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.completedFuture("dana");
        System.out.println("future.get() = " + future.get());

        /* 1. 비동기로 작업 실행하기 */
        // return값이 없을 때
        CompletableFuture<Void> futureAsync = CompletableFuture.runAsync(() -> System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()));

        System.out.println("futureAsync.get() = " + futureAsync.get());

        // return Type이 있는 경우
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return "DANADOTTT";
        });

        System.out.println("supplyAsync.get() = " + supplyAsync.get());

    }
}
