import java.util.ArrayList;
public class Stack <I> implements StackOperations <I>{
   private ArrayList<I> Object;


  /**
     * Constructor for Stack
     * Create new ArrayList
     */
    public Stack()
    {
        Object = new ArrayList<I>();
    }


    @Override
    public void push(Object item) {
        Object.add((I) item);
    }

    @Override
    public void pop() {
        Object.remove(Object.size() -1);

    }

    @Override
    public I peek() {
        return Object.getFirst();
    }

    @Override
    public int size() {
        return Object.size();

    }

    @Override
    public boolean isEmpty() {
        if (Object.size() == 0){
            return true;
        }
        else return false;
    }
}

public void main() {
}
