class DSU{
    int[] rank;
    int[] size;
    int[] parent;

    public DSU(int n){
        rank = new int[n+1];
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUParent(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = findUParent(parent[u]);
    }

    public void unionByRank(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v){   //same component so just return
            return;
        }
        if(rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else if(rank[ulp_v] < rank[ulp_u]){
            parent[ulp_u] = ulp_v;
        }else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    public void unionBySize(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v){   //same component so just return
            return;
        }

        if(size[ulp_u] > size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }

}
public class disJointSetUnion {
    public static void main(String[] args) {
        DSU ds = new DSU(7);

        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if(ds.findUParent(3) == ds.findUParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

        ds.unionByRank(3,7);

        if(ds.findUParent(3) == ds.findUParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

        /// --------------------------------------------------------------------------------------------------- ///
        DSU ubs = new DSU(7);

        ubs.unionBySize(1,2);
        ubs.unionBySize(2,3);
        ubs.unionBySize(4,5);
        ubs.unionBySize(6,7);
        ubs.unionBySize(5,6);

        if(ubs.findUParent(3) == ubs.findUParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

        ubs.unionBySize(3,7);

        if(ubs.findUParent(3) == ubs.findUParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }
    }
}
