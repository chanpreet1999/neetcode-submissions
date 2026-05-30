class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        
        for(int i = temperatures.length-1; i >= 0 ; i--) {
            int cur = temperatures[i];

            while( !st.isEmpty() && temperatures[st.peek()] <= cur)
                st.pop();
            
            ans[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);                
        }
        return ans;
    }
}
