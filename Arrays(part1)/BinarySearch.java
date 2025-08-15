public class BinarySearch {
    public static int binarySearch(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // comparisons
            if (numbers[mid] == key) { // found
                return mid;
            }

            if (numbers[mid] < key) { // search in right half
                start = mid + 1;
            } else { // search in left half
                end = mid - 1;
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;

        int index = binarySearch(numbers, key);

        if (index == -1) {
            System.out.println("Key not found.");
        } else {
            System.out.println("Key found at index: " + index);
        }
    }
}