package slidingWindow;

public class MaximumAverageSubarrayI {
    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     *
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
     * */

    /**
     * Since it is fixed size sliding window toh saari windows mai k elements hoge, toh max avg vaala subarray vahi hoga
     * jiska max sum hoga coz sabmai number of elements same hoge
     * Toh max sum nikaal lo. But end mai avg hi return krna hai toh divide by k krdena
     * */
    public static double findMaxAverage(int[] nums, int k) {
        int start=0;
        int end=0;

        double average=0;
        double ans=-1e9;

        while(end<nums.length){
            // do work on end
            average=average+nums[end];

            // window size is smaller
            if(end-start+1<k){end++;}

            // window is of k size
            else{
                // this is possible ans, so update ans
                ans=Math.max(ans,average);

                // remove calculation of start
                average=average-nums[start];
                start++;
                end++;
            }
        }

        return ans/k;
    }

    public static void main(String[] args) {
        int arr[]={-1};
        System.out.println(findMaxAverage(arr,1));
    }
}
