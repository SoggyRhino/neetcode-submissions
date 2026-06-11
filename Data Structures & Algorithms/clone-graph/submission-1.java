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
        if (node == null) return null;
        return rec(node, new HashMap<Node, Node>());
    }

    public Node rec(Node node, Map<Node, Node> map){
        if (node == null) return null;

        Node clone = new Node(node.val);
        map.put(node, clone);
        for (var n : node.neighbors){
            if (!map.containsKey(n)){
                clone.neighbors.add(rec(n, map));
            } else {
                clone.neighbors.add(map.get(n));
            }
        }

        return clone; 
    }
}