import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int lineLength = words[i].length();
            int j = i + 1;

            // Step 1: find words for the current line
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length(); // 1 space between words
                j++;
            }

            int spacesNeeded = maxWidth - (lineLength - (j - i - 1)); // spaces to fill
            int numberOfWords = j - i;

            StringBuilder sb = new StringBuilder();

            // Step 2: last line or single word → left-justify
            if (j == n || numberOfWords == 1) {
                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ").append(words[k]);
                }
                int remaining = maxWidth - sb.length();
                for (int k = 0; k < remaining; k++) sb.append(" ");
            } 
            // Step 3: fully justify
            else {
                int space = spacesNeeded / (numberOfWords - 1);
                int extra = spacesNeeded % (numberOfWords - 1);

                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    for (int s = 0; s < space; s++) sb.append(" ");
                    if (extra > 0) {
                        sb.append(" ");
                        extra--;
                    }
                }
                sb.append(words[j - 1]); // last word
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}