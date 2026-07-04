/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Node, Node> oldToNewMap = new HashMap<>();
        Queue<Node> q  = new LinkedList<>();

        q.add( node );
        Node newNode = new Node( node.val );
        oldToNewMap.put( node, newNode );

        while( !q.isEmpty() ) {
            Node cur = q.remove();
            Node copy = oldToNewMap.get(cur);  
                
            for( Node neighbor: cur.neighbors ) {
                
                if( !oldToNewMap.containsKey( neighbor ) ) {
                    q.add( neighbor );
                    oldToNewMap.put(neighbor, new Node(neighbor.val));
                }
                copy.neighbors.add(oldToNewMap.get(neighbor));
            }
        }
        return newNode;
    }
}