import java.util.Arrays;

public class DivideArray {
    public static void main(String args[]){
    int nums[] = {1,3,4,8,7,9,3,5,1};
    int result[][] = divideArray(nums, 0);

    System.out.println(Arrays.deepToString(result));
    }
    public static int[][] divideArray(int[] nums, int k){ // LeetCode'un beklediği fonksiyon bloğu sadce bu blok
        Arrays.sort(nums);
        int i=0;
        int[][] result = new int[nums.length/3][3];
        while(i < nums.length){
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }
            int row = i/3;
            result[row][0] = nums[i];
            result[row][1] = nums[i+1];
            result[row][2] = nums[i+2];
            i += 3;
        }

        // return new int[0][0] -> Başta hata vermesini önlemek için bunu geçici olarak yaz
        return result; 
    }
}
