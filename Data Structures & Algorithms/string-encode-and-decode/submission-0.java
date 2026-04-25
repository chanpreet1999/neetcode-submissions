class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append( str.length() ).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> ans = new ArrayList<>();
        
        while( i < str.length() ) {
            
            char ch = str.charAt(i);
            
            if(Character.isDigit(ch)) {
                int numEndIdx  = i;
                while( Character.isDigit( str.charAt(numEndIdx) ) ) 
                    numEndIdx++;
                int stringLength = Integer.parseInt( str.substring( i, numEndIdx ) );
                ans.add( str.substring(numEndIdx+1,  numEndIdx+1 + stringLength) );
                 
                i = numEndIdx+1 + stringLength;// sunce starting of word

            }
        }
        return ans;
    }
}
