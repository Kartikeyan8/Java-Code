import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
//    public static String reverseWords(String s)
//    {
//        Stack<String> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<s.length();i++)
//        {
//            if(s.charAt(i) != '.')
//            {
//                sb.append(s.charAt(i));
//            }
//            else if(sb.length() > 0)
//            {
//                stack.push(sb.toString());
//                sb.setLength(0);
//            }
//        }
//        if(sb.length() > 0)
//        {
//            stack.push(sb.toString());
//        }
//        StringBuilder res = new StringBuilder();
//        while(!stack.isEmpty())
//        {
//            res.append(stack.pop());
//            res.append(".");
//
//        }
//        return res.toString();
////        StringBuilder result = new StringBuilder();
//
//
//    }
//    public static String check(String s)
//    {
//        ArrayList<String> words = new ArrayList<>();
//        String[] part = s.split("\\.");
//        for(String it : part)
//        {
//
//        }
//
//    }
    static class Person{
        int age;
        String name;
        Person(int age,String name)
        {
            this.age = age;
            this.name = name;
        }

}
    public static void main(String[] args){
        List<String> s = Arrays.asList("as","aa","a","aww","wwwww");
        s.replaceAll(item->item.toLowerCase());
        s.sort((a,b)->a.compareTo(b));
        List<Integer> list = new ArrayList<>(Arrays.asList(10,12,34,2));
        list.removeIf(n->n%2 != 0);
        List<Person> p = Arrays.asList(new Person(21,"ka"),new Person(2,"ba"));
        p.sort(Comparator.comparingInt(a -> a.age));
        p.forEach(i-> System.out.println(i.toString()));
        List<Integer> sq = list.stream().map(n->n*n).collect(Collectors.toList());
        List<Integer>odd = list.stream().filter(n->n%2 != 0).collect(Collectors.toList());
        int maxi = list.stream().max(
        String concatenated_string = s.stream().collect(Collectors.joining(""));
        List<Integer>greater_than_10 = list.stream().filter(n->n>10).collect(Collectors.toList());
        Optional<Integer> firstEven = Arrays.asList(1,3,2,12,11).stream().filter(n->n%2 ==0).findFirst();
        List<Integer>distinct  = list.stream().distinct().collect(Collectors.toList());
        Map<Integer,List<String>>bylen = s.stream().collect(Collectors.groupingBy(String::length));
//        for(Map.Entry<Integer,List<String>> t : bylen.entrySet())
//        {
//            System.out.println(t.toString());
//        }
        List<Integer> nums = Arrays.asList(5, 9, 11, 2, 8, 21);
        Optional<Integer> second = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
//        System.out.println(second.get());
//        List<String> names = Arrays.asList("John", "Alice", "Bob", "John", "Alice");
//        Map<String, Long> duplicate = (Map<String, Long>) names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(e->e.getValue()>1).collect(Collectors.toList());
//        System.out.println(duplicate);
//        String str= "satreaming";
//        Map<Object,Long> freq = str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        System.out.println(freq);
        ArrayList<String> items = new ArrayList<>(){{
            add("apple");
            add("banana");
            add("");
        }};
        String longest = items.stream().min(Comparator.comparingInt(ss->ss.length())).orElse("");
        System.out.println(longest);
        List<String> words = Arrays.asList("apple", "ant", "banana", "ball");
        Map<> grouped = words.stream().collect(Collectors.groupingBy(word->word.compareTo()))
    }
}