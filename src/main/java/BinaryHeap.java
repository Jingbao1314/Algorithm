/**
 * @author jijngbao
 * @date 18-12-25
 */
public class BinaryHeap{

    public BinaryHeap( )
    {
        this( 10 );
    }


    public BinaryHeap( int capacity )
    {
        currentSize = 0;
        array = new int[capacity + 1];
    }


    public void insert( int x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

        // Percolate up
        int hole = ++currentSize;
        for( array[ 0 ] = x; (compares(x,array[ hole / 2 ] ) < 0); hole /= 2 ){
            array[ hole ] = array[ hole / 2 ];
        }

        array[ hole ] = x;
    }


    private void enlargeArray( int newSize )
    {
        int [] old = array;
        array = new int[newSize];
        for( int i = 0; i < old.length; i++ )
            array[ i ] = old[ i ];
    }


    public int findMin( )
    {
        if( isEmpty( ) )
            throw new RuntimeException( );
        return array[ 1 ];
    }


    public int deleteMin( )
    {
        if( isEmpty( ) )


            throw new RuntimeException( );

        int minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }





    public boolean isEmpty( )
    {
        return currentSize == 0;
    }



    private int currentSize;
    private int [ ] array;

    private void percolateDown( int hole )
    {
        int child;
        int tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    (compares(array[ child + 1 ],array[ child ])<0))
                child++;
            if( compares(array[ child ],tmp)<0)
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
    }


    public int compares(int comparator, int comparative){
        return new Integer(comparator).compareTo(comparative);
    }


    public static void main( String [ ] args )
    {
       BinaryHeap h=new BinaryHeap();
       h.insert(30);
       h.insert(5);
       h.insert(25);
       h.insert(11);
       h.insert(33);
       h.insert(8);
       for (int i=0;i<6;i++){
           System.out.println(h.deleteMin());
       }


    }
}
