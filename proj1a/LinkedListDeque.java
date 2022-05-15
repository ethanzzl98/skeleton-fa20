public class LinkedListDeque<MyType> {
    
    private class ListNode {
        public ListNode prev;
        public MyType value;
        public ListNode next;

        public ListNode(MyType item, ListNode p, ListNode n) {
            value = item;
            prev = p;
            next = n;
        }
    }

    private ListNode sentinel;
    private int size; 

    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(MyType value) {
        sentinel = new ListNode(null, null, null);
        ListNode firstNode = new ListNode(value, sentinel, sentinel);
        sentinel.prev = firstNode;
        sentinel.next = firstNode;
        size = 1;
    }

    public void addFirst(MyType item) {
        ListNode newNode = new ListNode(item, sentinel, sentinel.next);
        sentinel.next = newNode;
        size++;
    }

    public void addLast(MyType item) {
        ListNode newNode = new ListNode(item, sentinel.prev, sentinel);
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode currentNode = sentinel.next;
        for(int i = 0; i < size; i++) {
            System.out.print(currentNode.value.toString() + ' ');
        }
        System.out.println();
    }

    public MyType removeFirst() {
        if (size == 0) {
            return null;
        } 
        MyType first = sentinel.next.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return first;
    }

    public MyType removeLast() {
        if (size == 0) {
            return null;
        } 
        MyType last = sentinel.prev.value;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return last;
    }

    public MyType get(int index) {
        if (index >= size) {
            return null;
        }
        ListNode node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }


    public MyType getRecursiveHelper(int index, ListNode node) {
        if (index == 0) {
            return node.value;
        } else {
            return getRecursiveHelper(index - 1, node.next);
        }
    }

    public MyType getRecursive(int index) {
        if (index >= size) {
            return null;
        } else {
            return getRecursiveHelper(index, sentinel.next);
        }
    }
    
    
}
