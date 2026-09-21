class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOps = Integer.MAX_VALUE;
        int white = 0;

        for(int right = 0; right < blocks.length(); right++){
            if(blocks.charAt(right) == 'W') white++;

            if(right >= k - 1){
                minOps = Math.min(minOps,white);

                char leftChar = blocks.charAt(right - k + 1);
                if(leftChar == 'W') white--;
            }
        }
        return minOps;
    }
}