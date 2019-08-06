package HashMap;

public class TextHashMap01<K, V>{
    Node[] table = new Node[16];

    public Object get(K key){
        int hash = myHash(key.hashCode(), table.length);
        V value = null;

        if(table[hash] != null){
            Node temp = table[hash];

            while(temp != null){
                if(temp.key.equals(key)){
                    value = (V)temp.value;
                    break;
                }
                temp = temp.next;
            }
        }
        return value;
    }

    public  int myHash(int v, int length){
        return v & (table.length - 1);
    }

    public void put(Object key, Object value){
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length - 1);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];
        Node last = null;
        boolean flag = false;

        if(temp == null){
            table[newNode.hash] = newNode;
        }else {
            while(temp != null){
                if(temp.key.equals(key)){
                    temp.value = value;
                    break;
                }
                last = temp;
                temp = temp.next;
            }

            last.next = newNode;
        }
    }

    public static void main(String[] args){
        TextHashMap01 m = new TextHashMap01();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");

        System.out.println(m.get(10));

    }

}
