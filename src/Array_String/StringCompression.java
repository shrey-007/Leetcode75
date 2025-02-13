package Array_String;

public class StringCompression {
    public int compress(char[] chars){
        int start = 0;
        int count = 1;
        int end = 1;
        int n = chars.length;
        int index=0;

        while(end<n){
            char startChar = chars[start];
            char endChar = chars[end];

            if(startChar==endChar){count++;end++;}
            else{
                chars[index]=startChar;
                index++;
                if(count>1){
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index] = c;          // jojnoj
                        index++;
                    }
                    start = end;
                    end++;
                    count=1;
                }
                else if(count==1){
                    start = end;
                    end++;
                }
            }
        }

        chars[index]=chars[start];
        if(count>1){
            String countStr = String.valueOf(count);
            for (char c : countStr.toCharArray()) {
                chars[++index] = c;
            }

        }

        return Math.min(index+1,n);
    }
}
