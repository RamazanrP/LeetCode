class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
      /*Değişken	Görevi
        logs -> Zamana göre sıralanmış istek kayıtları
        ids -> Sorguların sıralanmış orijinal indeksleri 
        cnt[id]	-> İlgili sunucunun pencere içindeki istek sayısı
        left -> Pencereden çıkarılacak logları takip eder
        right	-> Pencereye eklenecek logları takip eder
        active -> Pencere içinde en az bir isteği olan sunucu sayısı
        ans -> Her sorgunun cevabını orijinal indeksinde tutar
      */
      // Sliding Window çözümünü kullanmak için hem queryleri hem de log kayıtlarını sıralayacağız
      Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));
      int m = queries.length;
      Integer[] ids = new Integer[m];
      for(int i=0; i<m; i++) ids[i] = i;
      Arrays.sort(ids, (i,j) -> Integer.compare(queries[i], queries[j]));

      int[] ans = new int[m]; // ne kadar aralık varsa o adette
      int[] cnt = new int[n+1]; // sunucu numaraları 1'den başladığı için :)
      int left = 0, right = 0, active = 0;

      // Right da Left de en küçük değerlerinden başlatıldıktan sonra bir daha azalmayacak. O yüzden rahatlıkla while dışında 0'dan başlattık.
      for(int i : ids){
        int q = queries[i]; //İŞTE BU YÜZDEN ORİJİNAL DİZİ ÜZERİNDEN SIRALAMA YAĞMADIK. Artık elimizde en küçük değerin İNDİSİ var
        while(right < logs.length && logs[right][1] <= q){
            int id = logs[right++][0]; // serverId'yi atadık
            if(cnt[id] == 0) active++;
            cnt[id]++;// == 0 olsun olmasın sayısı artacak. Bizim için önemli olan zaten 0'dan 1'e çıkışı ve 1'den 0'a düşüşü. İsterse 10 isteği olsun aga
        }
        while(left < right && logs[left][1] < q-x){ // left sınırından küçük olduğunda pencere dışında kalmış oluyor
        int id = logs[left++][0];
        cnt[id]--;
        if(cnt[id] == 0) active--; // Sadece 1'den 0'a düşüş önemliydi
        }
        ans[i] = n - active; // toplam sunucu sayısından aktif'i çıkar ki boşta kalanları bulasın
      }
      return ans;
    }
}
