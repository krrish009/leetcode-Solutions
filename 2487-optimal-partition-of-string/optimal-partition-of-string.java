class Solution {
    public int partitionString(String s) {
        int partitions = 1;
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                partitions++;
                set.clear();
            }
            set.add(ch);
        }
        return partitions;
    }
}