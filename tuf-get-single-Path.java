public class Solution{
  private boolean getPath(TreeNode root, ArrayList<Integer> arr, int x){
    if(root == null) return false;

    //we add the current value to list.
    arr.add(root.val);
    if(root.val == x) return true;
    
    //We try to find the particular
    if(getPath(root.left, arr, x) || getPath(root.right, arr, x)){
      return true;
    }

    //if this path does not contain that current value return false for this one.
    arr.remove(arr.size()-1);
    return false;
  }
  
  public ArrayList<Integer> solve(TreeNode A, int B){
    ArrayList<Integer> arr = new ArrayList<>();
    if(A == null){ return arr; }
    getPath(A, arr, B);
    return arr;
  }
}
