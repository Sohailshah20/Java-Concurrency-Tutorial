package thread_class;

public class MyThread extends Thread{

    /**
     * This approach of extending  a class with Thread class is not recommended.
     * Use Runnable Interface instead.
     */
    @Override
    public void run() {
        System.out.println("USING THE THREAD CLASS "+Thread.currentThread().getName());
    }
}
