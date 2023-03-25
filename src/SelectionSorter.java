import java.util.ArrayList;

public class SelectionSorter {

    // will only have 10 elements and reset with each new partition
    ArrayList<Long> runningTimes = new ArrayList<>();
    int arrLen;

    public int[] selectionSort(int[] arrToSort, int arrLength) {
        int[] sortedArr = arrToSort;
        arrLen = arrLength;
        long startTime = System.nanoTime(); // nanoTime for extra precision (will be converted later)

        for (int i = 0; i < arrLen; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrLen; j++) {
                if (sortedArr[j] < sortedArr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = sortedArr[i];
                sortedArr[i] = sortedArr[minIndex];
                sortedArr[minIndex] = temp;
            }
        }

        long duration = System.nanoTime() - startTime;
        runningTimes.add(duration);

        return sortedArr;
    }

    /**
     * A function used to get the average of the 10 distinct running times it took
     * for selection sort to run in the given partition. And reset the running time
     * list in the process.
     * 
     * @return the average of the running times in milliseconds
     */
    public double getAverageTimeInMilliSeconds(Tester.DataType dataType) {
        if (dataType == Tester.DataType.DUMMY) {
            runningTimes.clear();
            return -1;
        }

        double sum = 0;
        for (Long time : runningTimes) {
            sum += time;
        }
        runningTimes.clear();
        double timeInMillis = (double) sum / 10000000;
        System.out.printf("Selection sort %d length %s dataset 10 runs average: %f milliseconds\n", arrLen, dataType,
                timeInMillis);

        return (timeInMillis);
    }
}
