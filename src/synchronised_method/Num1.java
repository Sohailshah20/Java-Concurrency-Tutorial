package synchronised_method;

public class Num1 implements Runnable {
    /*
    This simple class has only one variable num that gets incremented and decremented.
     */
    private int num = 0;

    @Override
    public void run() {
        /*
        This method first increments the value from 0 to 1 and then decrements from 1 to 0.
        The synchronized code block only allows one thread at a time to execute the code.
        'this' keyword is used to define the key. In this case the instance of this class itself is
        used as a key by the JVM, But any object value can be passed as a key.
         */
        synchronized (this) {
            increment();
            System.out.println(Thread.currentThread().getName() + " Value after increment is : " + getNum());
            decrement();
            System.out.println(Thread.currentThread().getName() + " Value after decrement is : " + getNum());
        }

    }

    public void increment() {
        num++;
    }

    public void decrement() {
        num--;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
