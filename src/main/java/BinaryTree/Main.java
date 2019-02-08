package BinaryTree;

public class Main {
    public static void main(String[] args) {

        Integer[] intArr = {4,10, 8, 7, 9, 12, 11, 13};
        BinaryTree tree = new BinaryTree();

        for (Integer element:intArr) {
                tree.insert(element);
        }

        tree.print();
        tree.delete(10);
        tree.print();


    }
}
