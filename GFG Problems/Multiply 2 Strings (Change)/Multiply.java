//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String num1,String num2)
    {
        char sign = '+';
        if(num1.charAt(0) == '-' && num2.charAt(0) == '-'){
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            sign = '+';
        }else if(num1.charAt(0) == '-'){
            num1 = num1.substring(1);
            sign = '-';
        }else if(num2.charAt(0) == '-'){
            num2 = num2.substring(1);
            sign = '-';
        }else{
            // do nothing !
        }
        
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }  
        
        int l1 = num1.length();
        int l2 = num2.length();
        int res[] = new int[l1+l2];
    
        int i = l2-1;
        int pf = 0; // power factor.
        
        while(i >= 0){
            int ival = num2.charAt(i)-'0';
            i--;
            
            int j = l1-1;
            int k = res.length-1-pf;
            
            int carry = 0;
            while(j >= 0 || carry != 0){
                int jval = j>=0 ? num1.charAt(j)-'0' : 0;
                j--;
                int prod = ival*jval+carry+res[k];
                res[k] = prod%10;
                carry = prod/10;
                k--;
            }
            pf++;
        }
        
        // remove leading zeros.
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int val : res){
            if(val == 0 && flag == false){
                continue;
            }else{
                flag = true;
                sb.append(val);
            }
        }
        if(sign == '-'){
            sb.insert(0,'-');
        }
        return sb.toString();
    }
}
