package com.tecpalle;

import java.util.Scanner;

public class hello {
	
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
	        int n=sc.nextInt();
	        int d=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	            a[i]=sc.nextInt();
	      Main m=new Main();
	        
	       m.rotateLeft(a,n,d);
	        
	        for(int i=0;i<n;i++)
	            System.out.print(a[i]+" ");
	
	}
	}
class Main
{
   public static void rotateLeft(int a[],int n, int d)
   {
       int first,i,j;
       for(i=0;i<d;i++)
       {
           first=a[0];
           for(j=0;j<n-1;j++)
               a[j]=a[j+1];
           a[j]=first;
       }
   }


}



