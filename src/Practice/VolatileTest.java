package Practice;

public class VolatileTest {

    //public static boolean flag = false;
    public static volatile boolean flag = false;
    public static class MyRunnable implements Runnable{
        @Override
        public void run(){
            int i = 0;
            while(!flag){
                //System.out.println("my thread is running...");
                i++;
            }
            System.out.println("my thread is finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread newTread = new Thread(new MyRunnable());
        newTread.start();
        Thread.sleep(600);
        flag = true;
        System.out.println("main thread is finished");
    }
}
