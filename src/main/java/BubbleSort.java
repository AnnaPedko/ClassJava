import java.util.Arrays;
import java.util.Random;

public class BubbleSort
{
    public static void main(String[] args)
    {
        int [] arr = generateArray(5,0,20);

        System.out.println("Array = " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }

    private static void bubbleSort(int [] array)
    {
        for( int j = array.length - 1; j > 0 ; --j )
            for( int i = 0; i < j; ++i )
            {
                if( array[i] > array[i + 1] )
                    swapElements(array, i, i + 1);
            }
    }

    public static void swapElements( int [] array, int a, int b)
    {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
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
