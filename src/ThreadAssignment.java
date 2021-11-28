public class ThreadAssignment {

    static class Counter {
        int count;
        void count() {
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
        public synchronized void run() {
            counter.count();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1= new MyThread(counter);
        Thread t2= new MyThread(counter);
        t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        t2.start();
        try{
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("DONE!");
    }
}
