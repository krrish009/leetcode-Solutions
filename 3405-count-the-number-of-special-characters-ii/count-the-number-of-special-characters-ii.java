class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> lowerMap = new HashMap<>();
        HashMap<Character, Integer> upperMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerMap.put(ch, i); 
            } else {
                if (!upperMap.containsKey(ch)) {
                    upperMap.put(ch, i); 
                }
            }
        }

        int special = 0;
        for(char ch : lowerMap.keySet()){
            char Upperch = Character.toUpperCase(ch);
            if(upperMap.containsKey(Upperch) && lowerMap.get(ch) < upperMap.get(Upperch)){
                special++;
            }
        }
        return special;
    }
}