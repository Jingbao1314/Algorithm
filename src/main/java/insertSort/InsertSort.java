package insertSort;

/**
 * @author jijngbao
 * @date 19-3-21
 */
public class InsertSort {
    public static void insertSort(int[] list){
        int flag=1;
        if (list==null){
            return;
        }
        if (list.length>=flag){
            while (flag<=list.length-1){
                for (int i=0;i<flag;i++){
                    if (list[i]>list[flag]){
                        int temp=list[flag];
                        move(list,i,flag);
                        list[i]=temp;
                    }
                }
                flag++;
            }
        }

    }
    private static void move(int[] list,int start,int end){
        for(int i=end;i>start;i--){
            list[i]=list[i-1];
        }
        print(list);
        System.out.println("---------------------");
    }
    public static void print(int[] list){
        for (int ele:list
                ) {
            System.out.print(ele);


        }
    }

    public static void main(String[] args) {
        int[]list={3,1,5,4,18,8,7,6};
        insertSort(list);
        print(list);
    }
}
