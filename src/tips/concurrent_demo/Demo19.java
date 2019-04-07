package tips.concurrent_demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
*@author: 杜立茂
*@createDate  : 2019/3/31 12:10
*@description: Fork/Join框架，计算1-4的和
*/

public class Demo19 extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;//阈值
    private int start;
    private int end;

    public Demo19(int start,int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {

        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分成两个任务计算
            int middle = (start + end) / 2;
            Demo19 leftTask = new Demo19(start,middle);
            Demo19 rightTask = new Demo19(middle + 1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        Demo19 task = new Demo19(1,4);
        Future<Integer> result = pool.submit(task);
        System.out.println(result.get());
    }
}
