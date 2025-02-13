package TwoPointers;

/** It is an easy question, solved it in one go*/

import java.util.HashMap;

/**
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array
 * */
public class MaxNumberOfKSumPairs {
    // similar to 2 sum

        public int maxOperations(int[] nums, int k) {
            HashMap<Integer,Integer> hm= new HashMap<>();
            int count=0;

            for(int i=0;i<nums.length;i++){
                // check whether k-nums[i] exists or not
                // if yes toh voh and current element milkr ek pair banaege toh count++ kro and usko nikaalo and isko add mt kro coz ye pair ek baar count ho gya hai
                if(hm.containsKey(k-nums[i])){
                    int value=hm.get(k-nums[i]);
                    hm.put(k-nums[i],value-1);
                    if(value==1){hm.remove(k-nums[i]);}
                    count++;
                }
                else{
                    hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
                }
            }


            return count;
        }

}

