public class ThreadAssignment {

    static class Counter {
        int count;
        synchronized void count() {
            for(int i=350;i>0;i--){
                count+=1;
                System.out.println(i);
            }
            System.out.println("FINISH!");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.count();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1= new MyThread(counter);
        t1.start();
        Thread t2= new MyThread(counter);
        t2.start();
        t2.join();
        System.out.println("DONE!");
    }
}
