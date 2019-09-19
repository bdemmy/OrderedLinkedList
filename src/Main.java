/*
    NAME  : Brendon Demmy
    DATE  : Sep 19, 2019
    EID   : E01723637
    CLASS : COSC 311
 */

class OrderedLinkedList{
    public static class Node{
        private int m_data;
        private Node m_next;

        public Node(int data){
            m_data = data;
            m_next = null;
        }

        public Node(int data, Node next){
            m_data = data;
            m_next = next;
        }

        public int getData(){
            return m_data;
        }

        public Node getNext(){
            return m_next;
        }

        public void setNext(Node next){
            m_next = next;
        }
    }

    private Node m_head, m_tail;

    public OrderedLinkedList(){
        m_head = null;
        m_tail = null;
    }

    public void insert(int data){
        if (m_head == null){
            m_head = new Node(data);
            m_tail = m_head;
            return;
        }

        if (m_head.getData() > data){
            m_head = new Node(data, m_head);
            return;
        }

        Node cur = m_head;
        while (cur != null){
            if (data >= cur.getData()){
                Node next = cur.getNext();
                if (next == null || next.getData() >= data){
                    cur.setNext(new Node(data, cur.getNext()));

                    if (cur == m_tail){
                        m_tail = cur.getNext();
                    }

                    return;
                }
            }
            cur = cur.getNext();
        }
    }

    public void delete(int data){
        if (m_head == null){
            return;
        }

        if (m_head.getData() == data){
            if (m_head == m_tail){
                m_head = null;
                m_tail = null;
            }
            else{
                m_head = m_head.getNext();
            }

            return;
        }

        Node cur = m_head;
        Node last = cur;
        while (cur != null){
            if (cur.getData() == data){
                last.setNext(cur.getNext());
                return;
            }

            last = cur;
            cur = cur.getNext();
        }
    }

    @Override
    public String toString(){
        if (m_head == null){
            return "[Empty]\n";
        }

        StringBuilder output = new StringBuilder();

        int idx = 0;
        Node cur = m_head;

        while (cur != null){
            output.append(String.format("[Index %d] = %d%n", idx, cur.getData()));

            idx++;
            cur = cur.getNext();
        }

        return output.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();

        System.out.println("Execution begun");
        System.out.println("Initial list: \n" + list );

        list.insert(2);
        list.insert(2);
        list.insert(2);
        list.insert(7);
        list.insert(6);
        System.out.println("List after inserts: \n" + list);

        list.delete(2);
        list.delete(5);
        list.delete(7);
        System.out.println("List after deletes: \n" + list);

        System.out.println("Execution terminated");
    }
}

/*
EXAMPLE OUTPUT
--------------

Execution begun
Initial list:
[Empty]

List after inserts:
[Index 0] = 2
[Index 1] = 2
[Index 2] = 2
[Index 3] = 6
[Index 4] = 7

List after deletes:
[Index 0] = 2
[Index 1] = 2
[Index 2] = 6

Execution terminated
 */
