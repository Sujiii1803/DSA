package Recursion.String;

import java.util.Scanner;

public class ReverseString {
    public static String reverse( String str ,int i){
           if( i == str.length()){
                return "";
           }
           return  reverse(str,i+1) + str.charAt(i) ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();

        System.out.println("Reversed String " +reverse(str,0));
    }
}
