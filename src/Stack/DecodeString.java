package Stack;

import java.util.Stack;

public class DecodeString {
    // Not sloved yet
    public static String decodeString(String s) {

        Stack<String> stack=new Stack<>();
        int n=s.length();
        String ans=new String("");
        for(int i=n-1;i>=0;i--){
            char curr=s.charAt(i);
            if(curr==']' || curr=='['){stack.push(String.valueOf(curr));}
            else if(Character.isDigit(curr)){
                int k=i;
                while (k>0 && Character.isDigit(s.charAt(k-1))){
                    k--;
                }
                int repeatetionCount=Integer.valueOf(s.substring(k,i+1));
                // pop the [
                stack.pop();
                String temp="";
                // get the string
                while(!stack.peek().equals("]")){
                    temp=temp+stack.pop();
                }
                // pop the ]
                stack.pop();
                String repeatedString="";
                // add the string repeatetionCount times
                for(int j=1;j<=repeatetionCount;j++){
                    repeatedString=repeatedString+temp;
                }
                // push the string
                stack.push(repeatedString);
                i=k;
            }
            else{stack.push(String.valueOf(curr));}
        }

        while (!stack.isEmpty()){
            ans=ans+stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        // ek saath 3 digits aagyi
        System.out.println(decodeString("100[leetcode]"));
    }
}
