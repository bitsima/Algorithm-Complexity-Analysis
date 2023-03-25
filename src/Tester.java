import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A Tester instance is used to call each algorithms methods and holds the
 * runtime data.
 */

public class Tester {

    public static enum DataType {
        RANDOM, SORTED, REVERSED, DUMMY
    }

    ArrayList<Double> averageRunTimesSelectionSortRandom = new ArrayList<>();
    ArrayList<Double> averageRunTimesQuickSortRandom = new ArrayList<>();
    ArrayList<Double> averageRunTimesBucketSortRandom = new ArrayList<>();

    ArrayList<Double> averageRunTimesSelectionSortSorted = new ArrayList<>();
    ArrayList<Double> averageRunTimesQuickSortSorted = new ArrayList<>();
    ArrayList<Double> averageRunTimesBucketSortSorted = new ArrayList<>();

    ArrayList<Double> averageRunTimesSelectionSortReversed = new ArrayList<>();
    ArrayList<Double> averageRunTimesQuickSortReversed = new ArrayList<>();
    ArrayList<Double> averageRunTimesBucketSortReversed = new ArrayList<>();

    SelectionSorter selectionSorter = new SelectionSorter();
    QuickSorter quickSorter = new QuickSorter();
    BucketSorter bucketSorter = new BucketSorter();

    /**
     * Calls the sorting algorithm methods and records the data.
     * 
     * @param arrToSort     the data (not partitioned)
     * @param partitionSize
     * @param dataType      enum type
     */
    public void testSort(int[] arrToSort, int partitionSize, DataType dataType) {

        // testing each algorithm 10 times and getting the average
        for (int i = 0; i < 11; i++) {
            int[] partitionedArr = Arrays.copyOfRange(arrToSort, 0, partitionSize);
            selectionSorter.selectionSort(partitionedArr, partitionSize);

            partitionedArr = Arrays.copyOfRange(arrToSort, 0, partitionSize);
            quickSorter.quickSort(partitionedArr, partitionSize);

            partitionedArr = Arrays.copyOfRange(arrToSort, 0, partitionSize);
            bucketSorter.bucketSort(partitionedArr, partitionSize);

            // resetting runtime data lists after the initial dummy run
            if (i == 0) {
                selectionSorter.getAverageTimeInMilliSeconds(DataType.DUMMY);
                quickSorter.getAverageTimeInMilliSeconds(DataType.DUMMY);
                bucketSorter.getAverageTimeInMilliSeconds(DataType.DUMMY);
            }
        }

        // calculating the average and resetting the records
        if (dataType == DataType.RANDOM) {

            averageRunTimesSelectionSortRandom.add(selectionSorter.getAverageTimeInMilliSeconds(dataType));
            averageRunTimesQuickSortRandom.add(quickSorter.getAverageTimeInMilliSeconds(dataType));
            averageRunTimesBucketSortRandom.add(bucketSorter.getAverageTimeInMilliSeconds(dataType));

        } else if (dataType == DataType.SORTED) {

            averageRunTimesSelectionSortSorted.add(selectionSorter.getAverageTimeInMilliSeconds(dataType));
            averageRunTimesQuickSortSorted.add(quickSorter.getAverageTimeInMilliSeconds(dataType));
            averageRunTimesBucketSortSorted.add(bucketSorter.getAverageTimeInMilliSeconds(dataType));

        } else if (dataType == DataType.REVERSED) {

            averageRunTimesSelectionSortReversed.add(selectionSorter.getAverageTimeInMilliSeconds(dataType));
            averageRunTimesQuickSortReversed.add(quickSorter.getAverageTimeInMilliSeconds(dataType));
            averageRunTimesBucketSortReversed.add(bucketSorter.getAverageTimeInMilliSeconds(dataType));

        }
    }

    ArrayList<Double> averageRunTimesLinearSearchRandom = new ArrayList<>();
    ArrayList<Double> averageRunTimesLinearSearchSorted = new ArrayList<>();
    ArrayList<Double> averageRunTimesBinarySearch = new ArrayList<>();

    LinearSearcher linearSearcher = new LinearSearcher();
    BinarySearcher binarySearcher = new BinarySearcher();

