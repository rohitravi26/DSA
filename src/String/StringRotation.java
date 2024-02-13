package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRotation {

        public static void main (String[] args) throws IOException {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            while(t-->0)
            {
                String a = br.readLine();
                String b = br.readLine();

               rotationBy2Places(a,b);



            }


        }

    private static void rotationBy2Places(String a, String b) {
            String s1="",s2="";
            if(a.length()!=b.length())
            {
                System.out.println(0);
                return;
            }
            //cockwise
                 s1= b.substring(2)+b.substring(0,2);
            //anticlock wise
                 s2= b.substring(a.length()-2)+b.substring(0,a.length()-2);


                 if (s1.equals(a)||s2.equals(a))
                     System.out.println(1);
                 else
                     System.out.println(0);


    }


}
