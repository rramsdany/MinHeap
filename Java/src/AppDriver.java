public class AppDriver {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(new IntegerDataType(8));
        heap.add(new IntegerDataType(6));
        heap.add(new IntegerDataType(9));
        heap.add(new IntegerDataType(1));
        heap.add(new IntegerDataType(5));
        heap.add(new IntegerDataType(3));


        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }




    }
}
