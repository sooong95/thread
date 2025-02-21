package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SumTaskMainV2_Bad {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = es.submit(task1);
        Integer sum1 = future1.get(); // 2초

        Future<Integer> future2 = es.submit(task2);
        Integer sum2 = future2.get(); // 2초

        // Integer sum1 = es.submit(task1).get(); // 2초
        // Integer sum2 = es.submit(task2).get(); // 2초

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);

        log("result = " + (sum1 + sum2));

        log("END");

        es.close();
    }

    static class SumTask implements Callable<Integer> {

        final int startValue;
        final int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {

            log("작업 시작");

            sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            log("작업 완료 result = " + sum);

            return sum;
        }
    }
}
