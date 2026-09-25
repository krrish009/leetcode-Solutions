class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            int val = map.get(s.charAt(i));
            set.add(val);
        }
        if( set.size() != 1) return false;
        return true;
    }
}