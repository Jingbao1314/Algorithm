package mergingSort;

/**
 * @author jijngbao
 * @date 19-3-20
 */
public class MergingSort {
    public static void merge(int []list,int start,int end,int []res){
        if (end-start>=2){
            merge(list,start,(start+end)/2,res);
            merge(list,(start+end)/2+1,end,res);
            int i=start;
            int j=(start+end)/2+1;
            int limit=j;
            int flag=end-start;
            while (flag>=0){
                if (i<limit){
                    if (list[i]<list[j]){
                        res[start]=list[i];
                        i++;
                        System.out.println(list[i]+"交换"+list[j]);
                    }else {
                        res[start]=list[j];
                        j++;
//                    System.out.println(list[i]+"交换"+list[j]);
                    }
                }else {
                    res[start]=list[j];
                    j++;
                }

                start++;
                flag--;
            }
        }else {
            if (list[start]>list[end]){
                int temp=list[end];
                list[end]=list[start];
                list[start]=temp;
                System.out.println(list[start]+"---"+list[end]);

            }else {
                System.out.println(list[start]+"---"+list[end]);
            }
        }
    }
    public static void print(int[] list){
        for (int ele:list
                ) {
            System.out.print(ele);


        }
    }

    public static void main(String[] args) {
        int[]list={3,1,5,4,2,6,7,9,14,15};
        int []res=new int[list.length];
        merge(list,0,list.length-1,res);
        print(res);
    }
}
