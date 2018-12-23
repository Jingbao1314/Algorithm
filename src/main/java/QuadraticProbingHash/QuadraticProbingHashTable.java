package QuadraticProbingHash;

/**
 * @author jijngbao
 * @date 18-12-23
 */
public class QuadraticProbingHashTable <AnyType>{

    public QuadraticProbingHashTable( )
    {
        this( DEFAULT_TABLE_SIZE );
    }


    public QuadraticProbingHashTable( int size )
    {
        allocateArray( size );
        doClear( );
    }


    public boolean insert( AnyType x )
    {

        int currentPos = findPos( x );
        if( isActive( currentPos ) )
            return false;

        if( array[ currentPos ] == null )
            ++occupied;
        array[ currentPos ] = new HashEntry<>( x, true );
        theSize++;

        if( occupied > array.length / 2 )
            rehash( );

        return true;
    }

    private void rehash( )
    {
        HashEntry<AnyType> [ ] oldArray = array;


        allocateArray( 2 * oldArray.length );
        occupied = 0;
        theSize = 0;

        for( HashEntry<AnyType> entry : oldArray )
            if( entry != null && entry.isActive )
                insert( entry.element );
    }

    /* *
     *@describe 用于解决冲突 获取x的下标
     */
    private int findPos( AnyType x )
    {
        int offset = 1;
        int currentPos = myhash( x );

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
            currentPos += offset;  // Compute ith probe
            offset += 2;
            if( currentPos >= array.length )
                currentPos -= array.length;
        }

        return currentPos;
    }

    /* *
     *@describe 对x进行懒惰删除
     */
    public boolean remove( AnyType x )
    {
        int currentPos = findPos( x );
        if( isActive( currentPos ) )
        {
            array[ currentPos ].isActive = false;
            theSize--;
            return true;
        }
        else
            return false;
    }


    public int size( )
    {
        return theSize;
    }


    public int capacity( )
    {
        return array.length;
    }

    /* *
     *@describe 判断x是否已经存在
     */
    public boolean contains( AnyType x )
    {
        int currentPos = findPos( x );
        return isActive( currentPos );
    }

   /* *
    *@describe 判断元素是否活着
    */
    private boolean isActive( int currentPos )
    {
        return array[ currentPos ] != null && array[ currentPos ].isActive;
    }

    /* *
     *@describe 清空array
     */
    public void makeEmpty( )
    {
        doClear( );
    }

    private void doClear( )
    {
        occupied = 0;
        for( int i = 0; i < array.length; i++ )
            array[ i ] = null;
    }

    private int myhash( AnyType x )
    {
        int hashVal = x.hashCode( );

        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;

        return hashVal;
    }

    private static class HashEntry<AnyType>
    {
        public AnyType  element;   // the element
        public boolean isActive;  // false if marked deleted

        public HashEntry( AnyType e )
        {
            this( e, true );
        }

        public HashEntry( AnyType e, boolean i )
        {
            element  = e;
            isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private HashEntry<AnyType> [ ] array; // 存放数据的数组
    private int occupied;                 // 已被占用的空间大小(theSize+notActive的元素个数)
    private int theSize;                  // 当前有效数据的个数

    /* *
     *@describe 实例化array
     */
    private void allocateArray( int arraySize )
    {
        array = new HashEntry[ nextPrime( arraySize ) ];
    }

    /* *
     *@describe 如果n是素数返回n 否则返回第一个比n大的素数
     */
    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    /* *
     *@describe 计算n是不是素数
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }


    /* *
     *@describe  测试
     */
    public static void main( String [ ] args )
    {
        QuadraticProbingHashTable<String> table = new QuadraticProbingHashTable<>
                ( );

        long startTime = System.currentTimeMillis( );

        System.out.println(table.insert("xxx"));
        System.out.println(table.contains("xxx"));

        long endTime = System.currentTimeMillis( );

        System.out.println( "运行时间:" + (endTime - startTime) );
    }

}
