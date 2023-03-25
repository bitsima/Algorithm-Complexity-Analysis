import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSorter {

    // will only have 10 elements and reset with each new partition
    ArrayList<Long> runningTimes = new ArrayList<>();
    int arrLen;

    public int[] bucketSort(int[] arrToSort, int arrSize) {
        int[] sortedArr = arrToSort;
        arrLen = arrSize;
        long startTime = System.nanoTime(); // nanoTime for extra precision (will be converted later)

        double arrSizeDouble = arrSize;
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arrSizeDouble));
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numberOfBuckets; i++) {
            ArrayList<Integer> placeHolderList = new ArrayList<>();
            buckets.add(placeHolderList);
        }

        int maxVal = Arrays.stream(arrToSort).max().getAsInt();

        // distributing values among buckets
        for (int val : sortedArr) {
            ArrayList<Integer> tempBucket = buckets.get(hash(val, maxVal, numberOfBuckets));
            tempBucket.add(val);
            buckets.set(hash(val, maxVal, numberOfBuckets), tempBucket);
        }

        // sorting each bucket individually
        for (int index = 0; index < numberOfBuckets; index++) {
            ArrayList<Integer> tempBucket = buckets.get(index);
            Collections.sort(tempBucket);
            buckets.set(index, tempBucket);
        }

        int index = 0;
        for (ArrayList<Integer> arrayList : buckets) {
            for (int val : arrayList) {
                sortedArr[index] = val;
                index++;
            }
        }

        long duration = System.nanoTime() - startTime;
        runningTimes.add(duration);

        return sortedArr;
    }

    private int hash(double val, double max, double numberOfBuckets) {
        return (int) Math.floor((val / max) * (numberOfBuckets - 1));
    }

    /**
     * A function used to get the average of the 10 distinct running times it took
     * for bucket sort to run in the given partition. And reset the running time
     * list in the process.
     * 
     * @return the average of the running times in milliseconds
     */
    public double getAverageTimeInMilliSeconds(Tester.DataType dataType) {
        double sum = 0;
        for (Long time : runningTimes) {
            sum += time;
        }
        runningTimes.clear();
        double timeInMillis = (double) sum / 10000000;
        System.out.printf("Bucket sort %d length %s dataset 10 runs average: %f milliseconds\n", arrLen, dataType,
                timeInMillis);

        return (timeInMillis);
    }
}
