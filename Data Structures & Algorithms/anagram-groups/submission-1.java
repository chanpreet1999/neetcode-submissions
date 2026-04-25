class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for( String str : strs ) {
          
            String key = createKey( str );
            hm.putIfAbsent( key, new ArrayList<>() );
            hm.get(key).add( str );
        }

        return new ArrayList<>(hm.values());
    }

    private String createKey( String str ) {
        int freq[] = new int[26];
        for( char ch : str.toCharArray() ){
            freq[ ch - 'a' ] ++;
        }
        StringBuilder sb = new StringBuilder();

        for( int i = 0 ; i < freq.length; i++  ) {
            if( freq[i] != 0 ) {
              sb.append( (char)(i + 'a') ).append( freq[i] );
            }
        }

        return sb.toString();
    }
}
