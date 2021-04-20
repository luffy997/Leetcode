package review;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其
 * 中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * @author 路飞
 * @create 2021/4/10 10:14
 */
public class Exist {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isVisited[i][j]) continue;
                if (dfs(board,wordArr,i,j,0,isVisited)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board,char[] wordArr,int m,int n,int k,boolean[][] isVisited){
        if (m >= board.length || n >= board[0].length || board[m][n] != wordArr[k] || m <0 || n <0) return false;
        if (k == wordArr.length-1) return true;
        isVisited[m][n] = true;
        boolean res = dfs(board,wordArr,m+1,n,k+1,isVisited) || dfs(board,wordArr,m,n+1,k+1,isVisited)||
                      dfs(board,wordArr,m-1,n,k+1,isVisited) ||  dfs(board,wordArr,m,n-1,k+1,isVisited);
        isVisited[m][n] = false;
        return res;
    }
}
