import java.util.ArrayList;

public class BinarySearcher {

    // will only have 1000 elements and reset with each new partition
    ArrayList<Long> runningTimes = new ArrayList<>();

    int arrLen;

    /**
     * 
     * @param arrToSearch
     * @param valToFind
     * @param arrSize
     * @return the index of the found element, -1 if not found
     */
    public int binarySearch(int[] arrToSearch, int valToFind, int arrSize) {
        arrLen = arrSize;
        long startTime = System.nanoTime();

        int low = 0;
        int high = arrSize - 1;
        while (high - low > 1) {
            int mid = (high + low) / 2;
            if (arrToSearch[mid] < valToFind) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arrToSearch[low] == valToFind) {
            return low;
        } else if (arrToSearch[high] == high) {
            return high;
        }

        long duration = System.nanoTime() - startTime;
        runningTimes.add(duration);
        return -1;
    }

    /**
     * A function used to get the average of the 1000 distinct running times it took
     * for binary search to run in the given partition. And reset the running time
     * list in the process.
     * 
     * @return the average of the running times in nanoseconds
     */
    public double getAverageTimeInNanoSeconds(Tester.DataType dataType) {
        if (dataType == Tester.DataType.DUMMY) {
            runningTimes.clear();
            return -1;
        }

        double sum = 0;
        for (Long time : runningTimes) {
            sum += time;
        }
        runningTimes.clear();
        double timeInNano = sum / 10;
        System.out.printf("Binary search %d length %s dataset 1000 runs average: %f nanoseconds\n", arrLen, dataType,
                timeInNano);
        return (timeInNano);
    }
}
