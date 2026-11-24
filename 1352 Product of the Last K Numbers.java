class ProductOfNumbers {
    // Soru bizden son k elmanı istiyorsa O(1) hızında yapmak için EN SON BİRİKİM / K KADAR GERİDEKİ BİRİKİM
    // 3, 2, 5 eklendiğinde liste -> [1, 3, 6, 30] şeklinde büyümeli
    // Çarpma ve Bölmede etkisiz eleman 1'i ekledim ki  işlemeleri kolaylaşsın
    private ArrayList<Integer> liste = new ArrayList<>(); // ()<> diye initialize edince hata verdi
    private int n = 0;

    public ProductOfNumbers() {
        this.liste.add(1); // ArrayList'te [] yok ! 
        this.n = 1;
    }
    
    public void add(int num) {
        if(num == 0){
            // 0 geldiği anda kendisinden önceki tüm sayıların çarpımını yutar.
            liste = new ArrayList<>(); // 0'a bölünme hatası almamak için yeni bir dizi açmak en kolayı
            // Gerekli initilizationları yapalım
            liste.add(1);
            n = 1;
            return;
        }else{
            liste.add(liste.get(n-1)*num);
            n++;
        }
    }
    
    public int getProduct(int k) {
        // Baştaki '1' hariç elimizde n-1 tane geçerli sayı var
        // İstenen k sayısı bundan fazlaysa (k >= n), arada MUTLAKA bi '0' gelip listeyi sıfırlamış demektir!
        if(k >= n) return 0;
        return liste.get(n-1)/liste.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
