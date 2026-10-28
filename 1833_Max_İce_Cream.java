class Solution {
    public int maxIceCream(int[] costs, int coins) {
      // Verilen para ile alınabilecek maksimum dondurma sayısını istemiş. Basit bir sıralama + while sorusu
        int max = 0;
        Arrays.sort(costs);
        int i = 0;
        while(i < costs.length && coins >= costs[i]){ // coins >= 0 gatalı olur, sıradaki elemandan büyük küçüklüğü sorgulanmalı
            coins -= costs[i];
            max++;
            i++;
        }
        return max;
    }
}
