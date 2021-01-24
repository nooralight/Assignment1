package dekker;

public class Main {
    private static volatile boolean flag0 = false;
    private static volatile boolean flag1 = false;
    private static volatile int turn = 0;

    private static long count = 0;
    private static long count0 = 0;
    private static long count1 = 0;
    private static final long limit = 2*1000*1000;


    public static void main(String[] args) throws InterruptedException {

        Thread t0 = new Thread(new Runnable () {
            public void run() {
                while (true) {
                    // acquire
                    flag0 = true;
                    while (flag1) {
                         if (turn != 0) {
                             flag0 = false;
                             while (turn != 0) {
                             }
                             flag0 = true;
                         }
                    }
                    // critical section
                    ++count0;
                    ++count;
                    // yield
                    turn = 1;
                    flag0 = false;
                    // exit
                    if (count0 == limit)
                        return;
                }
            }
        });

        Thread t1 = new Thread(new Runnable () {
            public void run() {
                while (true) {
                    // acquire
                    flag1 = true;
                    while (flag0) {
                         if (turn != 1) {
                             flag1 = false;
                             while (turn != 1) {
                             }
                             flag1 = true;
                         }
                    }
                    // critical section
                    ++count1;
                    ++count;
                    // yield
                    turn = 0;
                    flag1 = false;
                    // exit
                    if (count1 == limit)
                        return;
                }
            }
        });

        t0.start();
        t1.start();
        t0.join();
        t1.join();
        System.out.println(count);
    }
}
