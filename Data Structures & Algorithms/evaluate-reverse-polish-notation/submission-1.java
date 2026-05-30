class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for( String curToken : tokens ){
            
            if( checkDigit( curToken ) ) {
                st.push(curToken);
            }
            else {
                String lToken = st.pop();
                String rToken = st.pop();
                
                Integer result = calculate( lToken, rToken, curToken );
                st.push(String.valueOf(result) );
            }
        }
        return Integer.parseInt( st.peek() );
    }

    Integer calculate( String lToken, String rToken, String op ) {
        int lVal = Integer.parseInt(lToken);
        int rVal = Integer.parseInt(rToken);
        
        switch( op ) {    
            case "+": return lVal + rVal;
            case "-": return rVal - lVal;
            case "*": return lVal * rVal;
            case "/": return rVal / lVal;
        }
        return null;
    }

    boolean checkDigit( String val ) {
        try{
            Integer.parseInt(val);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
