package standardOfJava.chapter13_thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThreadExample {
    static long startTime = 0;

    @Test
    @DisplayName("runnable 실행")
    void example1() {
        Runnable r = new MyRunnable();  // runnable을 구현한 클래스의 인스턴스를 생성
        Thread thread = new Thread(r);  // Thread 생성자
        // new Thread(new MyRunnable());
        thread.start();
    }

    @Test
    @DisplayName("thread 는 한번만 실행된다.")
    void onceRun() {
        Thread thread = new Thread(new MyRunnable());

        Exception exception = assertThrows(IllegalThreadStateException.class,() -> {
            thread.start();
            thread.start();
        });

        new Thread(new MyRunnable()).start();
    }

    @Test
    @DisplayName("싱글쓰레드 성능 예제")
    void singleThread() {
        long startTime = System.currentTimeMillis();
        for (int i=0; i <300; i++) {
            System.out.printf("%s", "-");
        }
        System.out.println("소요시간1 : " + (System.currentTimeMillis()-startTime));

        for (int i=0; i <300; i++) {
            System.out.printf("%s", "|");
        }
        System.out.println("소요시간2 : " + (System.currentTimeMillis()-startTime));
    }

    @Test
    @DisplayName("멀티쓰레드 성능 예제")
    void multiThread() {

        Thread thread = new Thread(() -> {
            for (int i=0; i <300; i++) {
                System.out.printf("%s", "|");
            }
            System.out.println("소요시간2 : " + (System.currentTimeMillis() - ThreadExample.startTime));
        });

        ThreadExample.startTime = System.currentTimeMillis();
        thread.start();

        for (int i=0; i <300; i++) {
            System.out.printf("%s", "-");
        }
        System.out.println("소요시간1 : " + (System.currentTimeMillis() - ThreadExample.startTime));
    }

    @Test
    void IOBlocking() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("input = " + input);


    }
}
