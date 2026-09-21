class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        // 1. Build the target map for s1
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        int windowSize = s1.length();

        for(int right = 0 ;right < s2.length(); right++){
            char rightchar = s2.charAt(right);
            s2Map.put(rightchar, s2Map.getOrDefault(rightchar, 0) + 1);
            if(right >= windowSize){
                char leftchar = s2.charAt(right - windowSize);
                if(s2Map.get(leftchar) == 1){
                    s2Map.remove(leftchar);
                }else {
                    s2Map.put(leftchar, s2Map.getOrDefault(leftchar, 0) - 1);
                }
            }
            if (right >= windowSize - 1) {
                if (s1Map.equals(s2Map)) {
                    return true;
                }
            }
        }

        return false;
    }
}