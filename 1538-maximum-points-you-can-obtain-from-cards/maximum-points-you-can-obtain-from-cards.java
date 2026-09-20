class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
        }

        int targetSize = n - k;
        int currentWindowSum = 0;
        int minWindowSum = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right < n; right++){
            currentWindowSum += cardPoints[right];
            if(right - left + 1 == targetSize){
                minWindowSum = Math.min(minWindowSum, currentWindowSum);
                currentWindowSum -= cardPoints[left];
                left++;
            }
        }
        return (targetSize == 0) ?  totalSum : totalSum - minWindowSum;
    }
}