/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.Random;

class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    public int getRandom() {
        ListNode curr = this.head;
        int result = curr.val;
        int count = 1;
        
        // Traverse the entire list lineally
        while (curr != null) {
            // Generate a random integer from 0 to count-1
            // The probability of getting 0 is exactly 1/count
            if (rand.nextInt(count) == 0) {
                result = curr.val;
            }
            
            count++;
            curr = curr.next;
        }
        
        return result;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */