package Recursion.String;

import java.util.Scanner;

public class RemoveDuplicates {
    public static String remove( String str ,int index,String result){
        if( index == str.length()){
            return result;
        }
        char ch = str.charAt(index);
        if( result.indexOf(ch) != -1 ){
            return remove(str,index+1,result);
        }
        return  remove(str,index+1,result + ch) ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();

        System.out.println(remove(str,0,""));
    }
}
