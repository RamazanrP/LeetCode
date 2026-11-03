class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for(int i : nums){ // int yazmayı unutma!
            if(i > max) max = i;
        }
        int sum = 0;
        for(int i : nums) sum += max-i;
        return sum;
    }
}
