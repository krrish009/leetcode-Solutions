class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int n = secret.length();
        int cows = 0;
        int[] digitInventory = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int secretDigit = secret.charAt(i) - '0';
            int guessDigit = guess.charAt(i) - '0';
            
            if (secretDigit == guessDigit) {
                bull++;
            } else {

                if (digitInventory[secretDigit] < 0) {
                    cows++;
                }

                if (digitInventory[guessDigit] > 0) {
                    cows++;
                }
 
                digitInventory[secretDigit]++;
                digitInventory[guessDigit]--;
            }
        }

        return bull + "A" + cows + "B";
    }
}