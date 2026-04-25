class Solution {
    class Node{
      int value;
      int freq;
      Node(int v, int f) {
        this.value = v;
        this.freq = f;
      }
    }

    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> hm = new HashMap<>();
      Queue<Node> pq = new PriorityQueue<>( (a,b) -> {
        return (a.freq - b.freq);
      });

    // store freq
      for( int num : nums ) {
        hm.put( num, hm.getOrDefault( num, 0 ) + 1  );
      }
    // creae a priority queue  
      for( Map.Entry<Integer, Integer> ele : hm.entrySet() ) {
          pq.add( new Node( ele.getKey(), ele.getValue() ) );
          if( pq.size() > k )
            pq.remove();
      }

// develop final ans
      int[] ans = new int[k];
      int i = 0;
      Iterator itr = pq.iterator();

      while(itr.hasNext()) {
        Node ele = (Node)itr.next();
        ans[i++] = ele.value;
      }

      return ans;
    }
}
