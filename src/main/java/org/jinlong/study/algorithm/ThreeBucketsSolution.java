package org.jinlong.study.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nick on 26/12/2016.
 */
public class ThreeBucketsSolution {
    static int BUCKET_COUNTS = 3;
    int[] buckets = new int[3];
    static int[] BUCKET_CAPACITY = new int[] {8, 5, 3};
    static LinkedList<BucketState> bucketStates = new LinkedList<BucketState>();

    public static void main(String[] arg) {
        //初始化根结点
        Action rootAction = new Action(-1, 0, 8);
        BucketState rootSate = new BucketState(new int[]{8, 0, 0}, rootAction);
        bucketStates.addLast(rootSate);
        ThreeBucketsSolution threeBucketsSolution = new ThreeBucketsSolution();
        threeBucketsSolution.searchState(bucketStates);


    }
    private void searchState(LinkedList<BucketState> states) {
        BucketState currentState = states.getLast();
        if (currentState.isFinalState()) {
            printResult(states);
            return;
        }
        for (int i = 0; i < BUCKET_COUNTS; i++) {
            for (int j = 0; j < BUCKET_COUNTS; j++) {
                searchStateOnAction(states, currentState, i, j);
            }
        }
    }
    private void searchStateOnAction(LinkedList<BucketState> states, BucketState currentState, int from, int to) {
        if (currentState.canTakeAction(from, to)) {
            BucketState next = new BucketState();
            boolean isDumped = currentState.dumpWater(from, to, next);
            if (isDumped && !isProcessedState(states, next)) {
                states.addLast(next);
                searchState(states);
                states.removeLast();
            }
        }
    }

    private void printResult(List<BucketState> states) {
        System.out.println("\n********************Solution Start*****************************");
        for (BucketState state : states) {
            System.out.println(state.getCurrentAction());
        }
        System.out.println("********************Solution End*****************************");
    }

    private boolean isProcessedState(List<BucketState> bucketStates, BucketState bucketState) {
        if (bucketState == null) {
            return false;
        }
        for (BucketState state : bucketStates) {
            if (bucketState.equals(state)) {
                return true;
            }
        }
        return false;
    }

}
class Action {
    int from;
    int to;
    int water;

    public Action(int from, int to, int water) {
        this.from = from;
        this.to = to;
        this.water = water;
    }

    @Override
    public String toString() {
        return "From bucket" + from + " to bucket" + to + ", dumped water " + water;
    }
}
class BucketState {
    private int[] buckets = new int[] {0, 0, 0};
    private Action currentAction;

    public BucketState() {
    }

    public BucketState(int[] buckets, Action currentAction) {
        this.buckets = buckets;
        this.currentAction = currentAction;
    }

    public boolean canTakeAction(int from, int to) {
        if (from < 0 || from > ThreeBucketsSolution.BUCKET_COUNTS - 1 || to < 0 || to > ThreeBucketsSolution.BUCKET_COUNTS - 1) {
            return false;
        }
        if ((from != to) && !isBucketEmpty(from) && !isBucketFull(to)) {
            return true;
        }
        return false;
    }
    public boolean dumpWater(int from, int to, BucketState next) {
        next.setBuckets(buckets);
        int dumpWater = ThreeBucketsSolution.BUCKET_CAPACITY[to] - next.getBuckets()[to];
        if (next.getBuckets()[from] >= dumpWater) {
            next.getBuckets()[from] -= dumpWater;
            next.getBuckets()[to] += dumpWater;
        } else {
            next.getBuckets()[to] += next.getBuckets()[from];
            dumpWater = next.getBuckets()[from];
            next.getBuckets()[from] = 0;
        }
        if (dumpWater > 0) {
            Action currentAction = new Action(from, to, dumpWater);
            next.setCurrentAction(currentAction);
            return true;
        }
        return false;
    }

    private boolean isBucketEmpty(int bIndex) {
        return buckets[bIndex] == 0;
    }
    private boolean isBucketFull(int bIndex) {
        return buckets[bIndex] == ThreeBucketsSolution.BUCKET_CAPACITY[bIndex];
    }
    public boolean isFinalState() {
        if (buckets[0] == 4 && buckets[1] == 4 && buckets[2] == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BucketState) {
            o = (BucketState) o;
        } else {
            return false;
        }
        if (((BucketState) o).buckets[0] != this.buckets[0]) {
            return false;
        }
        if (((BucketState) o).buckets[1] != this.buckets[1]) {
            return false;
        }
        if (((BucketState) o).buckets[2] != this.buckets[2]) {
            return false;
        }

        return true;
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }

    public void setBuckets(int[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            this.buckets[i] = buckets[i];
        }
    }

    public int[] getBuckets() {
        return buckets;
    }
}
