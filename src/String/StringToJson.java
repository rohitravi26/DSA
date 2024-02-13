package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringToJson {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,2,3,4,5,6);
        List<Integer> squares = num.stream()
                .filter(p->p==10)
                .collect(Collectors.toList());
        Class<?> searchType = (Class)new StringToJson().getClass();
        System.out.println(squares);
        Number n =0;
        System.out.println("#############");
        System.out.println(searchType.equals(StringToJson.class));
        System.out.println(searchType);
        System.out.println(n.getClass().getName());



        Set<String> s = new HashSet<>();
        s.add("rohit");
        s.add("ravi");
        System.out.println(s.contains("rohit"));
        System.out.println(s.containsAll(Arrays.asList(new String[]{"rohit","ravi","rohit"})));
    }
}
