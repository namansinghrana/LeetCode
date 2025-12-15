/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void mapP(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> parentT){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){ parentT.put(curr.left, curr); q.offer(curr.left); }
            if(curr.right != null){ parentT.put(curr.right, curr); q.offer(curr.right); }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentT = new HashMap<>();
        mapP(root,target,parentT);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target); visited.put(target, true);
        int currLevel = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k) break;   currLevel++;

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){ q.offer(curr.left); visited.put(curr.left, true); }
                if(curr.right != null && visited.get(curr.right) == null){ q.offer(curr.right); visited.put(curr.right, true); }
                if(parentT.get(curr) != null && visited.get(parentT.get(curr)) == null){ q.offer(parentT.get(curr)); visited.put(parentT.get(curr), true); }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){ result.add(q.poll().val); }
        return result;
    }
}
