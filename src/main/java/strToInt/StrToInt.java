package strToInt;

/**
 * @author jijngbao
 * @date 19-3-25
 */
public class StrToInt {
    public static int strToInt(String str){
        if(str==""||str==null){
            return 0;
        }
        char[] list=new char[str.length()];
        str.getChars(0,str.length(),list,0);
        int power=10;
        int num=0;
        for (char ele:list){
            int temp=ele-'0';
            num=num*power+temp;
        }
        return num;
    }

    public static void main(String[] args) {
        String str="123";
        System.out.println(strToInt(str));
    }
}
