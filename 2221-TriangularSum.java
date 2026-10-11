import java.util.Arrays;

public class TriangularSum {
    
    public static void main(String args[]){
            int nums[] = {1,2,3,4,5};
            int result = triangularSum(nums);
            System.out.println(result);
    }

    public static int triangularSum(int[] nums) {
    int len = nums.length;
    if(len==1) return nums[0];
    int oncekiArray[] = Arrays.copyOf(nums, len);
    
    while(len > 1){
        int newArray[] = new int[len-1]; // YENİ ARRAY OLUŞTURMA BU ŞEKİLDE
        for(int i=0; i<len-1; i++){
            newArray[i] = (oncekiArray[i] + oncekiArray[i+1]) % 10;
        }
        oncekiArray = newArray; // Direkt böyle kopyalanabilir
        len--;  
    }
        return oncekiArray[0];
    }
    
    
}
