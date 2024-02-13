package DataStructure;

public class MinHeap {
int capacity,
        heap_size;
int harr[];



    public MinHeap(int capacity)
    {
        heap_size=0;
        this.capacity=capacity;
        harr=new int[capacity];
    }
     public int parent(int i)
     {
         return (i-1)/2;
     }

    public int left(int i)
    {
        return (2*i+1);
    }

    public int right(int i)
    {
        return 2*i+2;
    }


    public void insertKey(int key)
    {
        if(heap_size==capacity)
        {
            System.out.println("no more elements are allowed");
            return;
        }

        int i=heap_size++;

        harr[i]=key;

        while(i>0 && harr[i]<harr[parent(i)] )
        {
            swap(i,parent(i));
            i=parent(i);
        }


    }

    public void decreseKey(int i, int new_val)
    {
        if(heap_size<i)
            return;
        harr[i]=new_val;
        while(i>0 && harr[i]<harr[parent(i)] )
        {
            swap(i,parent(i));
            i=parent(i);
        }



    }
    public int extractMin()
    {
        if(heap_size==0)
            return Integer.MIN_VALUE;
        int root=harr[0];
        if(heap_size==1) {
            heap_size--;
            return root;
        }
        swap(0,heap_size-1);
        heap_size--;
        minHeapify(0);
        return root;
    }
    public void minHeapify(int i)
    {
        int l=left(i);
        int r=right(i);
        int smallest=i;

        if(l<heap_size && harr[l]<harr[smallest])
            smallest=l;
        if(r<heap_size && harr[r]<harr[smallest])
            smallest=r;

        if(smallest!=i)
        {
            swap(i,smallest);
            minHeapify(smallest);
        }

    }
    public int getMinimum()
    {
        if(harr.length==0)
            return Integer.MIN_VALUE;
        return harr[0];
    }
    private void swap(int i, int parent) {
        int temp=harr[i];
        harr[i]=harr[parent];
        harr[parent]=temp;
    }

    public static void main(String[] args) {

        int arr[]={20,10,24,200,39,1,5,3,88,88,-3};

        MinHeap m=new MinHeap(6);
        m.insertKey(20);
        m.insertKey(10);
        m.insertKey(24);
        m.insertKey(1);
        m.insertKey(-3);
        m.insertKey(88);

        System.out.println(m.getMinimum());
        //System.out.println(Integer.MAX_VALUE);
    }
}
