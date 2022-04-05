package standardOfJava.chapter13_thread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {

        System.out.println("current Thread :" + Thread.currentThread().getName());
        for (int i=0; i<5; i++) {
            System.out.println("i = " + i);
        }
    }
}
