package daemon_thread;

import java.time.Duration;
import java.util.Scanner;

public class DaemonThread {
    /*
     *There are two kinds of threads which based on priority.
     * 1. Low priority threads - Daemon threads
     * 2. High priority threads - User threads
     * By default when you create a new thread instance and start it, it is a user thread
     * To make a user thread into a daemon thread, on the thread instance set true in the setDaemon() method
     */

    public static void main(String[] args) {
        /*
         * Run this method. Everytime you enter a number a new thread is created which goes into 20 sec sleep.
         * Try entering a few numbers and enter 0. When you enter zer, the loop is supposed to break and the
         * program should terminate. But instead the program continues to run until all the threads
         * finish their execution (thread sleep of 20 seconds)
         *
         * This happens because by default the threads created are user threads, that are high priority threads.
         * The application main thread always waits for the completion of user threads.
         *
         * We can change this behaviour by setting true the set daemon property. Uncomment the setDaemon property
         * and run the program again.
         *
         * Try entering a few numbers and in the end enter 0. The application will immediately terminate
         * because all the threads were set to daemon threads. The main application thread
         * doesn't wait for the completion of daemon threads - low priority threads.
         *
         */
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number :");
            int n = sc.nextInt();
            if (n == 0) break;
            System.out.println("You Entered " + n + " and the thread is still running ");
            Runnable r = () -> {

                try {
                    Thread.sleep(Duration.ofSeconds(20).toMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.start();
        }
    }
}
