import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestAnything {
    public static void main(String[] args) {
//         HashMap is a class implemented from Map interface
        Map<String,Object> map = new HashMap<>();
        map.put("Michael",35);
        map.put("John",20);
        map.put("Michael",40);
        System.out.println(map);
        System.out.println(map.get("Michael"));
        System.out.println(map.values());

        // Takes ascending order
        Map<Integer,Object> treeMap= new TreeMap<>();
       treeMap.put(1,10);
       treeMap .put(115,50);
       treeMap.put(10,90);
        System.out.println(treeMap);
    }
}

//abstract class A{
//    public A(){
//        System.out.println("Cons of A");
//    }
//
//    public A(int a){
//
//    }
//}
// class B extends A{
//    B (){
//        super(5);
//        System.out.println("Cons of B only");
//    }
//     public static void main(String[] args) {
//         B objB =new B();
////         A objA =new B();
//
//     }
//
// }