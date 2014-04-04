/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Matr;

/**
 *
 * @author andrey
 */
public class Fragment {
    public int sum;
    public int i;
    public int j;
    public int i1;
    public int j1;
    public Fragment(){
        sum = Integer.MAX_VALUE;
        i=0;
        i1=0;
        j=0;
        j1=0;
    }
    public void setFragment(int sum, int i, int i1,int j,int j1){
        this.i=i;
        this.i1=i1;
        this.j=j;
        this.j1=j1;
        this.sum =sum;
    }
}
