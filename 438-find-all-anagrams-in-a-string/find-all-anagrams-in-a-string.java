class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int k = p.length();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++){
            char rightChar = s.charAt(i);
            sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);

            if(i >= k){
                char leftChar = s.charAt(i - k);
                if(sMap.get(leftChar) == 1){
                    sMap.remove(leftChar);
                }else{
                    sMap.put(leftChar, sMap.getOrDefault(leftChar, 0) - 1);
                }
            }
            if(i >= k - 1){
                if(pMap.equals(sMap)){
                    result.add(i - k + 1);
                }
            }
        }
        return result;
    }
}