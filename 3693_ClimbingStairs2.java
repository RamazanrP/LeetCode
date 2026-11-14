
class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0, b = 0, c = 0;

        // a: Mevcut basamaktan 3 basamak önceki minimum maliyet
        // b: Mevcut basamaktan 2 basamak önceki minimum maliyet
        // c: Mevcut basamaktan 1 basamak önceki minimum maliyet
        // Her iterasyonda yalnızca son 3 basamağın maliyetini tutuyoruz

        for (int i = 0; i < n; i++) {

            // 3 basamak geriden gelme: a + 9
            // 2 basamak geriden gelme: b + 4
            // 1 basamak geriden gelme: c + 1
            // En düşük maliyeti bulup gidilen basamağın maliyetini ekliyoruz
            int next = Math.min(Math.min(a + 9, b + 4), c + 1) + costs[i];

            // Son 3 basamağın değerlerini bir basamak ileri kaydırıyoruz
            a = b;
            b = c;
            c = next;
        }

        return c;
    }

    /*
       ÖRNEK: costs = {9, 8, 3} olsun

       1. iterasyon (i = 0):
       Hedef 1. basamak
       Sadece 0'dan 1'e gelebiliriz
       Maliyet = 0 + 9 + 1² = 10
       => a = 0, b = 0, c = 10

       2. iterasyon (i = 1):
       Hedef 2. basamak
       0'dan 2'ye: 0 + 8 + 2² = 12
       1'den 2'ye: 10 + 8 + 1² = 19
       Minimum maliyet = 12
       => a = 0, b = 10, c = 12

       3. iterasyon (i = 2):
       Hedef 3. basamak.
       0'dan 3'e: 0 + 3 + 3² = 12
       1'den 3'e: 10 + 3 + 2² = 17
       2'den 3'e: 12 + 3 + 1² = 16
       Minimum maliyet = 12
       => a = 10, b = 12, c = 12

       Döngü tamamlandığında c, hedef basamağa ulaşmanın minimum maliyetini tutar.
       return c = 12
    */
}
