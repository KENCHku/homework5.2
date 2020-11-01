import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here

        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        Uploader uploader = new Uploader(countDownLatch1);
        uploader.start();
        Semaphore semaphore = new Semaphore(3, true);
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 1; i < 11; i++) {
            new Downloader(i, semaphore, countDownLatch, countDownLatch1).start();
            Thread.sleep(1000);
        }
        countDownLatch.await();
        System.out.println(" \nfiles have deleted from server" +
                "\n the end of code" +
                "\n gg(0-0)");
    }
}


 /* for (int i = 0; i < 20; i++) {
            System.out.print("-");
            Thread.sleep(10);

        } System.out.println("\n Loaded succesfuly ");

*/