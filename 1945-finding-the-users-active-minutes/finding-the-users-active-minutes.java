class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        Map<Integer, Set<Integer>> userMinutes = new HashMap<>();
        for(int[] log : logs){
           int user_id = log[0];
           int mins = log[1];
           
           userMinutes.putIfAbsent(user_id,new HashSet<>());
           userMinutes.get(user_id).add(mins);
        }

        for(Set<Integer> minutes : userMinutes.values()){
            int uam = minutes.size();
            if(uam <= k){
                result[uam - 1]++;
            }
        }
        return result;
    }
}