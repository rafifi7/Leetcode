class MinStack {
    ArrayList<Integer> stack;
    int top = 0; 
    public MinStack() {
        ArrayList<Integer> stack = new ArrayList<>(); // creates new stack
        this.stack = stack;
    }
    
    public void push(int val) {
        stack.add(val);
        top++;
    }
    
    public void pop() {
        stack.remove(top - 1);
        top--;
    }
    
    public int top() {
        return stack.get(top - 1);
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stack.size(); i++)
            if (stack.get(i) < min)
                min = stack.get(i);
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
