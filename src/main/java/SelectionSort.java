import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args)
    {
        int[] arr = generateArray(5, 0, 20);

        System.out.println("Array = " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }

    public static void swapElements(int[] array, int a, int b)
    {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i)
        {
            swapElements(arr, i, findMin(arr, i));
        }
    }

    public static int findMin(int[] arr, int k)
    {
        int minElement = arr[k];
        int index = k;

        for( int i = k; i < arr.length - 1; ++i ) {
            if ( minElement > arr[i + 1] ) {
                minElement = arr[i + 1];
                index = i + 1;
            }
        }

        return index;
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
