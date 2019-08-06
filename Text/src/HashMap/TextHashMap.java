package HashMap;

import java.util.Arrays;

public class TextHashMap<K, V>{
    Node[] table = new Node[16];
    int size;

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();

       for(int i = 0; i < table.length; i++){
           Node temp = table[i];

           while(temp != null){
               sb.append(temp.key + ":" + temp.value+",");
               temp = temp.next;

           }
       }
       return sb.toString();
    }

    public void put(K key, V value){
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];
        Node last = null;

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

    public int myHash(int v, int length){
        return v & (length - 1);
    }

    public static void main(String[] args){
        TextHashMap<Integer, String> m = new TextHashMap();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");

        System.out.println(m);
    }
}
