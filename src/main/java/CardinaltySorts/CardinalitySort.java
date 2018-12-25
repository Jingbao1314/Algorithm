package CardinaltySorts;

/**
 * @author jijngbao
 * @date 18-12-25
 */
public class CardinalitySort {
    private int [] array;
    private Temp[] temp;

    public CardinalitySort(int[] array) {
        this.array = array;
        temp=new Temp[array.length];
    }
    public void sort(){
        for (int i=0;i<=1000;){
            array=sort(array,i);
            if (i==0){
                i=10;
            }else {
                i=i*10;
            }
        }
        for (int a=0;a<array.length;a++){
            System.out.println(array[a]+"-----------"+a);
        }


    }
    private int[] sort(int [] array,int type){
        int flag=0;
        int temp_Digit=0;
        Temp temps;
        Temp temps_info;
        for (int i=0;i<array.length;i++){
            int temp_Single_Digit=array[i];
            switch (type){
                case 0:
                    temp_Digit=temp_Single_Digit%10;
                    break;
                case 10:
                    temp_Digit=temp_Single_Digit/10%10;
                    break;
                case 100:
                    temp_Digit=temp_Single_Digit/100%10;
                    break;
                case 1000:
                    temp_Digit=temp_Single_Digit/1000%10;
                    break;

            }
            if (temp[temp_Digit]==null){
                temp[temp_Digit]=new Temp(array[i],null);
            }else {
                temps=new Temp(array[i],null);
                temps_info=temp[temp_Digit];
                boolean boo_flag=true;
                while (boo_flag&&temps_info!=null){
                    if (temps_info.getNext()==null){
                        boo_flag=false;
                    }else {
                        temps_info=temps_info.getNext();
                    }
                }
                temps_info.setNext(temps);
            }
        }
        for (int i=0;i<temp.length;i++){
            if (temp[i]!=null){
                Temp t=temp[i];
                while (t!=null){
                    array[flag]=t.getIndex();
                    t=t.getNext();
                    flag++;
                }
            }
            temp[i]=null;
        }
        for (int a=0;a<array.length;a++){
            System.out.println(array[a]+"-----------"+a);
        }

        return array;
    }

    public static void main(String[] args) {
        int []x =new int[10];
        x[0]=999;
        x[1]=888;
        x[2]=777;
        x[3]=666;
        x[4]=555;
        x[5]=444;
        x[6]=333;
        x[7]=222;
        x[8]=111;
        x[9]=0;
        CardinalitySort s=new CardinalitySort(x);
        long startTime = System.currentTimeMillis( );
        s.sort();
        long endTime = System.currentTimeMillis( );

        System.out.println( "运行时间:" + (endTime - startTime) );



    }
}

class Temp{
    private int index;
    private Temp next;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Temp getNext() {
        return next;
    }

    public void setNext(Temp next) {
        this.next = next;
    }

    public Temp(int index, Temp next) {
        this.index = index;
        this.next = next;
    }
}
