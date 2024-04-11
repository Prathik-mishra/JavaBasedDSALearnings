package implementationOfHashMap;

public class HashMapImplementation {
    public static void main(String[] args) {
        OurMap<Integer,String> map = new OurMap<>();
        map.put(1,"prathik");
        map.put(10,"shivang");
        map.put(5,"sujith");
        map.put(2,"sajida");
        map.put(9,"vijay");
        map.put(88,"a");
        map.put(96,"b");
        map.put(92,"c");
        map.put(19,"d");




        System.out.println(map.get(1));
        System.out.println(map.get(10));
        System.out.println(map.get(5));
        System.out.println(map.get(2));
        System.out.println(map.get(9));
        System.out.println(map.get(88));
        System.out.println(map.get(96));
        System.out.println(map.get(92));
        System.out.println(map.get(19));


    }
}
