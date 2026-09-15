package Recursion.String;

import java.util.Scanner;

public class RemoveChar {
    public static String removeChar(String str,int index,char ch){
        if( index == str.length()){
            return "";
        }
        if(str.charAt(index) == ch){
            return removeChar(str,index+1,ch);
        }
        return str.charAt(index)+removeChar(str,index+1,ch);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);
        System.out.print(removeChar(str,0,ch));
    }
}
