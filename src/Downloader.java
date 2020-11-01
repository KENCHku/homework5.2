import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatch1;

    private Semaphore semaphore;
    private int user;


    public Downloader(int user, Semaphore semaphore, CountDownLatch countDownLatch, CountDownLatch countDownLatch1) {
        this.user = user;
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.countDownLatch1=countDownLatch1;
    }

    public void run() {
        try {
            countDownLatch1.await();
            semaphore.acquire();
            System.out.println("\n +Installing of file " + user + " by user+");
            sleep(1000);
            System.out.println("\n -File installed " + user + " by user-");
            semaphore.release();
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
