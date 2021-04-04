public class AppDriver {

    public static void main(String[] args) {
        TernaryMaxHeap heap = new TernaryMaxHeap();

        heap.add(new IntegerDataType(100));
        heap.add(new IntegerDataType(75));
        heap.add(new IntegerDataType(70));
        heap.add(new IntegerDataType(85));

        System.out.println("Original Heap: ");
        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }


        heap.add(new IntegerDataType(90));
        heap.add(new IntegerDataType(95));
        heap.add(new IntegerDataType(98));

        System.out.println("\n\nHeap after inserting values: ");
        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }

        heap.add(new IntegerDataType(80));
        heap.add(new IntegerDataType(86));

        System.out.println("\n\nHeap after inserting values: ");
        heap.iterator_initialize();
        while(heap.iterator_hasNext()){
            GenericItemType next = heap.iterator_getNext();
            System.out.print(next + " ");
        }




        int heapSize = heap.getSize();

        System.out.println("\n\nHeap in ordered order (calling getMax()) : ");
        for(int i = 0; i < heapSize; i++)
            System.out.print(heap.getMax() + " ");







    }
}
