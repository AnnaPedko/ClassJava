import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args)
    {
        int[] arr = generateArray(5, 0, 20);

        System.out.println("Array = " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }

    public static void quickSort(int[] array)
    {
        quickSortArray(array, 0, array.length - 1);
    }

    private static void quickSortArray( int[] array, int startIndex, int finishIndex)
    {
        if (startIndex < finishIndex )
        {
            int partitionIndex = getPartitionIndex(array, startIndex, finishIndex);
            quickSortArray(array, startIndex, partitionIndex - 1);
            quickSortArray(array, partitionIndex + 1, finishIndex );
        }
    }

    private static int getPartitionIndex(int[] array, int startIndex, int finishIndex)
    {
        int pivotIndex = finishIndex;
        int pivotElement = array[pivotIndex];
        int partition = startIndex;

        for (int j = startIndex; j < finishIndex; j++)
        {
            if (array[j] <= pivotElement)
            {
                swap(array, partition, j);
                partition++;
            }
        }

        swap(array, partition, pivotIndex );

        return partition;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int getRandomNumber(int min, int max)
    {

        if (min >= max)
        {
            throw new IllegalArgumentException("Max value should be greater than min value");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static int[] generateArray(int elementNumber, int min, int max)
    {
        int[] array = new int[elementNumber];

        for (int i = 0; i < array.length; ++i)
        {
            array[i] = getRandomNumber(min, max);
        }

        return array;
    }
}
