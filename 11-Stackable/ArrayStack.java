import java.util.ArrayList;

public class ArrayStack implements IStackable {
    ArrayList<Integer> array = new ArrayList<Integer>();
    public int size(){
        return array.size();
    }
    public void push(int v){
        array.add(v);
    }
    public int pop() {
        return array.remove((array.size())-1);
    }

}
