package org.jinlong.study.concurrentpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by nick on 31/05/2017.
 */
public class MyRecursiveAction extends RecursiveAction {
    private long workload;

    public MyRecursiveAction(long workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (this.workload > 16) {
            System.out.println("Splitting work load: " + this.workload);
            List<MyRecursiveAction> subTasks = new ArrayList<MyRecursiveAction>();
            subTasks.addAll(createSubTasks());
            for (RecursiveAction recursiveAction : subTasks) {
                recursiveAction.fork();
            }
        } else {
            System.out.println("Doing this by myself.");
        }

    }

    private List<MyRecursiveAction> createSubTasks() {
        List<MyRecursiveAction> subTasks = new ArrayList<MyRecursiveAction>();
        MyRecursiveAction subTask1 = new MyRecursiveAction(this.workload / 2);
        MyRecursiveAction subTask2 = new MyRecursiveAction(this.workload / 2);
        subTasks.add(subTask1);
        subTasks.add(subTask2);
        return subTasks;
    }
}
