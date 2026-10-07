class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String SortedKey = new String(chars);
            map.putIfAbsent(SortedKey,new ArrayList<>());
            map.get(SortedKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}