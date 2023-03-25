import java.util.ArrayList;

public class QuickSorter {

    // will only have 10 elements and reset with each new partition
    ArrayList<Long> runningTimes = new ArrayList<>();
    int[] sortedArr;
    int arrLen;

    public int[] quickSort(int[] arrToSort, int arrSize) {
        sortedArr = arrToSort;
        arrLen = arrSize;
        long startTime = System.nanoTime(); // nanoTime for extra precision (will be converted later)

        int high = arrSize - 1;
        int low = 0;
        ArrayList<Integer> stack = new ArrayList<>();
        int topIndex = -1;
        stack.add(++topIndex, low);
        stack.add(++topIndex, high);

        while (topIndex >= 0) {
            high = stack.get(topIndex);
            stack.remove(topIndex);
            topIndex--;

            low = stack.get(topIndex);
            stack.remove(topIndex);
            topIndex--;

            int pivot = partition(low, high);
            if (pivot - 1 > low) {
                stack.add(++topIndex, low);
                stack.add(++topIndex, pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.add(++topIndex, pivot + 1);
                stack.add(++topIndex, high);
            }
        }

        long duration = System.nanoTime() - startTime;
        runningTimes.add(duration);

        return sortedArr;
    }

    private int partition(int low, int high) {
        int pivot = sortedArr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (sortedArr[j] <= pivot) {
                i++;
                int temp = sortedArr[i];
                sortedArr[i] = sortedArr[j];
                sortedArr[j] = temp;
            }
        }
        int temp = sortedArr[i + 1];
        sortedArr[i + 1] = sortedArr[high];
        sortedArr[high] = temp;

        return i + 1;
    }

    /**
     * A function used to get the average of the 10 distinct running times it took
     * for quick sort to run in the given partition. And reset the running time
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
        System.out.printf("Quick sort %d length %s dataset 10 runs average: %f milliseconds\n", arrLen, dataType,
                timeInMillis);

        return (timeInMillis);
    }
}
