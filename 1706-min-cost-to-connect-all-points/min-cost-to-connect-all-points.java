class Solution {
    class triplet{
        int u;
        int v;
        int dist;
        triplet(int u,int v,int d){
            this.u=u;
            this.v=v;
            this.dist=d;
        }
    }
    static int[] parent;
    static int[] size;
    public int findLeader(int i){
        if(parent[i]==i) return i;
        return parent[i]=findLeader(parent[i]);
    }
    public void union(int i,int j){
        int LeaderA=findLeader(i);
        int LeaderB=findLeader(j);
        if(LeaderA!=LeaderB){
            if(size[LeaderA]>size[LeaderB]){
                parent[LeaderB]=LeaderA;
                size[LeaderB]+=size[LeaderA];
            } else{
                parent[LeaderB]=LeaderA;
                size[LeaderB]+=size[LeaderA];
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
       int n=points.length;
       parent=new int[n];
       size=new int[n];
       for(int i=0;i<n;i++){
        parent[i]=i;
        size[i]=1;
       }

       PriorityQueue<triplet> pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
       for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int x1=points[i][0],y1=points[i][1];
                int x2=points[j][0],y2=points[j][1];
                int ManDist=Math.abs(x2-x1) + Math.abs(y2-y1);
                pq.add(new triplet(i,j,ManDist));
            }
       }
        int cost=0;
       while(!pq.isEmpty()){
            triplet front=pq.poll();
            int u=front.u,v=front.v,dist=front.dist;
            if(findLeader(u)!=findLeader(v)){
                cost+=dist;
                union(u,v);
            }
       }
       return cost;
    }
}