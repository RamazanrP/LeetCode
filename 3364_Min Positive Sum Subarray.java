class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        // İlk başta şöyle yapmıştım sonra fark ettim ki sadece l ve r uzunluğıundaki arraylere bakıyorum. Bu yüzden tek bir for döngüsüne girip l'yi geçtiği anda kontrol etmeye başlayacağım
        /*
        int sum = Integer.MAX_VALUE;
        int currSum;
        for(int i=0; i <= nums.size()-r; i++){
            currSum = 0;
            if(i+l < nums.size()){
                int j=i;
                while(j <= i+l){
                    currSum += nums.get(j);
                    j++;
                }
                if(currSum > 0 && currSum < sum) sum = currSum;
            }

            if(i+r <= nums.size()){
                currSum = 0;
                int j=i;
                while(j < i+r){
                    currSum += nums.get(j);
                    j++;
                }
                if(currSum > 0 && currSum < sum) sum = currSum;
            }
        }
        if(sum == Integer.MAX_VALUE) return -1;
        else return sum;
        */
        int minSum = Integer.MAX_VALUE;
        int n = nums.size();
        int currSum;

        for(int i=0; i<n; i++){
            currSum = 0;
            for(int j=i; j<n && j < i+n; j++){
                currSum += nums.get(j); // uzunluk l'den küçük olsa bile ilk haneyi her zaman ekliyoruz
                int length = j-i + 1; // +1 unutmayalım :)

                if(length >= l && length <= r && currSum > 0){ // Yukardaki length değişkeni sayesinde eğer Array sınırlara uymuyorsa eklenen bir tanecik değer de atlanıyor
                    minSum = Math.min(minSum, currSum);
                }
            }
        }
        return  minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}

// Bu da YZ'nin Optimizsayonu: Daha hızlı olması için her currSum hesabında baştan başlamayıp önceden toplamlarını dizide tutup istenen aralıktaki değerlerin topmaını basit bir matematiksel algoritma ile çıkaracağız

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) { // 0'dan başlayıp iteratif oalrka topladık digitleri
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;
        // 1 3 -4 2 -1 5 için düşüneelim. l=3 diyelim ve -4 için ( i=2) düşünelim bunu:
        for (int i = 0; i < n; i++) {
            for (int len = l; len <= r && i + len <= n; len++) {
                // prefix[] = {0,1,4,0,2,1,5} olarak çıkıyor

                int currSum = prefix[i + len] - prefix[i];  // nums'ta (-4 + 2 + -1) = -3
                                                            // prefix[5] - prefix[2] = 1 - 4 = -3 :)
                if (currSum > 0) {
                    minSum = Math.min(minSum, currSum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
