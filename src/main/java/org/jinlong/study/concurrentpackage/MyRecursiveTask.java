package org.jinlong.study.concurrentpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by nick on 31/05/2017.
 */
public class MyRecursiveTask extends RecursiveTask<Long> {
    private long workload;

    public MyRecursiveTask(long workload) {
        this.workload = workload;
    }

    @Override
    protected Long compute() {
        if (this.workload > 16) {
            System.out.println("Splitting work load: " + this.workload);
            List<MyRecursiveTask> subTasks = new ArrayList<MyRecursiveTask>();
            subTasks.addAll(createSubTasks());
            for (RecursiveTask recursiveTask : subTasks) {
                recursiveTask.fork();
            }
            long result = 0;
            for (RecursiveTask recursiveTask : subTasks) {
                result += (Long) recursiveTask.join();
            }
            return result;
        } else {
            System.out.println("Doing this by myself for this workload: " + this.workload);
            return workload * 3;
        }

    }

    private List<MyRecursiveTask> createSubTasks() {
        List<MyRecursiveTask> subTasks = new ArrayList<MyRecursiveTask>();
        MyRecursiveTask subTask1 = new MyRecursiveTask(this.workload / 2);
        MyRecursiveTask subTask2 = new MyRecursiveTask(this.workload / 2);
        subTasks.add(subTask1);
        subTasks.add(subTask2);
        return subTasks;
    }
}
