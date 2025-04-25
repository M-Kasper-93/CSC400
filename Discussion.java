import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            //shift elements greater than the key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            //position key in array
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        //array for testing
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        
        //before sort
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(array));
        
        //perform insertion sort
        insertionSort(array);
        
        //after sort
        System.out.println("Sorted Array: " + " " + Arrays.toString(array));
    }
}

