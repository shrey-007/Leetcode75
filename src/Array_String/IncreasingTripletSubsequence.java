package Array_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
 * nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * */
public class IncreasingTripletSubsequence {

    // brute force is generate all i,j,k combinations using 3 loops

    // optimised approach
    public boolean increasingTriplet(int[] nums) {

        int n=nums.length;

        int low=Integer.MAX_VALUE;
        int mid=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i]<=low){low=nums[i];}
            else if(nums[i]<=mid){mid=nums[i];}
            else{
                // low,mid,high are not actually i,j,k but if you really found low,mid,high then ans is true
                return true;}
        }

        // equal to lagane ka reason-:
        // test case-[1,1,1,1,1,1,1,1,1,1,1] toh equal ni lagaoge toh 1 low,mid dono mai lag jaaega jo ki galat hai


        return false;


    }

}
