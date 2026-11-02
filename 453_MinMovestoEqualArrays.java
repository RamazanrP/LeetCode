class Solution {
    public int minMoves(int[] nums) {
    // Çözüm mantığını bu yorumda buldum: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/comments/1576546/
    Arrays.sort(nums);
    int enKucuk = nums[0];
    int sum = 0;
    for(int i=1; i<nums.length; i++){ // zaten ilk elemanı almıştık. 1'den başlatcam
    sum += nums[i] - enKucuk;
    }
    return sum;
    }
}
/* AI'ın optimize kodu */
class Solution {
    public int minMoves(int[] nums) {
      // Arraysçsort() un yavaşlattığını söyledi. 16 ms'ten 2 ms'e düştü :)
    int min = nums[0];
    for(int i: nums){
        if(i < min) min = i;
    }
    int sum=0;
    for(int i : nums){
        sum += i - min;
    }
    return sum;
    }
}
