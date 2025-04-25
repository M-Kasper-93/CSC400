//establish array for integers
public static Integer[] msd(Integer[] items) {
    //return item at index = 0
    return msd(items, index: 0); 
}
//recursive function 
private static Integer[] msd(Integer[] items, int index) {
    //base case: if array has only one item, then it cannot be sorted
    if (array.length <= 1) {
        return items;
    }
    //underlying sorting method
    Arrays.sort(items, index);
}