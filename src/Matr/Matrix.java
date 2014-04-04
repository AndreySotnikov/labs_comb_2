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
    
   /* public Matrix (DefaultTableModel model){
        size = model.getColumnCount()+1;
        matr = new int[size+1][size+1];
        tmp = new int[size+1][size+1];
        for (int i=0;i<size;i++){
            matr[i][0] = 0;
            matr[0][i] = 0;
        }            
        for (int i=1;i<size;i++)
            for (int j=1;j<size;j++)
                matr[i][j] = Integer.parseInt((String)model.getValueAt(i-1, j-1));
    } */
    public Matrix(int n){
       size = n+1;
       matr = new int[size-1][size-1];
       tmp = new int[size][size];
       for (int i=0;i<size;i++){
            tmp[i][0] = 0;
            tmp[0][i] = 0;
        }    
        Random rand = new Random();
        for (int i=0;i<size-1;i++)
            for (int j=0;j<size-1;j++)
                matr[i][j] = -500 + rand.nextInt(1000);
    }
    public int getValue(int i,int j){
        return matr[i][j];
    }
    
    public void printToTable(DefaultTableModel model){
        model.setColumnCount(size-1);
        model.setRowCount(size-1);
        for (int i=0;i<size-1;i++)
            for (int j=0;j<size-1;j++)
                model.setValueAt(matr[i][j], i, j);
    }
    
    public void getPartSum(){
        /*tmp[0][0] = matr[0][0];
        for (int i=1;i<size-1;i++){
            tmp[0][i] = tmp[0][i-1] + matr[0][i];
            tmp[i][0] = tmp[i-1][0] + matr[i][0];
        }*/
        for (int i = 1;i<size;i++)
            for (int j=1;j<size;j++)
                tmp[i][j] = tmp[i-1][j]+tmp[i][j-1]-tmp[i-1][j-1]+matr[i-1][j-1];
    }
    
    public void task(Fragment a){
        this.getPartSum();
        int t;
        for(int i = 1; i<size;i++)
            for (int j = 1; j<size;j++)
                for (int i1 = i; i1<size;i1++)
                    for(int j1 = j;j1<size;j1++){
                        t = Math.abs(tmp[i1][j1]-tmp[i-1][j1]-tmp[i1][j-1]+tmp[i-1][j-1]); 
                        if (t<a.sum || (t==a.sum && (i1-i)*(j1-j) > (a.i1-a.i)*(a.j1-a.j))){
                            a.setFragment(t, i-1, i1-1, j-1, j1-1);
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

