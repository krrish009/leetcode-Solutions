class Solution {
    public boolean hasAllCodes(String s, int k) {
        int comb = 1 << k;

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i <= s.length() - k; i++){
            String sub = s.substring(i, i + k);
            set.add(sub);
            if(set.size() == comb){
                return true;
            }
        }
        return false;
    }
}