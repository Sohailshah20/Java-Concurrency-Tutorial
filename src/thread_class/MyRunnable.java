package thread_class;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("CURRENT THREAD: " +Thread.currentThread().getName());
    }
}
