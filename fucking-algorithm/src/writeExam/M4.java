package writeExam;

import java.util.Scanner;

/**
 * @author 路飞
 * @create 2021/4/27 20:53
 */
public class M4 {

    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        int x=reader.nextInt();
        int[][]array=new int[x][2];
        for(int i=0;i<x;i++){
            for(int j=0;j<2;j++){
                array[i][j]=reader.nextInt();
            }
        }
        System.out.println(maxEnvelopes(array));
    }

    public static  int maxEnvelopes(int[][] envelopes){
        return envelopes.length/2;
    }
}
