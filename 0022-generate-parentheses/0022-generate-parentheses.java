import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> content = new ArrayList<>();
        backTrack(new StringBuilder(),content,0,0,n);
        return content;

    }
    public void backTrack(StringBuilder string,List<String> list, int open, int close, int n){

        if(string.length() == 2*n){
            list.add(string.toString());
            return;
        }
        if(open < n){
            string.append('(');
            backTrack(string,list,open+1,close,n);
            string.deleteCharAt(string.length()-1);
        }

        if(close<open){
             string.append(')');
             backTrack(string,list,open,close+1,n);
            string.deleteCharAt(string.length()-1);

        }

    }
}