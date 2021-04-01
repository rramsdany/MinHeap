import java.util.Arrays;

public class MaxHeap {

    private int capacity = 10;
    private int size = 0;
    private GenericItemType[] items = new GenericItemType[capacity];
    private int index;


    private int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){ return getRightChildIndex(index) < size; }

    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private GenericItemType leftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private GenericItemType rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private GenericItemType parent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo){
        GenericItemType temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public GenericItemType peek(){
        if(size == 0) throw new IllegalStateException();
        GenericItemType item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(GenericItemType item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index).isLess(items[index])){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index).isGreater(leftChild(index)))
                smallerChildIndex = getRightChildIndex(index);

            if(items[index].isGreater(items[smallerChildIndex]))
                break;
            else
                swap(index, smallerChildIndex);

            index = smallerChildIndex;


        }

    }

    public void iterator_initialize(){
        index = 0;
    }
    public boolean iterator_hasNext(){
        return index <= size - 1;
    }
    public GenericItemType iterator_getNext(){
        return items[index++];
    }
}
