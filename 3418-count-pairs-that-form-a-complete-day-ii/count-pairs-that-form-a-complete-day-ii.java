class Solution {
    public long countCompleteDayPairs(int[] hours) {
         long totalPairs = 0;

        Map<Integer, Long> remainderFrequencies = new HashMap<>();
        for(int hour : hours){
            int CurrentRemainder = hour % 24;
            int targetRemainder = (24 -  CurrentRemainder) % 24;
            totalPairs += remainderFrequencies.getOrDefault(targetRemainder, 0L);
            remainderFrequencies.put(CurrentRemainder,remainderFrequencies.getOrDefault(CurrentRemainder, 0L) + 1);
        }
        return totalPairs;
    }
}