    /**
     * Calls the searching algorithm methods and records the data.
     * 
     * @param arrToSearch
     * @param partitionSize
     * @param dataType
     */
    public void testSearch(int[] arrToSearch, int partitionSize, DataType dataType) {
        if (dataType == DataType.RANDOM) {
            for (int i = 0; i < 1001; i++) {
                int[] partitionedArr = Arrays.copyOfRange(arrToSearch, 0, partitionSize);
                Random random = new Random();
                int randomIndex = random.nextInt(partitionSize);
                int valToFind = arrToSearch[randomIndex];

                linearSearcher.linearSearch(partitionedArr, valToFind, partitionSize);

                // resetting runtime data list after the initial dummy run
                if (i == 0) {
                    linearSearcher.getAverageTimeInNanoSeconds(DataType.DUMMY);
                }
            }
            averageRunTimesLinearSearchRandom.add(linearSearcher.getAverageTimeInNanoSeconds(dataType));
        } else if (dataType == DataType.SORTED) {
            for (int i = 0; i < 1001; i++) {
                int[] partitionedArr = Arrays.copyOfRange(arrToSearch, 0, partitionSize);
                Random random = new Random();
                int randomIndex = random.nextInt(partitionSize);
                int valToFind = arrToSearch[randomIndex];

                linearSearcher.linearSearch(partitionedArr, valToFind, partitionSize);

                binarySearcher.binarySearch(arrToSearch, valToFind, partitionSize);

                // resetting runtime data lists after the initial dummy run
                if (i == 0) {
                    linearSearcher.getAverageTimeInNanoSeconds(DataType.DUMMY);
                    binarySearcher.getAverageTimeInNanoSeconds(DataType.DUMMY);
                }
            }
            averageRunTimesLinearSearchSorted.add(linearSearcher.getAverageTimeInNanoSeconds(dataType));
            averageRunTimesBinarySearch.add(binarySearcher.getAverageTimeInNanoSeconds(dataType));
        }
    }

    public ArrayList<Double> getAverageRunTimesSelectionSortRandom() {
        return averageRunTimesSelectionSortRandom;
    }

    public void clearAverageRunTimesSelectionSortRandom() {
        this.averageRunTimesSelectionSortRandom.clear();
    }

    public ArrayList<Double> getAverageRunTimesQuickSortRandom() {
        return averageRunTimesQuickSortRandom;
    }

    public void clearAverageRunTimesQuickSortRandom() {
        this.averageRunTimesQuickSortRandom.clear();
    }

    public ArrayList<Double> getAverageRunTimesBucketSortRandom() {
        return averageRunTimesBucketSortRandom;
    }

    public void clearAverageRunTimesBucketSortRandom() {
        this.averageRunTimesBucketSortRandom.clear();
    }

    public ArrayList<Double> getAverageRunTimesSelectionSortSorted() {
        return averageRunTimesSelectionSortSorted;
    }

    public void clearAverageRunTimesSelectionSortSorted() {
        this.averageRunTimesSelectionSortSorted.clear();
    }

    public ArrayList<Double> getAverageRunTimesQuickSortSorted() {
        return averageRunTimesQuickSortSorted;
    }

    public void clearAverageRunTimesQuickSortSorted() {
        this.averageRunTimesQuickSortSorted.clear();
    }

    public ArrayList<Double> getAverageRunTimesBucketSortSorted() {
        return averageRunTimesBucketSortSorted;
    }

    public void clearAverageRunTimesBucketSortSorted() {
        this.averageRunTimesBucketSortSorted.clear();
    }

    public ArrayList<Double> getAverageRunTimesSelectionSortReversed() {
        return averageRunTimesSelectionSortReversed;
    }

    public void clearAverageRunTimesSelectionSortReversed() {
        this.averageRunTimesSelectionSortReversed.clear();
    }

    public ArrayList<Double> getAverageRunTimesQuickSortReversed() {
        return averageRunTimesQuickSortReversed;
    }

    public void clearAverageRunTimesQuickSortReversed() {
        this.averageRunTimesQuickSortReversed.clear();
    }

    public ArrayList<Double> getAverageRunTimesBucketSortReversed() {
        return averageRunTimesBucketSortReversed;
    }

    public void clearAverageRunTimesBucketSortReversed() {
        this.averageRunTimesBucketSortReversed.clear();
    }

    public ArrayList<Double> getAverageRunTimesLinearSearchRandom() {
        return averageRunTimesLinearSearchRandom;
    }

    public void clearAverageRunTimesLinearSearchRandom() {
        this.averageRunTimesLinearSearchRandom.clear();
    }

    public ArrayList<Double> getAverageRunTimesLinearSearchSorted() {
        return averageRunTimesLinearSearchSorted;
    }

    public void clearAverageRunTimesLinearSearchSorted() {
        this.averageRunTimesLinearSearchSorted.clear();
    }

    public ArrayList<Double> getAverageRunTimesBinarySearch() {
        return averageRunTimesBinarySearch;
    }

    public void clearAverageRunTimesBinarySearch() {
        this.averageRunTimesBinarySearch.clear();
    }

}
