import java.util.Arrays;
import java.util.Random;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr = generateArray(5, 0, 20);

        System.out.println("Array = " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] array)
    {
        mergeSortArray(array, 0, array.length - 1);
    }

    private static void mergeSortArray(int[]array, int startIndex, int finishIndex)
    {
        if (startIndex < finishIndex)
        {

            int mediana = startIndex + (finishIndex - startIndex) / 2;

            mergeSortArray(array, startIndex, mediana);
            mergeSortArray(array, mediana + 1, finishIndex);

            merge(array, startIndex, mediana, finishIndex);
        }
    }

    private static void merge(int[] array, int startIndex, int mediana, int finishIndex)
    {
        int leftSubArrayLength =  mediana - startIndex + 1;
        int rightSubArrayLength= finishIndex - mediana;

        int [] leftSubArray = new int[leftSubArrayLength];
        int [] rightSubArray = new int[rightSubArrayLength];

        for (int i = 0; i < leftSubArrayLength; i++)
        {
            leftSubArray[i] = array[i + startIndex];
        }

        for (int j = 0; j < rightSubArrayLength ; j++)
        {
            rightSubArray[j] = array[mediana + 1 + j];
        }

        int k = startIndex;
        int i = 0;
        int j = 0;

        while(i < leftSubArrayLength && j < rightSubArrayLength)
        {
            if (leftSubArray[i] < rightSubArray[j])
            {
                array[k] = leftSubArray[i];
                i++;
            } else {
                array[k] = rightSubArray[j];
                j++;
            }

            k++;
        }

        while(i < leftSubArrayLength)
        {
            array[k] = leftSubArray[i];
            i++;
            k++;
        }

        while(j < rightSubArrayLength)
        {
            array[k] = rightSubArray[j];
            j++;
            k++;
        }
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

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
