class Solution {
    public int BinaryElements(int[] nums) {
        // Her seferinde ardışın 3 digit 0 ise 1 e, 1 ise 0 a döndürülecek. Bütün diziyi 1 yapmak imkansızsa return -1
        int len = nums.length;
        int sayac = 0;
        for(int i=0; i< len -2; i++){
            if(nums[i] == 0){
                sayac++;
                nums[i]=1;
                nums[i+1] = 1-nums[i+1];
                nums[i+2] = 1-nums[i+2];
            }
        }
        // Bundan sonra son 2 digit'e dokunamayız. Possibility kontrolü yapcaz
        if(nums[len-1] == 0 || nums[len-2] == 0) return -1;
        return sayac;
    }
}
