
import Array.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("a");
        list1.add("c");
        list1.add("a");
        list1.add("d");
        list1.add("e");
        list2.add("abhinav");
        list2.add("tashu");
        list2.add("new boi");
        list3.add("abhinav");
        list3.add("tashu");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        list3.retainAll(list2);
        System.out.println(list3);
    }
}