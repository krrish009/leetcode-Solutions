class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int m = queries.length;
        int n = queries[0].length;
        int[] ans = new int[m];
        int[] prefix = new int[words.length + 1];

        for (int i = 0; i < words.length; i++) {
                String word = words[i];
                // Check if the current word starts and ends with a vowel
                if((word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u' || word.charAt(0) == 'a') &&
                (word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'u' || word.charAt(word.length() - 1) == 'a')){
                    prefix[i + 1] = prefix[i] + 1;
                } else {
                    prefix[i + 1] = prefix[i];
                }
        }

        for(int i = 0; i < m; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = prefix[right + 1] - prefix[left];
        }
        return ans;
    }
}