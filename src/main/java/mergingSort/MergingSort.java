package mergingSort;

/**
 * @author jijngbao
 * @date 19-3-20
 */
public class MergingSort {
    public static int[] merge(int []list,int start,int end){
        int[] res=new int[end-start+1];
        int res_index=0;
        if (end-start>=2){
            int[] a=merge(list,start,(start+end)/2);
            int[] b=merge(list,(start+end)/2+1,end);
            int i=0;
            int j=0;
            print(a);
            print(b);
            boolean a_flag=true;
            boolean b_flag=true;
            System.out.println("---------------------------");
            int flag=res.length-1;
            while (flag>0) {
                 if (a[i] < b[j]) {
                     if (i==a.length-1){
                         if (a_flag){
                             System.out.println(a[i]+"a赋值");
                             res[res_index] = a[i];
                             a_flag=false;
                         }else {
                             res[res_index] = b[j];
                             System.out.println(b[j]+"b赋值");
                             if (j < b.length-1) {
                                 j++;
                             }
                         }
                     }else {
                         System.out.println(a[i]+"a赋值");
                         res[res_index] = a[i];
                         if (i < a.length-1) {
                             i++;
                         }
                     }
                 } else {
                     if (j==b.length-1){
                         if (b_flag){
                             System.out.println(b[j]+"b赋值");
                             res[res_index] = b[j];
                             b_flag=false;
                         }else {
                             System.out.println(a[i]+"a赋值");
                             res[res_index] = a[i];
                             if (i < a.length-1) {
                                 i++;
                             }
                         }
                     }else {
                         res[res_index] = b[j];
                         System.out.println(b[j]+"b赋值");
                         if (j < b.length-1) {
                             j++;
                         }

                     }
//                    System.out.println(list[i]+"交换"+list[j]);
                 }
                 if (flag==1){
                     if (a[i] > b[j]) {
                         System.out.println(a[i]+"a赋值");
                         res[res_index+1] = a[i];

                     } else {
                         System.out.println(b[j]+"b赋值");
                         res[res_index+1] = b[j];

//                    System.out.println(list[i]+"交换"+list[j]);
                     }

                 }
                 flag--;

                 res_index++;
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
            res[0]=list[start];
            res[1]=list[end];

        }
        return res;
    }
    public static void print(int[] list){
        for (int ele:list
                ) {
            System.out.print(ele);


        }
    }

    public static void main(String[] args) {
        int[]list={3,1,5,56,2,8,7,6};
        int []res =merge(list,0,list.length-1);
        print(res);
    }
}
