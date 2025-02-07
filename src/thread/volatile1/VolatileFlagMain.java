package thread.volatile1;

import util.ThreadUtils;

import static util.MyLogger.log;

public class VolatileFlagMain {

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        ThreadUtils.sleep(1000);

        log("runFlag 를 false 로 변경 시도");

        task.runFlag = false;

        log("runFlag = " + task.runFlag);

        log("main 종료");
    }

    static class MyTask implements Runnable {

        // boolean runFlag = true;
        volatile boolean runFlag = true; // 캐시 메모리를 무시하고 메인 메모리를 직접 접근한다.

        @Override
        public void run() {
            log("task 시작");
            int count = 0;

            while (runFlag) {
                // runflag 가 false로 변하면 탈출
            }

            log("task 종료");
        }
    }
}
