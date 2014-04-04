/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Matr;

import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andrey
 */
public class Matrix {
    private int[][] matr;
    private int[][] tmp;
    private final int size;
    
    public Matrix (DefaultTableModel model){
        size = model.getColumnCount();
        matr = new int[size][size];
        tmp = new int[size][size];
        for (int i=0;i<size;i++)
            for (int j=0;j<size;j++)
                matr[i][j] = Integer.parseInt((String)model.getValueAt(i, j));
    }
    public Matrix(int n){
        size = n;
        matr = new int[n][n];
        tmp = new int[n][n];
        Random rand = new Random();
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                matr[i][j] = -500 + rand.nextInt(1000);
    }
    public int getValue(int i,int j){
        return matr[i][j];
    }
    
    public void printToTable(DefaultTableModel model){
        model.setColumnCount(size);
        model.setRowCount(size);
        for (int i=0;i<size;i++)
            for (int j=0;j<size;j++)
                model.setValueAt(matr[i][j], i, j);
    }
    
    public void getPartSum(){
        tmp[0][0] = matr[0][0];
        for (int i=1;i<size;i++){
            tmp[0][i] = tmp[0][i-1] + matr[0][i];
            tmp[i][0] = tmp[i-1][0] + matr[i][0];
        }
        for (int i = 1;i<size;i++)
            for (int j=1;j<size;j++)
                tmp[i][j] = tmp[i-1][j]+tmp[i][j-1]-tmp[i-1][j-1]+matr[i][j];
    }
    
    public void task(Fragment a){
        this.getPartSum();
        int t;
        for(int i = 0; i<size;i++)
            for (int j = 0; j<size;j++)
                for (int i1 = i; i1<size;i1++)
                    for(int j1 = j;j1<size;j1++){
                        if (i==0 && j==0)
                            t = Math.abs(tmp[i1][j1]);
                        else
                            if (i==0)
                                t = Math.abs(tmp[i1][j1]-tmp[i1][j-1]);
                            else
                                if (j==0)
                                    t = Math.abs(tmp[i1][j1]-tmp[i-1][j1]);
                                else    
                                    t = Math.abs(tmp[i1][j1]-tmp[i-1][j1]-tmp[i1][j-1]+tmp[i-1][j-1]); 
                        if (t<a.sum){
                            a.setFragment(t, i, i1, j, j1);
                        }else
                            if(t==a.sum && (i1-i)*(j1-j) > (a.i1-a.i)*(a.j1-a.j)){
                                a.setFragment(t, i, i1, j, j1);
                            }
                    }
/*        for (int k=0;k<size;k++){
            for (int m=0;m<size;m++)
                System.out.print(tmp[k][m] + " ");
            System.out.println("");
        }
        System.out.println("");*/
    }
}

