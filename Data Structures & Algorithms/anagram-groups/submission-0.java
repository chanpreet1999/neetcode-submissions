class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> hm = new HashMap<>();
      for(String str: strs) {
            char charArr[] = str.toCharArray();
            Arrays.sort( charArr );
            String sortedStr = new String( charArr );
            hm.putIfAbsent(sortedStr, new ArrayList<String>());
            hm.get( sortedStr ).add( str );
      }
      return new ArrayList<>( hm.values() );  
    }
}
