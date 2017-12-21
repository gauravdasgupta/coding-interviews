package com.java.matrixgames;

/**
 * Created by dasguptag on 22-12-2017.
 */
public class SpiralTraversal {

    static void printSpiral(int lastRowIndex, int lastColIndex, int a[][]){
        int i,startRowIndex=0;
        int startColIndex=0;
        while(startRowIndex<lastRowIndex && startColIndex<lastColIndex){
            for(i=startColIndex;i<lastColIndex;++i){
                System.out.println(a[startRowIndex][i]+" ");
            }
            startRowIndex++;
            for(i=startRowIndex;i<lastRowIndex;++i){
                System.out.println(a[i][lastColIndex-1]+" ");
            }
            lastColIndex--;
            if(startRowIndex<lastRowIndex){
                for(i=lastColIndex-1; i>=startColIndex; --i){
                    System.out.println(a[lastRowIndex-1][i]+" ");
                }
                lastRowIndex--;
            }
            if(startColIndex<lastColIndex){
                for(i=lastRowIndex-1;i>=startRowIndex;--i){
                    System.out.println(a[i][startColIndex]+" ");
                }
                startColIndex++;
            }

        }
    }

    public static void main(String args[]){
        int a[][] = {{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
                    };
        printSpiral(4,4,a);
    }
}
