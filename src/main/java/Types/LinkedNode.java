package Types;

public class LinkedNode<T> {
    public T value;
    protected LinkedNode<T> previous = null;
    protected LinkedNode<T> next = null;
    public LinkedNode<T> left  = null;
    public LinkedNode<T> right = null;

    public LinkedNode(T value){
        this.value = value;
    }

    LinkedNode(T value, LinkedNode<T> link, int type){
        if (type == 1){
            this.value = value;
            this.previous = link;
        }
        else{
            this.value = value;
            this.next = link;
        }
    }
}
