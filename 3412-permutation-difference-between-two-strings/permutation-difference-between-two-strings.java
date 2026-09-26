class Solution {
    public int findPermutationDifference(String s, String t) {
        int ans = 0;
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            mapS.put(ch,i);
        }
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            mapT.put(ch,i);
        }

        for(char key : mapS.keySet()){
            int i = mapS.get(key);
            int j = mapT.get(key);
            ans += Math.abs(i - j);
        }
        
        return ans;
    }
}