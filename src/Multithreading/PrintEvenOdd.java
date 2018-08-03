package Multithreading;

import java.util.concurrent.locks.Lock;

public class PrintEvenOdd {

    static class PrintNumber implements Runnable{

        int print_num_upto  =10;
        int remainder ;
      static int number = 1;
       static Object lock = new Object();

        public PrintNumber(int remainder){
            this.remainder = remainder;
        }

        @Override
        public void run() {
            synchronized (lock){
            while(number <= print_num_upto){

                    if(number%2 != remainder){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                System.out.println(Thread.currentThread().getName() + "-- " + number);
                    number++;
                    lock.notifyAll();
                }

            }

        }
    }

    public static void main(String[] args) {
        PrintNumber odd = new PrintNumber(1);
        PrintNumber even = new PrintNumber(0);

        Thread t1 = new Thread(odd,"odd");
        Thread t2 = new Thread(even,"even");

        t1.start();
        t2.start();
    }
}
