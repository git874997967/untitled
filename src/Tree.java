import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

class Node{
    int data;
    Node left,right,nextright;
    Node(int d){
        data=d;
        left=right=nextright=null;
    }
}
class BinaryTree{
    Node root,root1,root2;
    // to tell the tree is balanced or not
    boolean isBalanced(Node n){
        /*define the hight of two trees*/
        int lh,rh;
        if(n==null) return true;
        lh=height(n.left);
        rh=height(n.right);
        if(Math.abs(lh-rh)<=1&&isBalanced(n.left)&&isBalanced(n.right)) return true;
        return  false;
    }
    // get the height of the binary tree
    int height(Node n){
        if (n==null) return 0;
        return  1+Math.max(height(n.right),height(n.left));
    }
    // tell the tree is binary search tree or not
    boolean isBST(Node n){
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean isBSTUtil(Node n,int min,int max){
        if(n==null) return true;
        else if(n.data<min||n.data>max) return  false;
        return (isBSTUtil(n.left,min,n.data)&&isBSTUtil(n.right,n.data,max));
    }

    // one is the other subtree or not
    boolean areIdential(Node r1,Node r2){
            if(r1==null&&r2==null) return true;
            if(r1==null||r2==null) return false;
            return (r1.data==r2.data&&areIdential(r1.left,r2.left)&&areIdential(r1.right,r2.right));
    }
    boolean isSubTree(Node r1,Node r2){
            if(r1==null) return false;
            if(r2==null) return true;
            if(areIdential(r1,r2)) return true;
            return isSubTree(r1.right,r2)||isSubTree(r1.left,r2);
    }
    boolean haspathSum(Node n,int sum){
        if(n==null) return sum==0;
        else{
            boolean ans=false;
            int subsum=sum-n.data;
            // this is tell the node is leaf
            if(subsum==0&&n.left==null&&n.right==null)
                return true;
            if(n.left!=null)
                ans=ans||haspathSum(n.left,subsum);
            if(n.right!=null)
                ans=ans||haspathSum(n.right,subsum);
            return  ans;
        }
    }
    void printPathRec(Node n, int[] path,int pathLen ){
        if(n==null) return;
        path[pathLen]=n.data;
        pathLen++;
        // when we get a leaf
        if(n.left==null&&n.right==null)
            print(path,pathLen);
        printPathRec(n.left,path,pathLen);
        printPathRec(n.right,path,pathLen);
    }
    void print(int[]path,int Len){
        for(int i=0;i<Len;i++){
            System.out.print(path[i]);
        }
        System.out.println("");
    }
    void connect (Node n){
        n.nextright=null;
        connectRecur(n);
    }
    void connectRecur(Node n){
        if(n==null) return;
        if(n.left!=null) n.left.nextright=n.right;
        if(n.right!=null)
            n.right.nextright=(n.nextright!=null)? n.nextright.left:null;
        connectRecur(n.left);
        connectRecur(n.right);
    }
}
public class Tree {
    public static void main(String[] args){
        BinaryTree bt=new BinaryTree();
        bt.root=new Node(2);
        bt.root.left=new Node(1);
        bt.root.right=new Node(3);
        bt.root.right.right=new Node(5);
        bt.root.right.right.left=new Node(4);
        System.out.println(bt.isBalanced(bt.root));
        System.out.println(bt.isBST(bt.root));
        /**/
        bt.root1=new Node(1);
        bt.root1.left=new Node(2);
        bt.root1.right=new Node(4);
        bt.root1.right.left=new Node(2);
        bt.root2=new Node(4);
        bt.root2.left=new Node(23);
        System.out.println(bt.isSubTree(bt.root1,bt.root2));
        System.out.println(bt.haspathSum(bt.root,4));
        bt.printPathRec(bt.root,new int[100],0);
    }
}
