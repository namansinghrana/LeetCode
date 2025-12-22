//flood fill using parent, left and right in bt.
class Solution {

    Node target;
    private void mapUp(Node root,Node parent, int start, Map<Node, Node> parentMap){
        if(root == null) return;
        if(root.data == start){ target = root; }
        if(parent != null){ parentMap.put(root, parent); }

        mapUp(root.left, root, start, parentMap);
        mapUp(root.right, root, start, parentMap);
    }


    public int minTime(Node root, int start) {
        //your code goes here
        Map<Node, Node> parentMap = new HashMap<>();
        mapUp(root, null, start, parentMap);

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);
        int time=0;

        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;
            
            for(int i=0;i<size;i++){
                Node curr = q.poll();

                if(curr.left != null && !visited.contains(curr.left)){ q.offer(curr.left); visited.add(curr.left); burned = true; }
                if(curr.right != null && !visited.contains(curr.right)){ q.offer(curr.right); visited.add(curr.right); burned = true; }
                Node parent = parentMap.get(curr);
                if(parent != null && !visited.contains(parent)){ q.offer(parent); visited.add(parent); burned = true; }
            }
            if(burned) time++;
        }
        return time;
    }
}
