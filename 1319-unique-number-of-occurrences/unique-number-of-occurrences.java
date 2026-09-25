class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }

        HashSet<Integer> frequencies = new HashSet<>();
        for (int count : map.values()) {
            if(frequencies.contains(count)){
                return false;
            }
            frequencies.add(count);
        }
        return true;
    }
}