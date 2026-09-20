class Solution {
    public int countGoodSubstrings(String s) {
        int k = 3;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int count = 0;

        for(int end = 0; end < s.length(); end++){
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));

            if(end - start + 1 == k){
                if(set.size() == k){
                    count++;
                }
                set.remove(s.charAt(start));
                start++;
            }
        }
        return count;
    }
}