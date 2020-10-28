// Time Complexity :O(n+m) where n is the size of nums and m is the maximum value in nums array
// Space Complexity :O(m) where m is the maximum value in nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Please correct me on the time complexity
                                            // I am a liitle bit confused on the recursive solution too (how do we understand
                                            // that the recursive is not possible with the given input and that we have to alter the
                                            // input array)


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        //return 0, if nums is null or empty
        if(nums == null || nums.length ==0) return 0;
        
        int max = 0;
        //find the maximum
        for(int i=0; i< nums.length; i++){
            max = Math.max(nums[i], max);
        }
        
        //create a new array with size as max value
        int []arr = new int[max+1];
        
        //add value from nums array to arr array at index equal to value
        for(int i=0; i<nums.length; i++){
            arr[nums[i]] += nums[i];
        }
        
        //skip represents dont choose
        int skip = 0;
        //take represents choose
        int take = arr[0];
        
        //iterate over arr array
        for(int i =1; i<arr.length; i++){
            //save skip in temp
            int temp = skip;
            //as we are not choosing current value
            //skip is equal to minimum between previous skip and take
            skip = Math.max(temp, take);
            //as we are choosing current value, therefore we cannot choose the previous
            //that is take is equal to previous skip (as skip represents not choosing the value) plus current value
            take = temp + arr[i];
        }
        
        //the maximum between skip and take will be the maximum earnings
        return Math.max(skip, take);
    }
}