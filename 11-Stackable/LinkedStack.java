import java.util.LinkedList;

public class LinkedStack implements IStackable {
    LinkedList<Integer> lista = new LinkedList<Integer>();
    public int size(){
        return lista.size();
    }
    public void push(int v){
        lista.addFirst(v);
    }
    public int pop() {
        return lista.removeFirst();
    }
}
