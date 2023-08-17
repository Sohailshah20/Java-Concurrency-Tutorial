package thread_lifecycle;

import java.time.Duration;
import java.util.Scanner;

public class ControlThreads {
    /*
     * We already know how to start a thread by calling the start() method on a thread instance.
     * Let's sleep(), join(), and interrupt() methods.
     */

    public static void main(String[] args) {
//        sleepDemo();
//        joinDemo();
        interruptDemo();
    }


    public static void sleepDemo() {
        /*
          The Thread.sleep() method is used to make a thread wait for a certain amount of time
          The sleep() method is a static method in Thread class.
         */
        Runnable r = () -> {
            while (true) {
                try {
                    System.out.println("Thread is running");
                    Thread.sleep(Duration.ofSeconds(2).toMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    public static void joinDemo() {
    /*
      The thread.join() method is used to wait for a thread to complete its execution.
      It makes the calling thread wait until the thread on which it's called terminates.
     */
        Runnable r1 = () -> {
            try {
                System.out.println("Thread 1 is running");
                Thread.sleep(Duration.ofSeconds(5).toMillis());
                System.out.println("Thread 1 has completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable r2 = () -> {
            try {
                System.out.println("Thread 2 is running");
                Thread.sleep(Duration.ofSeconds(10).toMillis());
                System.out.println("Thread 2 has completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();

        /*
        Once a thread has been joined to caller thread, any work that has to be done on the caller
        thread executes only after the joined threads have completed their work.
         */
        try {
            thread1.join(); // Wait for thread1 to complete
            System.out.println("Thread 1 has joined");

            thread2.join(); // Wait for thread2 to complete
            System.out.println("Thread 2 has joined");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
            The below print statement is present on the main thread and only
            executes after the joined threads have completed their work
         */
        System.out.println("Main thread continues after both threads have completed.");
    }

    public static void interruptDemo() {
        /*
        We can stop a running thread by calling the thread.interrupt() method on the thread
        instance. By calling the method we notify that thread needs to stop running.
        But the threads doesn't immediately stop running.
        We can check if a thread has been interrupted using the static method Thread.interrupted()
        If a thread is interrupted we can gracefully stop it by cleaning any resources or take any
        appropriate action
         */
        Runnable r = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        };

        Thread t = new Thread(r);
        t.start();

        //simulating the thread to do work for a while before calling interrupt
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Interrupt the thread
        t.interrupt();
    }
}
