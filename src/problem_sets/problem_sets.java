/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem_sets;

import java.util.*;

/**
 *
 * @author M Lapan
 */
public class problem_sets {

    /**
     * @param args the command line arguments
     */
    
    // ========= answer for question 1 =======
    static int NO_OF_CHARS = 256;
    static boolean canFormPalindrome(String str)
    {
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);
 
        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;
 
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;
            if (odd > 1)
                return false;
        }
        return true;
    }
    
    
    // ========= answer for Q2 ============= 
    public static void setZeros(int[][] matrix) {
    int[] row = new int[matrix.length];
    int[] column = new int[matrix[0].length];
    
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                row[i] = 1;
                column[j] = 1;
            }
        }
    }
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if ((row[i] == 1 || column[j] == 1)) {
                matrix[i][j] = 0;
            }
        }
    }
    for(int i=0;i<matrix.length;i++)
    {
        for(int j =0;j<matrix[0].length;j++)
        {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println("");
    }
}
    
    // ==============answer for question 3 ===================
    public static int findStep(int n)
    {
        switch (n) {
            case 1:
            case 0:
                return 1;
            case 2:
                return 2;
            default:
                return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
        }
    }
    
    // ============= answer for question 4 ==============
    
    public static String swap4(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    
    public static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap4(str,l,i);
                permute(str, l+1, r);
                str = swap4(str,l,i);
            }
        }
    }
    
    //=========answer for question 5 ===========
   
    
    // A utility method to swap two numbers.
    public static void PeaksValleys(Integer[] arr){
    
        int n = arr.length;
        List<Integer> peaks=new ArrayList<>();  
        List<Integer> valleys=new ArrayList<>();  
        Integer [] rearranged = new Integer[n];
        
        for(int i =0;i<n;i++)
        {
            if(i < n-1){
            if(arr[i] >= arr[i+1])
            {
                peaks.add(arr[i]);
            }
            else if(arr[i] <= arr[i+1])
            {
                valleys.add(arr[i]);
            }
            }
            else if(i<n)
            {
                if(arr[i] >= arr[i-1])
                {peaks.add(arr[i]);}
                
                if(arr[i] <= arr[i-1])
                {valleys.add(arr[i]);}
            }
        }
         int k=0;
         int j=1;
        for(int i =0;i<peaks.size();i++)
        {
            rearranged[k] = peaks.get(i);
            k =k+ 2;
        }
         for(int i =0;i<valleys.size();i++)
        {
            if(j<n-1){rearranged[j] = valleys.get(i);}
            else if(j == n){rearranged[j-1] = valleys.get(i);}
            j =j+2;
            
        }
        for (Integer rearranged1 : rearranged) {
            System.out.print(rearranged1);
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("===== set to zero  ====");
         System.out.println("** Big(o) notation : o(n2) **");
        int[][] matrix = {{1,2}, {3,4}, {0,5}};
        setZeros(matrix);
        
        /*****************************/
        
        System.out.println("===== countways to up the stair ====");
         System.out.println("** Big(o) notation : o(3n) what means o(n) **");
        System.out.println(findStep(4));
        
        /*****************************/
        
        System.out.println("===== permutation ====");
         System.out.println("** Big(o) notation : o(n) **");
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n-1);
        
        /*****************************/
        
        System.out.println("===== palindrome ====");
         System.out.println("** Big(o) notation : o(n) **");
        if (canFormPalindrome("Tactcoa"))
            System.out.println("Yes");
        else
            System.out.println("No");
        
        /*****************************/
        
        System.out.println("===== peaks and valleys ====");
        System.out.println("** Big(o) notation : o(n) **");
        Integer [] arr = {5, 8, 6, 2, 3, 4, 6};
       PeaksValleys(arr);
       Integer [] arr2 = {5, 3, 1, 2, 3};
       PeaksValleys(arr2);
        
    }
    
}
