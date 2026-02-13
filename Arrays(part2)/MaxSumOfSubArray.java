public class MaxSumOfSubArray {
    public static void maximumsumOfSubArrays(int[] arr) {
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;// needs to be reinitialized to zero after a sum of single subarray
                for (int k = i; k <= j; k++) {
                    // System.out.print(arr[k]); not needed to print the suba array
                    sum += arr[k];
                }
                System.out.print(sum);
                if (sum > maxsum) {
                    maxsum = sum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Max sum is " + maxsum);
        /*
         * here the usage of 3 for loops has led to increase the time complexity by
         * O(x^3) which
         * is not that good 
         */
    }

    public static void maximumsumOfSubArrays02(int[] arr) {
        // calcuate the prefix array first
        int[] prefix = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxsum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == 0) {// as in the formula ur accessing i-1 so what if i=0?
                    sum = prefix[i];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                } // u can use ternary too here
                if (sum > maxsum) {
                    maxsum = sum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Max sum is " + maxsum);
    }

    /*
     * there is another method even with less complexity named as kadane's algo
     * where u just declare 2 var one is cur and ms
     * if the numbers are (larger +ve)+(larger +ve) its fine
     * if the numbers are (larger +ve)+(minor -ve) its fine
     * if the numbers are (lager -ve)+(larger -ve) then just use 0
     */
    public static void kadane(int[] arr) {
        int cs = 0, ms = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println(ms);
    }

    public static void maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        // Enhanced version
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int[] arrr = {-2,1};
        // maximumsumOfSubArrays(arrr);
        // kadane(arrr);
        maxSubArray(arrr);
    }
}

/* tendency of max and min function 
 * carefully analyze the var which  is first initialized suppose u check 
 * Math.max(0,arr[i]) so this will always skip -ve values as 0 is set as lower boundary 
 * same thing vice versa for Math.min
 */