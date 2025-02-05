package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        log("main thread = " + mainThread);
        log("main thread id = " + mainThread.threadId());
        log("main thread name = " + mainThread.getName());
        log("main thread priority = " + mainThread.getPriority());
        log("main thread group = " + mainThread.getThreadGroup());
        log("main thread state = " + mainThread.getState());

        log("                    ");

        Thread myThread = new Thread(new HelloRunnable(), "myThread");

        log("my thread = " + myThread);
        log("my thread id = " + myThread.threadId());
        log("my thread name = " + myThread.getName());
        log("my thread priority = " + myThread.getPriority());
        log("my thread group = " + myThread.getThreadGroup());
        log("my thread state = " + myThread.getState());
    }
}
