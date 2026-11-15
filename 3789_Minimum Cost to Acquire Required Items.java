class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cost = 0;
        /*
        cost1: 1. tür ürünün fiyatı.
        cost2: 2. tür ürünün fiyatı.
        costBoth: İki ihtiyacı birden karşılayan ürünün fiyatı.
        need1: 1. türden kaç birim ihtiyacımız var?
        need2: 2. türden kaç birim ihtiyacımız var? 
        */
        // İhtiyacı tam olarak karşılamak zorunda değiliz.Soru Bize min demiş
        // Şimdi burada kafamız: Her zaman costBoth'a yöneleyim min(need1,need2) için costBoth'dan o kadar alayım zaten ikisini karşılıyor. Sonra fazla ihtiyacı olan için min(costKendi, costBoth) ile çarpar hallederim derdik
        // Ama costBoth çok uçuk derecede fazla olursa patlarız. LeetCode da ilk hint'te buna dikkat çekmiş -> First, use min(costBoth, cost1 + cost2) for min(need1, need2) denmiş
        if((long)cost1+cost2 <= costBoth){ // Toplamları bile küçükse hayli hayli kendi değerlerini kullanır Both'a hiç bakmayız
            cost = (long) cost1*need1 + (long)cost2*need2;
            return cost;
        }else{
            // 1 Both 2 tane cost'a bedel olduğu için toplamlarından küçükse KESİNLİKLE BOTH'U TERCİH ETMELİYİZ
            int ortak = Math.min(need1,need2);
            cost = (long) costBoth * ortak;
            need1 -= ortak;
            need2 -= ortak;
        }
        // Toplamlrından küçük ama direkt itemin cost'undan küçük mü bilmiyoruz
        if(need1 > 0) cost += (long) need1 * Math.min(cost1, costBoth);
        if(need2 > 0) cost += (long) need2 * Math.min(cost2, costBoth);
        return cost;
    }
}
