package quickSort;

/**
 * @author jijngbao
 * @date 19-3-20
 */
public class QuickSort {
    public static void sort(int [] list,int start,int end){
        int flag=start;
        int key=list[start];
        int i=start;
        int j=end;
        boolean left=true;
        while (i<j){
            if (left){
                if (key>list[j]){
                    list[i]=list[j];
                    list[j]=key;
                    flag=j;
                    left=false;
                    i++;
                }else {
                    j--;
                }

            }else {
                if (key<list[i]){
                    list[j]=list[i];
                    list[i]=key;
                    flag=i;
                    left=true;
                    j--;
                }else {
                      i++;
                }

            }
        }
        System.out.println();
        System.out.println("-----------------------------------"+flag);
//        print(list);
        if (flag-start>1){
            sort(list,start,flag-1);
        }
        if (end-flag>1){
            sort(list,flag+1,end);
                        
        }
    }
    public static void print(int[] list){
        for (int ele:list
             ) {
            System.out.print(ele);


        }
    }

    public static void main(String[] args) {
        int[]list={3,1,5,4,2,8,7,65,15,6};
        sort(list,0,list.length-1);
        print(list);

    }
}
