package javabase基础.多线程;

import java.util.concurrent.*;

/**
 * @author VeigarBaron
 * @date 2021/4/7 9:24
 * @Description *
 */
public class JavaT {

    // ⾃定义Callable，与上⾯⼀样
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // 模拟计算需要⼀秒
            Thread.sleep(1000);
            return 2;
        }
        public static void main(String args[]) throws ExecutionException, InterruptedException {
            // 使⽤
            ExecutorService executor = Executors.newCachedThreadPool();
            FutureTask<Integer> futureTask = new FutureTask<>(new Task());
            executor.submit(futureTask);
            System.out.println(futureTask.get());
        }
    }
}
