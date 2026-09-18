class MinStack {
    private Node head;

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        head = null;
    }
    
    public void push(int value) {
        if(head == null){
            head = new Node(value,value,null);
        } else{
            int currentMin = Math.min(value,head.min);
            head = new Node(value,currentMin,head);
        }
    }
    
    public void pop() {
        if(head != null){
            head = head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */