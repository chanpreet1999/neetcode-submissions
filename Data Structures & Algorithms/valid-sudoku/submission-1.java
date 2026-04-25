class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character> > rowSetMap = new HashMap<>();
        Map<Integer, Set<Character> > colSetMap = new HashMap<>();
        Map<Integer, Set<Character> > blockSetMap = new HashMap<>();
        
        // row iteration
        for(int i = 0;  i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

                //create set if not exist
                rowSetMap.putIfAbsent(i, new HashSet<>());

                Integer currentBlockAddress = (i/3)*3 + (j/3);
                blockSetMap.putIfAbsent(currentBlockAddress, new HashSet<>());

                if( board[i][j] != '.' ) {
                    if(rowSetMap.get(i).contains( board[i][j] ))
                        return false;
                    else
                        rowSetMap.get(i).add( board[i][j] );
                    
                    if(blockSetMap.get(currentBlockAddress).contains( board[i][j] ))
                        return false;
                    else
                        blockSetMap.get(currentBlockAddress).add(board[i][j]);
                }
                       
            }
        }
        

        //column wise iteration
        for(int j = 0;  j < board[0].length; j++) {
            for(int i = 0; i < board.length; i++) {
                //create set if not exist
                colSetMap.putIfAbsent(j, new HashSet<>());

                if( board[i][j] != '.' )
                {
                    if(colSetMap.get(j).contains(board[i][j]))
                        return false;
                    else
                        colSetMap.get(j).add( board[i][j] );
                }
                                    
            }
        }        
        return true;


    }
}
