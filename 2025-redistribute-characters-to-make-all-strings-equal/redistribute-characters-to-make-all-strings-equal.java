class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        Map<Character, Integer> counts = new HashMap<>();
        
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            }
        }

        for(int count : counts.values()){
            if(count % n != 0) return false;
        }

        return true;
    }
}