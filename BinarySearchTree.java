import java.util.*;

//    Name: Get Height and Level Order Traversal of Binary Search Tree

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinarySearchTree{

    public static int getHeight(Node root){
        //Write your code here
        Node temp =root;
        int h1 =0;
        int h2 =0;
        if(temp.left==null && temp.right==null){
            return 0;
        }
        else{
            if (temp.left!= null) {
                h1= 1+ getHeight(temp.left);
            }
            if(temp.right!= null) {
                h2 =1+ getHeight(temp.right);
            }
            int height = Math.max(h1, h2);
            return height;
        }
    }

    static void levelOrder(Node root){
        //Write your code here
        Node temp = root;
        Queue<Node > queue = new LinkedList<Node>();
        if(temp!=null){
            queue.add(temp);
            while(!queue.isEmpty()){
                Node curr = queue.peek();
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }

                System.out.print(curr.data+" ");
                queue.remove();
            }
        }


    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;

            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println("Height of tree is: "+height);
        System.out.print("Level Order Traversal is: ");
        levelOrder(root);
    }
}