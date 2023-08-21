package synchronised_method;

public class Run_Count {

    public static void main(String[] args) {
//        withoutSynchronized();
        withSynchronized();
    }

    public static void withoutSynchronized(){
        /*
        The same code in the run block is executed in multiple threads.
        Call this method and see the num value. It is not guaranteed to decrement to 0 as multiple threads
        execute it at the same time.
         */
        Num num = new Num();
        new Thread(num, "T1").start();
        new Thread(num, "T2").start();
        new Thread(num, "T3").start();
        /*
        When you run this method and see the values you'll find inconsistent value increment and decrement
        every time you run.
        This is called a race condition.
         */
    }
    public static void withSynchronized(){
        /*
        The same code in the run block is executed in multiple threads.
        In this case the code in the run method is synchronized as the num object itself is passed as
        a key for the threads to acquire.
         Call this method, and you will see that the num value is always decremented to 0 as only one
         thread executes the code in the synchronized block.
         */
        Num1 num = new Num1();
        new Thread(num, "T1").start();
        new Thread(num, "T2").start();
        new Thread(num, "T3").start();
        /*
        Passing 'this' as synchronized key parameter makes sures that the object instance is itself is used
        as key.
        When you run you'll see that the threads below didn't need to wait for the above threads
        to access the run method as the key is applied to individual object instance and not the method itself.
         */
        Num1 num1 = new Num1();
        new Thread(num, "T4").start();
        new Thread(num, "T5").start();

    }
}
