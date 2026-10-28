class Solution {
    public int minNumberOperations(int[] target) {
        // Şaka derecesinde kısa :D
        int sonuc = target[0];// En baştan eklenmiş gibi davranıyoruz
        for(int i = 1; i< target.length; i++){
            // digit'e ve öncekine bakıyoruz.
            //Sadece öncekine göre artanları baz alıyoruz çünkü digit önceki digit'ten büyükse, aradaki fark kadar yeni +1 operasyonu başlatmamız gerekiyor.
            // Eğer küçük veya eşitse yeni bir operasyon gerekmez; önceki operasyonlar zaten o seviyeyi karşılıyor.
            sonuc += Math.max(target[i] - target[i-1], 0);
        }
        return sonuc;
    }
}
