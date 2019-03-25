package removeDuplicates;

/**
 * @author jijngbao
 * @date 19-3-25
 */
public class RemoveDuplicates {
    /* *
     *@describe 删除重复项,保证重复最多两个
     */
    public static void remove(int [] list){
        if (list==null){
            return;
        }
        if (list.length>3){
            int flag=list.length-2;
            int flag_first=list[0];
            int flag_second=list[1];
            int index=2;
            boolean remove=false;
            while (flag>0){
                if (flag_first==flag_second){
                    if (flag_second==list[index]){
                        remove(list,index);
                        remove=true;
                    }else {
                        flag_first=flag_second;
                        if (index!=list.length-1){
                            flag_second=list[index+1];
                        }
                    }
                }else {
                    flag_first=flag_second;
                    flag_second=list[index];
                }
                if (!remove){
                    index++;
                }
                remove=false;
                flag--;
            }
        }
        return;


    }

    private static void remove(int[]list,int index){
        if (index>list.length){
            return;
        }
        for (int i=index;i<list.length-1;i++){
            list[i]=list[i+1];
            list[i+1]=-7721;
        }
    }

    public static void print(int[] list){
        for (int ele:list) {
            System.out.println(ele);
        }

    }

    public static void main(String[] args) {
        int[] list={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,3,5,5,5,7,7,9,9,9,15};
        remove(list);
        print(list);


    }
}
