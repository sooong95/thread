package thread.executor;

import util.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PreStartPoolMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1000);
        ExecutorUtils.printState(es);

        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
        poolExecutor.prestartAllCoreThreads();
        ThreadUtils.sleep(100);
        ExecutorUtils.printState(es);
    }
}
