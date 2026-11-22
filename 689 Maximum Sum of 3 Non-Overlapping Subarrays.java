// İtiraf: Sorunun ne kadar zor olduğunu YZ açıklayınca anladım ve sondaki for döngüsü dışındakilerini kendim yazdım.  Son for mantığını kendisi özellikle belirtti ve baya beğendim
// Ama bir sıkıntımız var kod bu haliyle 267 ms ve %5 i beat ediyor sadece :(
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        // - W[]   -> BÜYÜKLÜK (k elemanlı pencere toplamlarını) tutar.
        // - sol[] -> İNDİS (soldaki en büyük pencerenin başlangıç indisi) tutar.
        // - sag[] -> İNDİS (sağdaki en büyük pencerenin başlangıç indisi) tutar.
        int[] W = new int[len - k + 1]; // 0'dan len-k'ya kadar indisler tutulacak
        int[] sol = new int[len-k + 1];
        int[] sag = new int[len-k + 1];

        // "Neden <=": len - k = 6, i = 6 iken nums[6] ve nums[7]'yi toplarız, dizi biter
        for(int i=0; i<=len-k; i++){
            int j=0;
            while(j<k){
                W[i] += nums[i+j];
                j++; // UNUTMA
            }
        }
        // Bu döngü bitince W dizisi (BÜYÜKLÜKLER):
        // İndis:  0   1   2   3    4    5   6
        // W[]  : [3,  3,  3,  8,  13,  12,  6]

        //===============================//

        sol[0] = 0;
        for(int i=1; i<=len-k; i++){
            /* Şu anki pencerenin toplamı (W[i]), şu ana kadar gördüğümüz en iyi pencerenin toplamından
            (W[sol[i - 1]]) KESİN BÜYÜK mü?
            */
            // Neden '>' kullandık da '>=' kullanmadık?
            // Soru, bizden "Eşitlik varsa İNDİSİ KÜÇÜK (en soldaki) olanı seç" diyor.
            // W[0]=3 ve W[1]=3. Eşitler! '>' şartı false olur, else'e düşer ve eski küçük indis olan 0 korunur!
            if (W[i] > W[sol[i - 1]]) sol[i] = i; // İNDEKSİ TUTUYORUZ
            // if'te W[i-1] yerine sol[i-1] e bakıyoruz çünkü bizi ilgilerndiren önceki değil BİZDEN ÖNCE GELEN EN BÜYÜK TOPLAMIN BAŞLANGIÇ İNDİSİ
            else sol[i] = sol[i - 1];
        }
        // Bu döngü bitince sol dizisi (İNDİSLER):
        // İndis:  0  1  2  3  4  5  6
        // sol[]: [0, 0, 0, 3, 4, 4, 4]
        // sol[2] = 0 demek -> "0..2 arasında en büyük toplam 0. indiste var" demek

        //==================================//

        // 5'ten başlayıp sağındaki (i + 1 = 6) ile kıyaslayarak geriye gidelim
        sag[len-k] = len-k;
        for (int i = len - k - 1; i >= 0; i--) {
            /* Neden burada '>=' kullandık? (sol'da '>' dü)
            // Çünkü sağdan sola (6 -> 5 -> 4...) geliyoruz. Şu anki 'i', sağdaki
            // 'sag[i + 1]'den DAHA KÜÇÜK (daha solda) bir indistir.
            // Eğer toplamları EŞİT çıkarsa, soru bizden küçük indisi istediği için
            // yeni (soldaki) 'i' eskisini EZEBİLSİN diye '>=' şartı koyuyoruz!*/
            if (W[i] >= W[sag[i + 1]]) sag[i] = i;
            else sag[i] = sag[i + 1];
        }
        // Bu döngü bitince sag dizisi (İNDİSLER):
        // İndis:  0  1  2  3  4  5  6
        // sag[]: [4, 4, 4, 4, 4, 5, 6]
        // (Örn: sag[5] = 5 demek -> "5..6 arasında en büyük toplam 5. indiste var" demek)

        //---------------------------------------------//

        int[] result = {-1, -1, -1};
        int maxSum = 0, currSum=0;
        for(int mid = k; mid <= len - 2*k; mid++){
            // Burada büyüklük karşılaştırması yapacağız. O yüzden W[] içinde sol,mid ve sag ı kullandık
            currSum = W[sol[mid-k]] + W[mid] + W[sag[mid+k]];
            // Sorunun bizden non-overlapping dediğini unutmayalım. Demek ki biz mid seçtikten sonra 
            // sol için -> 0'dan mid-k ya kadar gelebiliriz, mid-k+1 olduğu anda çakışma olur
            // sağ için -> len-k dan başlar mid+k ya kadar iner, mid+k-1 e düştüğü anda çakışma olur
            if(result[0] == -1 || currSum > maxSum){
                // result'ta İNDİSLERİ TUTUYORUZ, BÜYÜKLÜĞÜ DEĞİL
                result[0] = sol[mid-k];
                result[1] = mid;
                result[2] = sag[mid+k];
                maxSum = currSum;
            }
        }
        return result;
    }
}
