import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        Callable<Boolean> c1 = () -> getList("From C1");
        Future<Boolean> f1 = executorService.submit(c1);

        Callable<Boolean> c2 = () -> getList("From C2");
        Future<Boolean> f2 = executorService.submit(c2);

        Callable<Boolean> c3 = () -> getList("From C3");
        Future<Boolean> f3 = executorService.submit(c3);

        Callable<Boolean> c4 = () -> getList("From C4");
        Future<Boolean> f4 = executorService.submit(c4);

        Callable<Boolean> c5 = () -> getList("From C5");
        Future<Boolean> f5= executorService.submit(c5);

        Callable<Boolean> c6 = () -> getList("From C6");
        Future<Boolean> f6 = executorService.submit(c6);
        System.out.println("All Callable Thread started");

        try {
            if(f1.get()&&f2.get()&&f3.get()&&f4.get()&&f5.get()&&f6.get()) {
                System.out.println("All threads completed");
            }
        } catch (InterruptedException|ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static boolean getList(String message) {

        System.out.println(message);
        int i = 1000000;
        while (i > 1) {
            if(i==2) {
                System.out.println(message+" completed");
            }
            i--;
        }
        return true;

    }
}
