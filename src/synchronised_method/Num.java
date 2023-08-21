package synchronised_method;

public class Num implements Runnable {
    /*
    This simple class has only one variable num that gets incremented and decremented.
     */
    private int num = 0;

    @Override
    public void run() {
        /*
        This method first increments the value from 0 to 1 and then decrements from 1 to 0.
        But when multiple threads call this method the num value is not guaranteed to go from 0 to  and
        then 1 to 0. Sometimes the num value does not even decrement to 0.
         */
        increment();
        System.out.println(Thread.currentThread().getName() + " Value after increment is : " + getNum());
        decrement();
        System.out.println(Thread.currentThread().getName() + " Value after decrement is : " + getNum());

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
