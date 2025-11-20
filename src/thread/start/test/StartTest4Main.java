package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        Thread threadA = new Thread(new CounterRunnable(1000, "A"), "Thread-A");
        Thread threadB = new Thread(new CounterRunnable(500, "B"), "Thread-B");
        threadA.start();
        threadB.start();
    }

    static class CounterRunnable implements Runnable {
        private int period;
        private String word;

        public CounterRunnable(int period, String word) {
            this.period = period;
            this.word = word;
        }

        @Override
        public void run() {
            while(true){
                log(word);
                try {
                    Thread.sleep(period);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
