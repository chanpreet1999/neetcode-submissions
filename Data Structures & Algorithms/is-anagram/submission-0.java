class Solution {
    public boolean isAnagram(String s, String t) {
        int countArr[] = new int[26];

        for( char ch : s.toCharArray() ) {
            countArr[ch-'a']++;
        }
        for(char ch : t.toCharArray()) {
            countArr[ch-'a']--;
        }

        for(int ele: countArr) {
            if(ele != 0) {
                return false;
            }
        }

        return true;
    }
}
