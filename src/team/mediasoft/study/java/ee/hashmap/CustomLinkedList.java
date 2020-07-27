package team.mediasoft.study.java.ee.hashmap;

public class CustomLinkedList<K, V> {
    private int size = 0;
    private Node first;
    private Node last;

    CustomLinkedList() {}

    public void add(ListNode<K, V> e) {
        linkLast(e);
    }

    public void add(int index, ListNode<K, V> element) {
        checkElementIndex(index);
        if (index == size)
            linkLast(element);
        else
            linkBefore(element, getNodeByIndex(index));
    }

    public ListNode<K, V> get(int index) {
        checkElementIndex(index);
        CustomLinkedList.Node node = getNodeByIndex(index);
        return new ListNode(node.key, node.value);
    }

    public ListNode<K, V> get(K key) {
        if (!contains(key))
            return null;
        int index = indexOf(key);
        CustomLinkedList.Node node = getNodeByIndex(index);
        return new ListNode(node.key, node.value);
    }

    public boolean contains(K key) {
        int index = indexOf(key);
        return (index == -1) ? false : true;
    }

    public boolean contains(ListNode<K, V> o) {
        return contains(o.getKey());
    }

    public void remove(int index) {
        checkElementIndex(index);
        unlink(getNodeByIndex(index));
    }

    public void remove(Object key) {
        if (key == null) {
            for (CustomLinkedList.Node x = first; x != null; x = x.next) {
                if (x.key == null) {
                    unlink(x);
                }
            }
        } else {
            for (CustomLinkedList.Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    unlink(x);
                }
            }
        }
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Node current = first;
        while(current != null)
        {
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }

    public int size() {
        return size;
    }

    private class Node<K, V> {
        K key;
        V value;
        CustomLinkedList.Node next;
        CustomLinkedList.Node prev;

        Node(CustomLinkedList.Node prev, ListNode<K, V> element, CustomLinkedList.Node next) {
            this.key = element.getKey();
            this.value = element.getValue();
            this.next = next;
            this.prev = prev;
        }

        public void displayNode() {
            System.out.print(key + ": " + value + " | ");
        }
    }

    private Node getNodeByIndex(int index) {
        CustomLinkedList.Node x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void linkLast(ListNode<K, V> element) {
        final CustomLinkedList.Node l = last;
        final CustomLinkedList.Node newNode = new CustomLinkedList.Node(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private void linkBefore(ListNode<K, V> element, CustomLinkedList.Node succ) {
        final CustomLinkedList.Node pred = succ.prev;
        final CustomLinkedList.Node newNode = new CustomLinkedList.Node(pred, element, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds");
    }

    private Object unlink(CustomLinkedList.Node x) {
        final Object key = x.key;
        final CustomLinkedList.Node next = x.next;
        final CustomLinkedList.Node prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.key = null;
        x.value = null;
        size--;
        return key;
    }

    private int indexOf(Object key) {
        int index = 0;
        if (key == null) {
            for (CustomLinkedList.Node x = first; x != null; x = x.next) {
                if (x.key == null)
                    return index;
                index++;
            }
        } else {
            for (CustomLinkedList.Node x = first; x != null; x = x.next) {
                if (key.equals(x.key))
                    return index;
                index++;
            }
        }
        return -1;
    }
}
