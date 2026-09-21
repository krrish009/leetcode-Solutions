class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int maxFreq = 0;
        int maxlen = 0;
        int left = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            char rightChar = answerKey.charAt(right);
            map.put(rightChar,map.getOrDefault(rightChar,0) + 1);
            maxFreq = Math.max(maxFreq,map.get(rightChar));
            int window = right - left + 1;
            if(window - maxFreq > k){
                char leftChar = answerKey.charAt(left);
                map.put(leftChar,map.getOrDefault(leftChar,0) - 1);
                left++;
            }
            maxlen = Math.max(maxlen,right - left + 1);
        }
        return maxlen;
    }
}