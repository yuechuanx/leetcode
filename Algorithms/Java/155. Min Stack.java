class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> min;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.data = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (this.min.isEmpty()) {
            this.min.push(x);
        } else if (x <= this.getMin()) {
            this.min.push(x);
        } 
        this.data.push(x);
    }
    
    public void pop() {
        if (this.data.isEmpty()) {
            throw new RuntimeException("a");
        }
        int val = data.pop();
        if (val == this.getMin()) {
            this.min.pop();
        }
    }
    
    public int top() {
        return this.data.peek();
    }
    
    public int getMin() {
        if (this.min.isEmpty()) {
            throw new RuntimeException("b");
        }
        return this.min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */