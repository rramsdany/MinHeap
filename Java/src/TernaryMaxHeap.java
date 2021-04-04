import java.util.Arrays;

public class TernaryMaxHeap {

    private int capacity = 10;
    private int size = 0;
    private GenericItemType[] items = new GenericItemType[capacity];
    private int index;
    public int getSize() {return size;}
    public int getCapacity() {return capacity;}

    private int getLeftChildIndex(int parentIndex){
        return 3 * parentIndex + 1;
    }
    private int getMiddleChildIndex(int parentIndex){ return 3 * parentIndex + 2; }
    private int getRightChildIndex(int parentIndex){
        return 3 * parentIndex + 3;
    }
    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 3;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    private boolean hasMiddleChild(int index) { return getMiddleChildIndex(index) < size; }
    private boolean hasRightChild(int index){ return getRightChildIndex(index) < size; }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private GenericItemType leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private GenericItemType middleChild(int index) { return items[getMiddleChildIndex(index)]; }
    private GenericItemType rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private GenericItemType parent(int index){
        return items[getParentIndex(index)];
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, (capacity * 3));
            capacity *= 3;
        }
    }

    private void swap(int indexOne, int indexTwo){
        GenericItemType temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void heapifyUp(){
        int index = size - 1;       // Heaps insert at the very end of the heap
        while(hasParent(index) && parent(index).isLess(items[index])){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int value = getLeftChildIndex(index);

            // Find the largest between left, middle, and right children
            if( hasMiddleChild(index) && hasRightChild(index) ){
                if( middleChild(index).isGreater(rightChild(index)) )
                    value = getMiddleChildIndex(index);
            }
            // Find the largest between left and middle children
            else if ( hasMiddleChild(index) && !hasRightChild(index) ){
                if( middleChild(index).isGreater(leftChild(index)))
                    value = getMiddleChildIndex(index);
            }


            if(items[index].isGreater(items[value]))
                break;

            else
                swap(index, value);

            index = value;

        }
    }

    public GenericItemType getMax(){
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
