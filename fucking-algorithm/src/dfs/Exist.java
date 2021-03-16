package dfs;

/**
 * medium
 * 79. 单词搜索
 * @author 路飞
 * @create 2021/3/9 16:55
 */
public class Exist {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        //打印
        System.out.println("map");
        int j = board.length; //行
        int i = board[0].length; //列
        for (int i1 = 0; i1 < j; i1++) {
            for (int i2 = 0; i2 < i; i2++) {
                System.out.print(board[i1][i2]+" ");
            }
            System.out.println();
        }
        System.out.println(exist(board, "ABCCED"));

    }

    /**
     * 先遍历一次  找单词的首字母 没有 就直接返回false
     * 路线有两者清楚 可直接修改
     * 0 -- > 没有被使用
     * 1 --> 该单词已经使用了
     * 2 --> 该字母不在单词中
     * 走路策略是下-右-上-左
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,words,i,j,0)) return true;


            }
        }
            return false;
    }


    public static boolean dfs(char[][] board,char[]word,int i,int j,int k){
        if ( i >= board.length || i < 0 || j>=board[0].length || j<0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';//做标记是为了防止标记字符与矩阵原有字符重复。当存在重复时，此算法会将矩阵原有字符认作标记字符，从而出现错误
        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i,j+1,k+1)
                || dfs(board,word,i-1,j,k+1) || dfs(board,word,i,j-1,k+1);
        board[i][j] = word[k];
        return res;
    }
}
