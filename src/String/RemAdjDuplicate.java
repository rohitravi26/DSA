package String;

public class RemAdjDuplicate {

    public static void main(String[] args) {
        String str="mississipie";
        String res= removeDuplicate(str);
        System.out.println(res);
    }

    private static String removeDuplicate(String str) {

        int n= str.length();
        int i = 0;

        String res="";
        boolean flag=false;
        while(i<str.length())
        {
            int len = 1;
            int j= i;
            while(true)
            {

               if(j<str.length()-1 && str.charAt(j)==str.charAt(++j))
               {
                   len++;
                   flag=true;
               }

                else
                    break;
            }
            if(len > 1)
            {
                str=str.substring(0,i) + str.substring(i+len);
                i=i-1;
            }
         i++;
            if(flag && i==str.length())
            {
                flag=false;
                i=0;
            }
        }




        return str;


    }
}
