package hello.danadot.java8to11.completable.concurrent;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            System.out.println("Thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }


            /*
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
/*
            while(true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("interrupted!!!");
                    return;
                }
            }
*/
        });

        thread.start();

        System.out.println("Hello!: " + Thread.currentThread().getName());
        // 기다릴 thread에 join
        thread.join();
        System.out.println(thread + "is finished");

        //Thread.sleep(3000L);
        //thread.interrupt();
    }
/*
    static class MyThread extends Thread {
        
        @Override
        public void run() {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        }
        
    }
    */
    
}
