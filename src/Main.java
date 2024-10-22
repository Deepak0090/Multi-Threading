import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//class MyRunnable implements Runnable{
//    public void run(){
//        System.out.println("Thread is running - "+Thread.currentThread().getName());
//    }
//}
//class Mytask implements Runnable{
//    private String taskname;
//    private String symbol;
//    public Mytask(String taskname , String symbol){
//          this.taskname=taskname;
//          this.symbol=symbol;
//    }
//    @Override
//    public void run(){
//        for (int i=0; i<=100; i++){
//            System.out.println(symbol+" "+i+" Executing in thrade"+Thread.currentThread().getName());
//        }
//    }
//}
//class MyThread extends Thread{
//    public MyThread(String name){
//        super(name);
//    }
//    @Override
//    public void run(){
//        for(int i=0; i<10; i++){
//            Date date = new Date();
//             System.out.println("Execution "+(i+1)+" on thread"+Thread.currentThread().getName()+ date.toString());
//             try {
//                 Thread.sleep(1000);
//             }catch (InterruptedException e){
//                 e.printStackTrace();
//             }
//        }
//    }
//}
//class Resourse{
//    private final String name;
//    public Resourse(String name){
//        this.name=name;
//    }
//    public  void method1 (Resourse other){
//        System.out.println(Thread.currentThread().getName()+" acquire lock on "+ this.name );
//        System.out.println(Thread.currentThread().getName()+" trying to acquire lock on "+other.name);
//        other.method2();
//    }
//    public synchronized void method2(){
//        System.out.println(Thread.currentThread().getName()+"acquire lock on "+this.name);
//    }
//    @Override
//    public String toString(){
//        return this.name;
//    }
//}
 class Counter{
     private int count =0;
     public void increment(){
         count++;
     }
     public int getCount(){
         return count;
     }
}
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello and welcome!");
        System.out.println("This thread is " + Thread.currentThread().getName());

//        Thread thrade1 = new Thread(new MyRunnable(), "Thread-1");
//        Thread threade2 = new Thread(new MyRunnable(),"Thread-2");
//        thrade1.start();
////        threade2.start();
//        Thread thrade1 = new Thread(new Mytask("task1","❤"));
//        Thread thread2 = new Thread(new Mytask("task2","💖"));
//        thrade1.start();
////        thread2.start();
//        Thread thread1 = new Thread(new MyThread("My Threade"));
//        thread1.start();
//        Resourse r1 = new Resourse("R1");
//        Resourse r2 = new Resourse("R2");
//        Thread t1 = new Thread(() -> {
//            r1.method1(r2);
//        });
//        Thread t2 = new Thread(() -> {
//            r2.method1(r1);
//        });
//        t1.start();
//        t2.start();
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i=0; i<100; i++){
                System.out.println("💖");
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i<100; i++){
                System.out.println("♥");
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}