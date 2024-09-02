class Solution {
    class DSU {
        int[] arr=new int[100];
        DSU() {for(int i=0;i<100;arr[i]=i++);}
        int findParent(int a) {return (arr[a]==a)? a: (arr[a]=findParent(arr[a]));}
        void union(int a, int b) {arr[findParent(b)]=findParent(a);}
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        HashMap<int[], Integer> map=new HashMap<>();
        for(int i=0;i<edges.length;i++) map.put(edges[i],i);
        Arrays.sort(edges, (a,b)->a[2]-b[2]);
        int min_c=f(n, edges, null, null), c;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<Integer>()); res.add(new ArrayList<Integer>());
        for(int[] e: edges) {
            if(f(n, edges, e, null) >min_c) res.get(0).add(map.get(e));
            else if(f(n, edges, null, e)==min_c) res.get(1).add(map.get(e));
        }
        return (List)res;
    }
    int f(int n, int[][] edges, int[] skip, int[] take) {
        DSU dsu = new DSU(); int c=0;
        if(take!=null) {
            dsu.union(take[0], take[1]);
            c+=take[2];
            n--;
        }
        for(int[] e: edges) {
            if(e!=skip && dsu.findParent(e[0])!=dsu.findParent(e[1])) {
                dsu.union(e[0], e[1]);
                c+=e[2];
                n--;
            }
        }
        return n==1? c:Integer.MAX_VALUE;
    }
}