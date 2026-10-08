import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualFreq(int[] nums) {
        // Tracks how many times each specific number has appeared
        Map<Integer, Integer> elementToOccurrenceCount = new HashMap<>();
        
        // Tracks how many distinct numbers share a given occurrence count
        Map<Integer, Integer> occurrenceCountToFrequency = new HashMap<>();
        
        int highestOccurrenceSeen = 0;
        int longestValidPrefixLength = 0;
        
        for (int index = 0; index < nums.length; index++) {
            int currentNum = nums[index];
            int currentPrefixLength = index + 1;
            
            // 1. Update counts for the current number
            int previousOccurrenceCount = elementToOccurrenceCount.getOrDefault(currentNum, 0);
            if (previousOccurrenceCount > 0) {
                occurrenceCountToFrequency.put(
                    previousOccurrenceCount, 
                    occurrenceCountToFrequency.get(previousOccurrenceCount) - 1
                );
            }
            
            int currentOccurrenceCount = previousOccurrenceCount + 1;
            elementToOccurrenceCount.put(currentNum, currentOccurrenceCount);
            occurrenceCountToFrequency.put(
                currentOccurrenceCount, 
                occurrenceCountToFrequency.getOrDefault(currentOccurrenceCount, 0) + 1
            );
            
            // 2. Track the global peak occurrence count
            highestOccurrenceSeen = Math.max(highestOccurrenceSeen, currentOccurrenceCount);
            
            // 3. Extract frequency indicators for safety checks
            int elementsWithHighestOccurrence = occurrenceCountToFrequency.getOrDefault(highestOccurrenceSeen, 0);
            int elementsWithStepDownOccurrence = occurrenceCountToFrequency.getOrDefault(highestOccurrenceSeen - 1, 0);
            
            // 4. Validate prefix state against the 3 permissible configurations
            
            // Configuration 1: Every element seen so far has occurred exactly 1 time
            if (highestOccurrenceSeen == 1) {
                longestValidPrefixLength = currentPrefixLength;
            }
            // Configuration 2: Exactly 1 single element occurred 1 time; all others occurred 'highestOccurrenceSeen' times
            else if (elementsWithHighestOccurrence * highestOccurrenceSeen == currentPrefixLength - 1) {
                longestValidPrefixLength = currentPrefixLength;
            }
            // Configuration 3: Exactly 1 element reached the peak count; all others lag behind by exactly 1 count
            else if (elementsWithHighestOccurrence == 1 && 
                     elementsWithStepDownOccurrence * (highestOccurrenceSeen - 1) == currentPrefixLength - highestOccurrenceSeen) {
                longestValidPrefixLength = currentPrefixLength;
            }
        }
        
        return longestValidPrefixLength;
    }
}
