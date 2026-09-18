class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int previousBeams = 0;

        for(String row : bank){
            int currCount = 0;
            for(int i = 0; i < row.length(); i++){
                if(row.charAt(i) == '1') currCount++;
            } 
            if(currCount > 0){
                totalBeams += currCount * previousBeams;
                previousBeams = currCount;
            }
        }
        return totalBeams;
    }
}