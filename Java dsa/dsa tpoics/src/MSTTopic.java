import java.util.*;
class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        //in case of 1-based indexing we can go till n:
        for(int i=0; i<=n; i++){
            //because the parent is initially the node itself and rank for everyone is zero:
            size.add(1);
            parent.add(i);
            rank.add(0);
        }
    }
    public int findUParent(int node){
        //Base case:
        if(node == parent.get(node)){
            return node;
        }

        int uParent = findUParent(parent.get(node));
        parent.set(node,uParent);
        return parent.get(node);
    }
    //Note: the above function does the path compression and reduces the TC inorder to find the parent for multiple times...

    public void unionByRank(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v) return;    //because it belongs to the same component

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }

    public void unionBySize(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v) return;    //because it belongs to the same component

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
public class MSTTopic {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

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
        DisjointSet ubs = new DisjointSet(7);

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

