class Solution {
    public int minimumCardPickup(int[] cards) {
        int minCards = Integer.MAX_VALUE;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < cards.length; i++){

            if(map.containsKey(cards[i])){
                int PrevIdx = map.get(cards[i]);
                int CurrentWindow = i - PrevIdx + 1;
                minCards = Math.min(minCards,CurrentWindow);
            }
            map.put(cards[i],i);
        }
        return minCards == Integer.MAX_VALUE ? -1 : minCards;
    }
}