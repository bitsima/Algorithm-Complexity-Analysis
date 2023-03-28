import java.util.ArrayList;

public class LinearSearcher {

    // will only have 1000 elements and reset with each new partition
    ArrayList<Long> runningTimes = new ArrayList<>();

    int arrLen;

    public int linearSearch(int[] arrToSearch, int valToFind, int arrSize) {
        arrLen = arrSize;
        long startTime = System.nanoTime();

        for (int index = 0; index < arrSize; index++) {
            if (arrToSearch[index] == valToFind) {
                long duration = System.nanoTime() - startTime;
                runningTimes.add(duration);
                return index;
            }
        }

        long duration = System.nanoTime() - startTime;
        runningTimes.add(duration);
        return -1;
    }

    /**
     * A function used to get the average of the 1000 distinct running times it took
     * for linear search to run in the given partition. And reset the running time
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
        double timeInNano = sum / 1000;
        System.out.printf("Linear search %d length %s dataset 1000 runs average: %f nanoseconds\n", arrLen, dataType,
                timeInNano);
        return (timeInNano);
    }
}
