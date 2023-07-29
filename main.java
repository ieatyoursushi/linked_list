https://www.studocu.com/en-us/course/diablo-valley-college/advanced-programming-with-c-and-c/3306632
import java.util.*
public class Main
{
    public static void main(String[] args)
    {
        //generic object instances
        Node nodeA = new Node<Integer>(new Integer(15));
        Node nodeB = new Node<String>("string");
        Node nodeC = new Node<Float>(new Float(12.5f));
        System.out.println(nodeA.getData());
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        System.out.println(nodeB.getData());
        System.out.println(nodeA.next.getData());
        System.out.println(nodeB.next.getData());
        System.out.println("---------");
        //LinkedList Class
        LinkedList list = new LinkedList();
        list.add(new String("Hello World"));
        list.add(new Integer(25));
        list.add(new String("bye world"));
        list.insert(new Integer(15), 0);
        list.insert(new Float(100.5f), 2);
        list.traverse();
        System.out.println(list.size() + "------");
        System.out.println("first element: " + list.get(0).getData() + " last element: " + list.get(list.size()-1).getData());
        //System.out.println("search index via element: " + list.serach(new String("Hello World"));
        /* Traditional AP Comp Sci way:
        nodeA.setNextNode(nodeB);
        System.out.println(nodeA.getNextNode().getData());
        in which there is a getter method for getting the "next" Node object instance, then accessing
        the data in said node with another get method specific for returning the data in the node only.
        */
        //moving on to the actual LinkedList implimentation which will be a collection of nodes

    }
}

public class LinkedList<T> {
    private Node initNode;
    public LinkedList() {
        
    }
    public void add(T data) {
        Node newNode = new Node<T>(data);
        //base case
        if(initNode == null) {
            initNode = newNode;
        } else {
            Node n = initNode;
            while(n.next != null) {
                //reminds of recursion
                n = n.next;
                //n = n.getNext();
            }
            //n.setNext(node)
            n.next = newNode;
        }
    }
    public Node get(int index) {
        Node n = initNode;
        for(int i = 0; i < index-1 ;i++) {
            if(n.next != null) {
                n = n.next;
            } else {
                return null;
            }
        }
        return n;
    }
    
    //im gonna assume my get method is compltely correct
    //yep, im guessing arraylists are only a java/c# thing
    public int search(T data) {
        for(int i = 0; i < this.size(); i++) {
            //since im using objects it is gonnabe a bit more complex to check for equal values
            if(get(i).getValue().equals(data)) {
                return i;
            }
        }
        return -1;
    }
    
    public void insertAtStart(T data) {
        Node node = new Node<T>(data);
        node.next = null;
        node.next = initNode;
        initNode = node;
    }
    
    public void insert(T data, int index) {
        Node newNode = new Node<T>(data);
        newNode.next = null;
        if(index == 0) {
            insertAtStart(data);
        } else {
            Node insertNode = get(index);
            newNode.next = insertNode.next;
            insertNode.next = newNode;
        }
        /*
        Node newNode = new Node<T>(data);
        if(initNode == null) {
            initNode = newNode;
        } else {
            Node n = initNode;
            for(int i = 0; i < index; i++) {
                if(n.next != null) {
                    n = n.next;
                } else {
                    break;
                }
                
            }
            n.next = newNode;
        }
        */
        
    }
    //basically its very similar to how I traversed through the entire linked list but with an index involved
    //where the loop is predetermined to stop, i also took inspiration from the arraylist class.
    
    public void traverse() {
        Node node = initNode;
        while(node.next != null) {
            System.out.println(node.getData());
            node = node.next;
        }
        //getting the last element that has its next node as "null"
        System.out.println(node.getData());
    }
    public int size() {
        int length = 1;
        Node node = initNode;
        while(node.next != null) {
            length++;
            node = node.next;
        }
        return length+1;
    }   
}
public class Node<T> {
    //rules of var: once the data type is assigned, the data type must be the same.
    //rules of Object: cannot accept primitive types
    private T data;
    Node next;
    public Node (T data) {
        this.data = data;
    }
    public T getData() {
        return this.data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
