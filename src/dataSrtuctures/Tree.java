package dataSrtuctures;

import java.util.ArrayList;
import java.util.List;

public class Tree {


    public static class Node{
        private Node parent;
        private List<Node> childsList = new ArrayList<>();
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public List<Node> getChildsList() {
            return childsList;
        }

        public int getValue() {
            return value;
        }

        public void addNewNode(Node child){
            this.childsList.add(child);
            child.parent = this;
        }

        public void postOrder(){
            if(this.childsList.size() > 0){
                for (Node cur : this.childsList){
                    cur.postOrder();
                }
                System.out.print(this.value + " ");
            }
            else{
                System.out.print(this.value + " ");
            }

        }
    }


    public static void main(String[] args) {
        Node root =  new Node(10);
        Node child1 =  new Node(190);
        Node child2 =  new Node(180);
        Node child3 =  new Node(14);
        Node child4 =  new Node(18);

        root.addNewNode(child1);
        root.addNewNode(child2);
        child1.addNewNode(child3);
        child1.addNewNode(child4);

        root.postOrder();

    }
}
