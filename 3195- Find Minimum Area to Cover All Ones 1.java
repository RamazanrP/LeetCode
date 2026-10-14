public class FindMinimumArea {

    public static int minimumArea(int[][] grid) {
        /* Öncelikle Benim Çözümüm :) */
        int rows = grid.length;
        int cols = grid[0].length;
        // Başlangıç değerlerini Math kullanmak için sınırın üzerinde/altında verelim
        int minRow = rows; 
        int minCol = cols;
        int maxRow = -1;
        int maxCol = -1;

        // Sol üstten başlayarak sağa ve aşağıya git. Sağdaki ilk 1 -> minCol aşağıdaki ilk 1 -> minRow
        // Satır ve sütun 0'la doluysa sağ alt çaprazına gidecek
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                }
            }
        }

        // Sağ alttan başlayarak sola ve yukarıya git. Soldaki ilk 1 -> maxRow yukardaki ilk 1 maxCol
        // Satır ve sütun 0 ile doluysa sol üst çapraza gidecek
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
    /* ------------------------------------------------------------------------- */
    /* Aşağıdaki de Yapay Zekanın kodu. Benden daha hızlı evet ama ben gene de kendi stratejimle çözerdim soruyu */

    class Solution {
    public int minimumArea(int[][] grid) {
        int minRow = grid.length;
        int maxRow = -1;
        int minCol = grid[0].length;
        int maxCol = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1}
        };

        System.out.println(minimumArea(grid)); // 20 çıkacak
    }
}
