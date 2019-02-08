
import java.util.Arrays;
import java.util.Random;

public class InsertionSort
{
    public static void main(String[] args)
    {
        int [] arr = generateArray(5,0,20);

        System.out.println("Array = " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }

    public static void insertionSort(int [] arr)
    {
        for( int i = 0 ; i < arr.length ; ++i )
        {
            for( int j = 0; j < i; ++j )
            {
                if( arr[i] < arr[j] )
                {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
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

}
