class Solution {
    public int longestMonotonicSubarray(int[] nums) {
    /*======== ŞİMDİ AI OPTİMİZASYONUNA GEÇEYİM ==========*/
    if(nums.length == 1) return 1;
    int max = 1;
    int artan = 1;
    int azalan = 1;

    for(int i=0; i<nums.length-1; i++){
        if(nums[i+1] > nums[i]){
            artan++;
            azalan = 1;
        }else if(nums[i+1] < nums[i]){
            artan = 1;
            azalan++;
        }else{ // Eşitlik varsa ikisi de başlangıca döner
            artan = 1;
            azalan = 1;
        }
        max = Math.max(max, Math.max(artan,azalan));
    }
    return max;
    }
}
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
    /*======== ŞİMDİ AI OPTİMİZASYONUNA GEÇEYİM ==========*/
    if(nums.length == 1) return 1;
    int max = 1;
    int artan = 1;
    int azalan = 1;

    for(int i=0; i<nums.length-1; i++){
        if(nums[i+1] > nums[i]){
            artan++;
            azalan = 1;
        }else if(nums[i+1] < nums[i]){
            artan = 1;
            azalan++;
        }else{ // Eşitlik varsa ikisi de başlangıca döner
            artan = 1;
            azalan = 1;
        }
        max = Math.max(max, Math.max(artan,azalan));
    }
    return max;
    }
}
