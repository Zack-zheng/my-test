package com.zzz.basic.contain;

import org.junit.Test;

import java.util.*;


/**
 * Created by jack_ on 2016/3/20.
 * 本章节注意equals方法和hascode
 */
public class testCollection {
    @Test
    public void test1() {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("hello");
        c.add(new Name("f1", "l1"));
        c.add(new Integer(100));
        System.out.println(c.size());
        System.out.println(c);
    }

    @Test
    public void testIterator() {
        Collection c = new HashSet();
        c.add(new Name("fff1", "1111"));
        c.add(new Name("f2", "12"));
        c.add(new Name("fff3", "1113"));
        for (Iterator i = c.iterator(); i.hasNext(); ) {
            Name name = (Name) i.next();
            if (name.getFirstName().length() < 3) {
                i.remove();
            }
        }
        System.out.println(c);

    }

    @Test
    public void testEnhancefor() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        Collection c = new ArrayList();
        c.add(new String("aaa"));
        c.add(new String("bbb"));
        c.add(new String("ccc"));
        for (Object o : c) {
            System.out.print(o);
        }
    }

    @Test
    public void testSet() {
        Set s = new HashSet();
        s.add("world");
        s.add("hello");
        s.add(new Name("f1", "f2"));
        s.add(new Integer(100));
        s.add(new Name("f1", "f2"));
        s.add("hello");
        System.out.println(s);
    }

    @Test
    public void testHashSet() {
        Set s1 = new HashSet();
        Set s2 = new HashSet();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s2.add("d");
        s2.add("a");
        s2.add("b");
        //Set和List容器类都具有Constructor（Collection c）
        //构造方法用以初始化容器类
        Set sn = new HashSet(s1);
        sn.retainAll(s2);//交集
        Set su = new HashSet(s1);
        su.addAll(s2);//并集
        System.out.println(sn);
        System.out.println(su);
    }

    @Test
    public void testLinkedList1() {
        List l1 = new LinkedList();
        for (int i = 0; i <= 5; i++) {
            l1.add("a" + i);
        }
        System.out.println(l1);
        l1.add(3, "a100");
        System.out.println(l1);
        l1.set(6, "a200");
        System.out.println(l1);
        System.out.println(l1.get(2));
        System.out.println(l1.indexOf("a3"));
        l1.remove(1);
        System.out.println(l1);

    }

    @Test
    public void testCollections() {
        List l1 = new LinkedList();
        List l2 = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            l1.add("a" + i);
        }
        System.out.println(l1);
        Collections.shuffle(l1);//随机排序
        System.out.println(l1);
        Collections.reverse(l1);//逆序
        System.out.println(l1);
        Collections.sort(l1);//排序
        System.out.println(l1);
        System.out.println(Collections.binarySearch(l1, "a5"));//中分法

    }

    @Test
    public void testcomparable() {
        List l1 = new LinkedList();
        l1.add(new Name("Karl", "M"));
        l1.add(new Name("Steven", "Lee"));
        l1.add(new Name("John", "o"));
        l1.add(new Name("Tom", "M"));
        System.out.println(l1);
        Collections.sort(l1);
        System.out.println(l1);
    }

    @Test
    public void testMap() {
        Map m1 = new HashMap();
        Map m2 = new TreeMap();
        m1.put("one", new Integer(1));//jdk1.5之前要new一个对象put进去
        m1.put("two", new Integer(2));//现在如testMapAutoboxing方法
        m1.put("three", new Integer(3));
        m2.put("A", new Integer(1));
        m2.put("B", new Integer(2));
        System.out.println(m1.size());
        System.out.println(m1.containsKey("one"));
        System.out.println(m2.containsValue(new Integer(1)));
        if (m1.containsKey("two")) {
            int i = ((Integer) m1.get("two")).intValue();
            System.out.println(i);
        }
        Map m3 = new HashMap();
        m3.putAll(m2);
        System.out.println(m3);
    }

    @Test
    public void testMapAutoboxing() {//又叫wrapping
        Map m1 = new HashMap();
        Map m2 = new TreeMap();
        m1.put("one", 1);//jdk1.5之前要new一个对象put进去
        m1.put("two", 2);//现在如test方法
        m1.put("three", 3);
        m2.put("A", 1);
        m2.put("B", 2);
        System.out.println(m1.size());
        System.out.println(m1.containsKey("one"));
        System.out.println(m2.containsValue(1));
        if (m1.containsKey("two")) {
            int i = (Integer) m1.get("two");
            System.out.println(i);
        }
        Map m3 = new HashMap();
        m3.putAll(m2);
        System.out.println(m3);
    }

    @Test
    public void testMapGeneric() {
        Map<String, Integer> m1 = new HashMap<String, Integer>();
        Map<String, Integer> m2 = new TreeMap<String, Integer>();
        m1.put("one", 1);
        m1.put("two", 2);
        m1.put("three", 3);
        m2.put("A", 1);
        m2.put("B", 2);
        System.out.println(m1.size());
        System.out.println(m1.containsKey("one"));
        System.out.println(m1.containsValue(1));
        if (m1.containsKey("two")) {
            int i = m1.get("two");
            System.out.println(i);
        }
        Map m3 = new HashMap();
        m3.putAll(m2);
        System.out.println(m3);

    }

    //testargsWords
//    private static final Integer ONE = new Integer(1);
    private static final int ONE = 1;

    public static void main(String[] args) {
//        Map m = new HashMap();
        Map<String, Integer> m = new HashMap<String, Integer>();
        for (int i = 0; i < args.length; i++) {
//            int freq = m.get(args[i]) == null ? 0 :(Integer) m.get(args[i]);
//            m.put(args[i], (freq == null? ONE : new Integer((freq + 1))));
//            m.put(args[i], (freq == 0? ONE :  freq + 1));
            if (!m.containsKey(args[i])) {
                m.put(args[i], ONE);
            } else {
                int freq = m.get(args[i]);
                m.put(args[i], freq + 1);
            }
        }
        System.out.println(m.size() + " distinct words detected");
        System.out.println(m);
    }


    @Test
    public void testGeneric() {
        List<String> c = new ArrayList<String>();
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        for (int i = 0; i < c.size(); i++) {
            String s = c.get(i);
            System.out.println(s);
        }

        Collection<String> c2 = new HashSet<String>();
        c2.add("aaa");
        c2.add("bbb");
        c2.add("ccc");
        for (Iterator<String> it = c2.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }

    @Test
    public void testIteratorGeneric() {
        Set s = new HashSet();
        List l = new LinkedList();
        s.add("aaa");
        Iterator<String> si = s.iterator();
        String sis = si.next();
        System.out.println(sis);

        l.add(3);
        Iterator<Integer> li = l.iterator();
        int lis = li.next();
        System.out.println(lis);

    }

}

class MyName implements Comparable<MyName> {
    int age;

    public int compareTo(MyName o) {
        if (this.age > o.age) return 1;
        else if (this.age < o.age) return -1;
        else return 0;
    }

}