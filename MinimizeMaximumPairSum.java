import java.util.Arrays;
/*
System.out.println(Arrays.toString(nums)); Okunabilir olarak yazdırır
System.out.println(Arrays.equals(a, b)); true/false output'u verir
Arrays.fill(nums, -1); // bütün haneleri -1 ile doldurur
int[] copy = Arrays.copyOf(nums, nums.length); (Daha büyük uzunluk yazarsan 0 olarak doldurur)
int index = Arrays.binarySearch(nums, 30); (Bunu uygulamak veya pozitif indeksini almak için SIRALANMIŞ OLMALI)
int[] part = Arrays.copyOfRange(nums, 1, 4); (1 DAHİL 4 DAHİL DEĞİL)
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

System.out.println(Arrays.deepToString(matrix)); [[1, 2, 3], [4, 5, 6]] Yazdıracak
System.out.println(Arrays.deepEquals(a, b)); 2D dizileri karşılaştıracak, true/false yazdırır
*/
public class MinimizeMaximumPairSum{
    public class Main {
    public static void main(String[] args){ // Main metodunu bir nesne oluşturmadan çağırabilmek için STATİC
        int[] nums = {2,3,5,2};
        int result = minPairSum(nums);
        
        System.out.println(result);
    }

    public static int minPairSum(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        int maxSum = 0, geciciSum;
        
        for(int i=0; i<len/2; i++){
            geciciSum = nums[i] + nums[len-1-i];
            if(geciciSum > maxSum) maxSum = geciciSum;
        }
        return maxSum;
    }
}
}