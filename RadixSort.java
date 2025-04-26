//establish array for integers
public static Integer[] msd(Integer[] items) {
    return msd(items, 0);
}

//method to get MSD, starting from left
private static int getDigitFromLeft(int number, int index) {
    String numStr = String.valueOf(number);

    if (index >= numStr.length()) {
        return 0;
    }

    return Character.getNumericValue(numStr.charAt(index));
}

//recursive function
private static Integer[] msd(Integer[] items, int index) {
    //base case: if array has only one item, it's already sorted
    if (items.length <= 1) {
        return items;
    }
    //create buckets for digits 0 to 9
    List<Integer>[] buckets = new ArrayList[10];
    for (int i = 0; i < 10; i++) {
        buckets[i] = new ArrayList<>();
    }

    //sort numbers into buckets based on current digit
    for (int number : items) {
        int digit = getDigitFromLeft(number, index); 
        buckets[digit].add(number); 
    }

    //recursive sorting each non-empty bucket
    List<Integer> sorted = new ArrayList<>();
    for (List<Integer> bucket : buckets) {
        if (!bucket.isEmpty()) {
            Integer[] bucketArray = bucket.toArray(new Integer[0]);
            Integer[] sortedBucket = msd(bucketArray, index + 1);
            sorted.addAll(Arrays.asList(sortedBucket)); //combine buckets
        }
    }

    return sorted.toArray(new Integer[0]);
}

//testing in main class
public static void main(String[] args) {
    Integer[] items = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
    
    Integer[] sortedItems = msd(items);

    System.out.println(Arrays.toString(sortedItems));
}
