package Recursion.String;

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome( String str ,int left,int right) {
        if( left >= right ){
            return true;
        }
        if( str.charAt(left) != str.charAt(right)){
            return false;
        }
        return isPalindrome(str,left+1,right-1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();

        System.out.print(isPalindrome(str,0,str.length()-1));
    }
}
