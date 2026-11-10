class Solution {
    public int countServers(int[][] grid) {
        int lenSatir = grid.length;
        int lenSutun = grid[0].length;
        int[] satirlar = new int[lenSatir]; 
        int[] sutunlar = new int[lenSutun];
        int birSayac = 0;

        for(int i=0; i<lenSatir; i++){
            for(int j=0; j<lenSutun; j++){
                if(grid[i][j] == 1){
                    birSayac++;
                    satirlar[i]++;
                    sutunlar[j]++;
                }
            }
        }

        int izolatedSayac = 0;
        for(int i=0; i<lenSatir; i++){
            for(int j=0; j<lenSutun; j++){
                // Alttaki if'te grid i j kontolü koymazsak Toplam sayıya bakar
                // Hücrede var olup olmamasına DEĞİL.
                // Biz de servera sahip hücrenin satir&sutun bilgisi gerekli
                if(grid[i][j] == 1 && satirlar[i] == 1 && sutunlar[j] == 1){
                    izolatedSayac++;
                }
            }
        }

        return birSayac-izolatedSayac;
    }
}
