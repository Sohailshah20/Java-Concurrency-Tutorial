package thread_class;

public class Main {
    /**
     * The instance of a thread class is used create a new thread.
     * The Thread class implements the Runnable interface.
     * As a standard and recommended practice always use the Runnable interface by implementing in your classes
     * or by using enhanced syntax discussed below.
     */

    public static void main(String[] args) {

        /**
         * We can just call the start method on the thread class instance to create  a new Thread
         */
        new MyThread().start();

        /**
         * Directly running a run method of a class instance that implements
         * a Runnable interface runs on the main thread
         */
        Runnable myRunnable = new MyRunnable();
        myRunnable.run();

        /**
         * A Thread class constructor takes a runnable instance as parameter
         * Creating a new thread object by passing a runnable instance and
         * then staring the thread run the run() method of MyRunnable class instance
         * in a new thread
         */
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        /**
         * We might not want or have any class implementing a Runnable interface that needs to be executed
         * in a different thread.
         * For that we can just create an inline runnable class like below.
         */

        Runnable myRunnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("CURRENT THREAD USING INLINE CLASS: " +Thread.currentThread().getName());
            }
        };
        myRunnable2.run();

        //Passing the new inline instance to a new thread
        Thread myThread2 = new Thread(myRunnable2);
        myThread2.start();

        /**
         * The Runnable interface is functional interface, we can simplify the syntax more by
         * using the lambda expression
         */
        Runnable myRunnable3 = () -> System.out.println("CURRENT THREAD USING LAMBDA: " +Thread.currentThread().getName());
        myRunnable3.run();

        //Passing the new Runnable instance created using lambda to a new thread
        Thread myThread3 = new Thread(myRunnable3);
        myThread3.start();

        /**
         * Directly creating and passing the lambda in the thread constructor
         */
        new Thread(
                () -> System.out.println("CURRENT THREAD USING LAMBDA WITHIN THREAD: " +Thread.currentThread().getName())
        ).start();
    }
}
