class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();    
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
        }else{
            stack.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        long pop = stack.pop();
        if(pop < 0) min = min - pop;
    }
    
    public int top() {
        long top = stack.peek();
        if(top > 0){
            return (int)(top+min);
        }else{
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
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