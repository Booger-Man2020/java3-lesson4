public class Main {

    public static final Object lock = new Object();


    public static void main(String[] args) {
        Thread threadA = new ThreadA();
        Thread threadB = new ThreadB();
        Thread threadC = new ThreadC();
        threadA.start();
        threadB.start();
        threadC.start();
    }


    public static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                try {

                    for (int i = 0; i < 5; i++) {
                        System.out.print("A");
                        lock.wait(1000);
                    }

                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.print("B");
                        lock.wait(1000);
                    }

                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static class ThreadC extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.print("C");
                        System.out.println();
                        lock.wait(1000);
                    }

                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}



