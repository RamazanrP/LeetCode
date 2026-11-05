class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int sayac = 0;
        boolean varMi; // break ile çok daha hızlanmamızı sağlayacak
        for(int i=0; i<arr1.length; i++){
            varMi = false;
            for(int j=0; j<arr2.length; j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    varMi = true;
                    break;
                }
            }
            if(!varMi) sayac++;
        }
        return sayac;
    }
}
