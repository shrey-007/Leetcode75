package slidingWindow;

/**
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no
 * such subarray.
 * */
public class LongestSubarrayOfOneAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        boolean isDeleted=false;

        int start=0;
        int end=0;

        int ans=0;

        while(end<nums.length){

            // if condition matches , increase the length
            if(nums[end]==1){
                ans=Math.max(ans,end-start+1);
                end++;
            }
            else{
                // if condition matches but we can delete one element than also increase window
                if(isDeleted==false){
                    isDeleted=true;
                    ans=Math.max(ans,end-start+1);
                    end++;
                }
                else{
                    // if condition does not matches and we can't delete 0, then start++ kro jab tak first 0 na aaye jise
                    // tumne delete kra
                    while(nums[start]!=0){
                        start++;
                    }
                    start++;
                    // start vaala 0 tha toh start ++ kra toh isDeleted=false hoga, but end vaala 0 hai toh ise lena hai
                    // toh vaapis isDeleted=true kro, isliye isDeleted ko kuch ni kra
                    // isDeleted=false;
                    end++;
                }
            }
        }

        return ans-1;
    }

}
