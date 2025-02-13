package Array_String;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated w
 * ith itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * */
public class GreatestCommonDivisorOfStrings {
    // The greatest common divisor must be a prefix of each string, so we can try all prefixes.
    public static String gcdOfStrings(String str1, String str2) {

        // trying whether prefix ending at i, is a divisor of both str1 and str2
        int n=str1.length();
        for(int i=n;i>0;i--){
            String divisor=str1.substring(0,i);
            if(isDivisor(divisor,str1) && isDivisor(divisor,str2)){return divisor;}
        }

        return "";
    }
    public static boolean isDivisor(String s,String t){
        int n=s.length();
        int m=t.length();
        if(m%n!=0){return false;}

        int times=m/n;
        String newString= new String(s);

        for(int i=1;i<times;i++){
            newString=newString+s;
        }

        return newString.equals(t);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }

}
