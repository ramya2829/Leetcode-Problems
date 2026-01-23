class Solution {
    public static String longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1){
            return s;
        }
        int first=0;
        int second=s.length()-1;
        int length=1;
        String ans="";
        while(first<=second){
            char ch1= s.charAt(first);
            char ch2 = s.charAt(second);
            if(s.substring(first).length()<=length){
                break;
            }
            if(ch2==ch1 && second-first+1>=length){
                String temp = ifPalen(s.substring(first,second+1));
                if(temp.length()>=length){
                    length = temp.length();
                    ans=temp;
                    first++;
                    second=s.length()-1;
                    continue;
                }
            }
            second--;
            if(second-first<0 && s.substring(first).length()>length){
                first++;
                second = s.length()-1;
            }
        }
        return ans;
    }
    private static String ifPalen(String s){
        int first=0;
        int last = s.length()-1;
        while(first<=last){
            if(s.charAt(first)!=s.charAt(last)){
                return "";
            }
            first++;
            last--;
        }
        return s;
    }
}