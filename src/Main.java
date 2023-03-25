import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
        public static void main(String args[]) throws IOException {

                // reading the data
                Scanner scanner = new Scanner(new File("TrafficFlowDataset.csv"));
                scanner.nextLine();
                int[] randomDatasetArr = new int[250000];

                for (int i = 0; i < 250000; i++) {
                        String line = scanner.nextLine();
                        String[] lineList = line.split(",");
                        int lastElem = Integer.parseInt(lineList[lineList.length - 1]);
                        randomDatasetArr[i] = lastElem;
                }
                scanner.close();

                // sorting the data for the experiments
                int[] sortedDatasetArr = randomDatasetArr;
                Arrays.sort(sortedDatasetArr);

                int[] reverselySortedArr = randomDatasetArr;
                Arrays.sort(reverselySortedArr);

                Tester tester = new Tester();
                tester.testSort(randomDatasetArr, 500, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 1000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 2000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 4000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 8000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 16000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 32000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 64000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 128000, Tester.DataType.RANDOM);
                tester.testSort(randomDatasetArr, 250000, Tester.DataType.RANDOM);

                ArrayList<Double> tempList = tester.getAverageRunTimesSelectionSortRandom();
                double[] averageRunTimesSelectionSortRandom = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesSelectionSortRandom[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesSelectionSortRandom();

                tempList = tester.getAverageRunTimesQuickSortRandom();
                double[] averageRunTimesQuickSortRandom = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesQuickSortRandom[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesQuickSortRandom();

                tempList = tester.getAverageRunTimesBucketSortRandom();
                double[] averageRunTimesBucketSortRandom = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesBucketSortRandom[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesBucketSortRandom();

                tester.testSort(sortedDatasetArr, 500, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 1000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 2000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 4000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 8000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 16000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 32000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 64000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 128000, Tester.DataType.SORTED);
                tester.testSort(sortedDatasetArr, 250000, Tester.DataType.SORTED);

                tempList = tester.getAverageRunTimesSelectionSortSorted();
                double[] averageRunTimesSelectionSortSorted = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesSelectionSortSorted[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesSelectionSortSorted();

                tempList = tester.getAverageRunTimesQuickSortSorted();
                double[] averageRunTimesQuickSortSorted = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesQuickSortSorted[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesQuickSortSorted();

                tempList = tester.getAverageRunTimesBucketSortSorted();
                double[] averageRunTimesBucketSortSorted = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesBucketSortSorted[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesBucketSortSorted();

                tester.testSort(reverselySortedArr, 500, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 1000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 2000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 4000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 8000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 16000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 32000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 64000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 128000, Tester.DataType.REVERSED);
                tester.testSort(reverselySortedArr, 250000, Tester.DataType.REVERSED);

                tempList = tester.getAverageRunTimesSelectionSortReversed();
                double[] averageRunTimesSelectionSortReversed = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesSelectionSortReversed[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesSelectionSortReversed();

                tempList = tester.getAverageRunTimesQuickSortReversed();
                double[] averageRunTimesQuickSortReversed = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesQuickSortReversed[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesQuickSortReversed();

                tempList = tester.getAverageRunTimesBucketSortReversed();
                double[] averageRunTimesBucketSortReversed = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesBucketSortReversed[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesBucketSortReversed();

                tester.testSearch(randomDatasetArr, 500, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 1000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 2000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 4000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 8000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 16000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 32000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 64000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 128000, Tester.DataType.RANDOM);
                tester.testSearch(randomDatasetArr, 250000, Tester.DataType.RANDOM);

                tester.testSearch(sortedDatasetArr, 500, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 1000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 2000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 4000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 8000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 16000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 32000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 64000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 128000, Tester.DataType.SORTED);
                tester.testSearch(sortedDatasetArr, 250000, Tester.DataType.SORTED);

                tempList = tester.getAverageRunTimesLinearSearchRandom();
                double[] averageRunTimesLinearSearchRandom = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesLinearSearchRandom[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesLinearSearchRandom();

                tempList = tester.getAverageRunTimesLinearSearchSorted();
                double[] averageRunTimesLinearSearchSorted = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesLinearSearchSorted[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesLinearSearchSorted();

                tempList = tester.getAverageRunTimesBinarySearch();
                double[] averageRunTimesBinarySearch = new double[10];
                for (int i = 0; i < 10; i++) {
                        averageRunTimesBinarySearch[i] = tempList.get(i);
                }
                tester.clearAverageRunTimesBinarySearch();

                // X axis data
                int[] inputAxis = { 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000,
                                250000 };

                double[][] yAxisRandomDataSort = new double[3][10];
                yAxisRandomDataSort[0] = averageRunTimesSelectionSortRandom;
                yAxisRandomDataSort[1] = averageRunTimesQuickSortRandom;
                yAxisRandomDataSort[2] = averageRunTimesBucketSortRandom;

                // Save the char as .png and show it
                saveChartSorting("Sorting Algorithms with Random Data", inputAxis, yAxisRandomDataSort);

                double[][] yAxisSortedDataSort = new double[3][10];
                yAxisSortedDataSort[0] = averageRunTimesSelectionSortSorted;
                yAxisSortedDataSort[1] = averageRunTimesQuickSortSorted;
                yAxisSortedDataSort[2] = averageRunTimesBucketSortSorted;

                saveChartSorting("Sorting Algorithms with Sorted Data", inputAxis, yAxisSortedDataSort);

                double[][] yAxisReversedDataSort = new double[3][10];
                yAxisReversedDataSort[0] = averageRunTimesSelectionSortReversed;
                yAxisReversedDataSort[1] = averageRunTimesQuickSortReversed;
                yAxisReversedDataSort[2] = averageRunTimesBucketSortReversed;

                saveChartSorting("Sorting Algorithms with Reversely Sorted Data", inputAxis, yAxisReversedDataSort);

                double[][] yAxisSearchAlgorithms = new double[3][10];
                yAxisSearchAlgorithms[0] = averageRunTimesLinearSearchRandom;
                yAxisSearchAlgorithms[1] = averageRunTimesLinearSearchSorted;
                yAxisSearchAlgorithms[2] = averageRunTimesBinarySearch;

                saveChartSearching("Searching Algorithms with Sorted & Random Data", inputAxis, yAxisSearchAlgorithms);
        }

        public static void saveChartSorting(String title, int[] xAxis, double[][] yAxis) throws IOException {
                // Create Chart
                XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

                // Convert x axis to double[]
                double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

                // Customize Chart
                chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
                chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

                // Add a plot for a sorting algorithm
                chart.addSeries("Selection Sort", doubleX, yAxis[0]);
                chart.addSeries("Quick Sort", doubleX, yAxis[1]);
                chart.addSeries("Bucket Sort", doubleX, yAxis[2]);

                // Save the chart as PNG
                BitmapEncoder.saveBitmap(chart, title + ".png",
                                BitmapEncoder.BitmapFormat.PNG);
        }

        public static void saveChartSearching(String title, int[] xAxis, double[][] yAxis) throws IOException {
                // Create Chart
                XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                                .yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();

                // Convert x axis to double[]
                double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

                // Customize Chart
                chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
                chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

                // Add a plot for a searching algorithm
                chart.addSeries("Linear Search on Random Data", doubleX, yAxis[0]);
                chart.addSeries("Linear Search on Sorted Data", doubleX, yAxis[1]);
                chart.addSeries("Binary Search", doubleX, yAxis[2]);

                // Save the chart as PNG
                BitmapEncoder.saveBitmap(chart, title + ".png",
                                BitmapEncoder.BitmapFormat.PNG);
        }
}
