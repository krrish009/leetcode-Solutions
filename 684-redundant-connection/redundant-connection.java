class Solution {
    static int[] parent;
    static int[] size;

    public int find(int i){
        if(parent[i]==i) return i;
        return parent[i]=find(parent[i]);
    }
    public void union(int i,int j){
        int LeaderA=find(i);
        int LeaderB=find(j);
        if(LeaderA!=LeaderB){
            if(size[LeaderA]<size[LeaderB]){
                parent[LeaderA]=LeaderB;
                size[LeaderB]+=size[LeaderA];
            } else{
                parent[LeaderB]=LeaderA;
                size[LeaderA]+=size[LeaderB];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;

        parent=new int[n+1];
        size=new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
        int[] ans=new int[2];
        for(int[] e: edges){
            int u=e[0],v=e[1];
            if(find(u)==find(v)){
                ans[0]=u;
                ans[1]=v;
                break;
            } else{
                union(u,v);
            }
        }
        return ans;
    }
}