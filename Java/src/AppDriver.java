public class AppDriver {

    public static void main(String[] args) {
        TernaryMaxHeap heap = new TernaryMaxHeap();

        heap.add(new IntegerDataType(50));
        heap.add(new IntegerDataType(30));
        heap.add(new IntegerDataType(20));
        heap.add(new IntegerDataType(15));
        heap.add(new IntegerDataType(10));
        heap.add(new IntegerDataType(8));
        heap.add(new IntegerDataType(16));


        System.out.println("Original Heap: ");
        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }

        heap.add(new IntegerDataType(55));
        heap.add(new IntegerDataType(10));
        heap.add(new IntegerDataType(10));
        heap.add(new IntegerDataType(6));
        heap.add(new IntegerDataType(12));
        heap.add(new IntegerDataType(13));
        heap.add(new IntegerDataType(25));
        heap.add(new IntegerDataType(45));
        heap.add(new IntegerDataType(20));
        heap.add(new IntegerDataType(70));

        System.out.println("\n\nHeap after inserting values: ");
        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }

        int heapSize = heap.getSize();

        System.out.println("\n\nHeap in ordered order: ");
        for(int i = 0; i < heapSize; i++)
            System.out.print(heap.peek() + " ");









    }
}
