package BinaryTree;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {

    public void insert(Integer element)
    {
        if(root!= null)
            insert(element, root);
        else
            root = new Node(element);
    }
    public boolean exist(Integer element)
    {
        return find(element, root,null).foundElement != null;
    }

    public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }

    public void print()
    {
        List<int[]> arr = new ArrayList<int[]>();

        System.out.println(root.data);
        System.out.println( "/\\");
        traverse(root, arr);

        for(int i = arr.size() - 1; i >0; --i)
        {

            String str  = "  ";
            System.out.println( repeat(str, i) + Arrays.toString(arr.get(i))) ;
        }
    }
    public void delete(Integer element)
    {
        throw new NotImplementedException();
    }

    private static class findResult
    {
        Node foundElement;
        Node parent;

        findResult(Node foundElement, Node parent)
        {
            this.foundElement = foundElement;
            this.parent = parent;
        }
    }

    private findResult find(Integer element, Node node, Node parent)
    {

        if (element == node.data)
            return new findResult(node, parent);

        if (element < node.data && node.leftLeaf != null)
            return find(element, node.leftLeaf, node);

        if (element > node.data && node.rightLeaf != null)
            return find(element, node.rightLeaf, node);

        return new findResult(null, node);
    }


    private Node findMax(Node node)
    {
        if( node.rightLeaf != null )
        {
            findMax(node.rightLeaf);
        }

        return node.rightLeaf;
    }

    private void traverse(Node node, List<int[]> arr)
    {
        int left = 0;
        int right = 0;
        if( node.rightLeaf != null )
        {
            traverse(node.rightLeaf, arr);
            right = node.rightLeaf.data;
        }

        if( node.leftLeaf != null )
        {
            traverse(node.leftLeaf, arr);
            left = node.leftLeaf.data;
        }
            arr.add(new int[] {left, right});
    }

    private void insert(Integer element, Node node)
    {
        if( element < node.data )
        {
            if(node.leftLeaf != null)
                insert(element, node.leftLeaf);
            else
                node.leftLeaf = new Node(element);
        }
        if( element > node.data )
        {
            if(node.rightLeaf != null)
                insert(element, node.rightLeaf);
            else
                node.rightLeaf = new Node(element);
        }
    }

    private Node root;
}
