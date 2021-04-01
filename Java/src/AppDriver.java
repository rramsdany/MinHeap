public class AppDriver {

    public static void main(String[] args) {
        TernaryMaxHeap heap = new TernaryMaxHeap();

        heap.add(new IntegerDataType(20));
        heap.add(new IntegerDataType(18));
        heap.add(new IntegerDataType(13));
        heap.add(new IntegerDataType(15));
        heap.add(new IntegerDataType(11));
        heap.add(new IntegerDataType(12));
        heap.add(new IntegerDataType(16));
        heap.add(new IntegerDataType(10));
        heap.add(new IntegerDataType(9));
        heap.add(new IntegerDataType(11));
        heap.add(new IntegerDataType(13));
        heap.add(new IntegerDataType(2));
        heap.add(new IntegerDataType(9));
        heap.add(new IntegerDataType(10));
        heap.add(new IntegerDataType(1));


        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }

        heap.add(new IntegerDataType(19));

        System.out.println();
        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }





    }
}
