package Recursion.String;

import java.util.Scanner;

public class CountChar {
    public static int countchar(String str, char c, int count,int i) {
           if( i == str.length()){
               return count;
           }
           char ch = str.charAt(i);
           if( ch == c ){
               count++;
           }
           return countchar(str,c,count,i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);

        System.out.println(countchar(str,ch,0,0));
    }
}
