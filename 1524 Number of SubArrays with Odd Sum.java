class Solution {
    public int numOfSubarrays(int[] arr) {
        /*Benim Çözümüm buydu ancak TLE yer uyarısı aldığım için submit etmeye korktum. Boş yere rate'imiz düşmesin :)
        int sum;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                if(sum % 2 == 1) count++;
            }
        }
        return count;*/

        int evenCount = 1;
        int oddCount = 0;
        int prefix = 0;
        int result = 0;
        int MOD = 1_000_000_007; // Soruda kural olarak verilmiş
        /*
        - Yeni prefix tekse, daha önceki çift prefix sayısı kadar yeni tek toplamlı subarray oluşur.
        - Yeni prefix çiftse, daha önceki tek prefix sayısı kadar yeni tek toplamlı subarray oluşur.
        */

        for (int i : arr) {
            prefix += i; // İşte bu YZ dokunuşu

            if (prefix % 2 == 1) {
                result = (result + evenCount) % MOD;
                oddCount++;
            } else {
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }

        return result;
    }
}
