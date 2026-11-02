class Solution {
    public int minMoves2(int[] nums) {
    // {1,2,100} dizisini düşünelim. Medyana göre fark alırsak 99 olur
    // Ama gidip ortalamaya göre fark alma işlemi yaparsak 131 çıkar. 
    // Demek ki avg'yi değil medyanı baz almalıyız
    int medyan;
    Arrays.sort(nums);
    int length = nums.length;
    // Ben alttaki gibi yazmıştım ama YZ çift-tek olmasına bakılmadan int medyan = nums[length / 2]; yazılabilir dedi
    // {1,2,10i,100} için baz alınca 2 için de 10 için de 6 için de 107 çıkıyor
    /*
    if(nums.length % 2 == 0){
        medyan = (nums[length/2] + nums[length/2 -1])/2;
        }else {
            medyan = nums[length/2];
        }
    */
    medyan  = nums[length/2];
    int result = 0;
    for(int i : nums){// For each kullanımında i bütün elemanları gezdiği için indis olarak değil direkt eleman olarak bakıyoruz
        result += Math.abs(i-medyan);
    }
    return result;
    }
}
