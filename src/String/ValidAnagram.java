package String;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {


        //------------Using frequency--------
        if( s.length() != t.length() ){
            return false;
        }

        int count[] = new int[26];

        for( int i = 0; i < s.length() ; i++ ){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for( int c : count ){
            if( c != 0 ){
                return false;
            }
        }
        return true;


        /* ----------Using Sorting ---------
        String s1=s.replaceAll("//s","").toLowerCase();
        String s2=t.replaceAll("//s","").toLowerCase();

        if(s1.length() != s2.length()) return false;

        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);*/



    }
}
