// package Arrays_part1;

/**
 * Topic: Arrays
 * Problem: Binary Search
 * 
 * Description:
 * Given a sorted array of integers and a target value (key), find the index of the key in the array.
 * If the key is not present, return -1.
 * 
 * Intuition:
 * This problem uses the Divide and Conquer strategy. Since the array is sorted, we can 
 * check the middle element. If it matches the key, we're done. If the key is larger, 
 * we know the key must be in the right half, so we discard the left half. If the key 
 * is smaller, we discard the right half.
 * 
 * Complexity: 
 * Time: O(log N) - We halve the search space at each step.
 * Space: O(1) - No extra space is used, only a few variables.
 */
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