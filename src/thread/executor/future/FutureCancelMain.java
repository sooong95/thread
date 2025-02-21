package thread.executor.future;

import util.ThreadUtils;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class FutureCancelMain {

    // private static boolean mayInterruptIfRunning = true; // 변경
    private static boolean mayInterruptIfRunning = false;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());

        log("Future.state = " + future.state());

        // 일정 시간 후 취소 시도
        ThreadUtils.sleep(3000);

        // cancel() 호출
        log("Future.cancel(" + mayInterruptIfRunning + ")");
        boolean cancelResult = future.cancel(mayInterruptIfRunning);
        log("Future.cancel(" + mayInterruptIfRunning + ") result = " + cancelResult);

        // 결과 확인
        try {
            log("Future Result = " + future.get());
        } catch (CancellationException e) {
            log("Future 는 이미 취소 되었습니다.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        es.close();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() {

            try {
                for (int i = 0; i < 10; i++) {
                    log("작업 중 " + i);
                    sleep(1000);
                }
            } catch (InterruptedException e) {
                log("인터럽트 발생");
                return "Interrupted";
            }
            return "completed";
        }
    }
}
