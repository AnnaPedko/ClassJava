import java.util.Arrays;

public class BinarySearch
{
    public static void main(String[] args)
    {
        Integer[] arr = {1, 4, 7, 9, 15, 18, 20};

        int startIdx = 0;
        int endIdx = arr.length;

        int elementIdx = binarySearch(arr, startIdx, endIdx, 7);

        if (elementIdx > 0)
            System.out.println("Index of found element = " + elementIdx);
        else
            System.out.println("Element does not exist in array");
    }

    public static int binarySearch( Integer[] array, int startIndex, int endIndex, Integer element)
    {
        int enterIndex = -1;

        if( Arrays.asList(array).contains(element) )
        {
            enterIndex = startIndex + (endIndex - startIndex) / 2;
            int arrayElement = array[enterIndex];

            if (element != arrayElement)
            {
                if (element > arrayElement)
                {
                    enterIndex = binarySearch(array, enterIndex, endIndex, element);
                } else {
                    enterIndex = binarySearch(array, startIndex, enterIndex, element);
                }
            }
        }

        return enterIndex ;
    }
}
