package org.jinlong.study.patterns.structural;

public class AdapterDemo {

    public static void main(String[] args) {

    }
}

interface Calculation {
    int[] sort(int[] array);
    int search(int[] array, int target);
}

class SortSolution {
    int[] sort(int[] array) {
        System.out.println("sorting");
        return null;
    }
}

class SearchSolution {
    int search(int[] array, int target) {
        System.out.println("searching");
        return 0;
    }
}

class CalculationAdapter implements Calculation {
    private SortSolution sortSolution;
    private SearchSolution searchSolution;

    public CalculationAdapter(SortSolution sortSolution, SearchSolution searchSolution) {
        this.sortSolution = sortSolution;
        this.searchSolution = searchSolution;
    }

    @Override
    public int[] sort(int[] array) {
        return sortSolution.sort(array);
    }

    @Override
    public int search(int[] array, int target) {
        return searchSolution.search(array, target);
    }
}
