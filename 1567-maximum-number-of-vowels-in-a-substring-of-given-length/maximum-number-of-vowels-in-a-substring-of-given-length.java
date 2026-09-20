class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;
        int max = 0;
        int count = 0;

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            if(isVowel(ch)) count++;
            if(right - left + 1 == k){
                max = Math.max(max,count);
                if(isVowel(s.charAt(left))){
                    count--;
                }
                left++;
            }
        }
        return max;
    }
    private boolean isVowel(char c) {
        // Array where index represents (character - 'a')
        // 'a', 'e', 'i', 'o', 'u' are set to true
        boolean[] vowels = new boolean[26];
        vowels['a' - 'a'] = true;
        vowels['e' - 'a'] = true;
        vowels['i' - 'a'] = true;
        vowels['o' - 'a'] = true;
        vowels['u' - 'a'] = true;
        
        return vowels[c - 'a'];
    }

}