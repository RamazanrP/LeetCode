/* ========= Benim Çözümüm =================*/
class Solution {
    public int countBattleships(char[][] board) {
      int satir = board.length;
      int sutun = board[0].length;
      int sayac = 0;
      for(int i=0; i<satir; i++){
        for(int j=0; j< sutun; j++){
            if(board[i][j] == 'X'){
                if(i==0 && j==0){
                    sayac++;
                }else if(i==0 && j >0 && board[i][j-1] == '.'){
                    sayac++;
                }else if(j==0 && i>0 && board[i-1][j] == '.' ){
                    sayac++;
                }else if( i>0 && board[i-1][j] == '.' && j >0 && board[i][j-1] == '.'){
                    sayac++;
                }
            }
        }
      }
      return sayac;
    }
}
/* =============== Yapay Zekanın daha kısa ama aynı Run Time'ı verem kodu =============== */
class Solution {
    public int countBattleships(char[][] board) {
      int satir = board.length;
      int sutun = board[0].length;
      int sayac = 0;
      for(int i=0; i<satir; i++){
        for(int j=0; j< sutun; j++){
                if (board[i][j] == 'X') {
                    boolean ustteX = i > 0 && board[i-1][j] == 'X';
                    boolean soldaX = j > 0 && board[i][j-1] == 'X';

                    if (!ustteX && !soldaX) {
                        sayac++;
                    }
                }
            }
        }
      return sayac;
    }
}
