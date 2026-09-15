package Recursion.String;

import java.util.Scanner;

public class Subsequence {
    public static void subSequence(String str,int index,String res){
        if( index == str.length()){
            System.out.println(res);
            return;
        }
        char ch = str.charAt(index);
        subSequence(str, index + 1, res + ch);
        subSequence(str, index + 1, res);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();

      subSequence(str,0,"");
    }
}
