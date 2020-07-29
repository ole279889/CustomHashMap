package team.mediasoft.study.java.ee.hashmap;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        CustomHashMap<Integer, String> m = new CustomHashMap<Integer, String>();

        //region PUT_MAP_VALUES
        m.put(27, "hjhj");
        m.put(62, "fhfgh");
        m.put(97, "ghjg");
        m.put(53, "hjkk");
        m.put(71, "jklj");
        m.put(87, "kl;kl;");
        m.put(17, "l;'l'");
        m.put(70, "zcxzx");
        m.put(47, "xcv");
        m.put(38, "xvxxv");
        m.put(127, "kl;kkl;");
        m.put(169, "yuiy");
        m.put(190, "hjkhjk");
        m.put(102, "n,m,n,");
        m.put(146, "etet");
        m.put(137, "zzzzz");
        m.put(25, "1hjhj");
        m.put(65, "1fhfgh");
        m.put(95, "1ghjg");
        m.put(55, "1hjkk");
        m.put(78, "1jklj");
        m.put(85, "1kl;kl;");
        m.put(15, "1l;'l'");
        m.put(51, "1zcxzx");
        m.put(45, "1xcv");
        m.put(35, "1xvxxv");
        m.put(125, "1kl;kkl;");
        m.put(163, "1yuiy");
        m.put(195, "1hjkhjk");
        m.put(103, "1n,m,n,");
        m.put(145, "1etet");
        m.put(135, "1zzzzz");
        m.put(11, "kdfl;");
        m.put(12, ",.m,m,");
        m.put(13, "iopiop");
        m.put(14, "l;'ll;");
        //endregion

        m.remove(45);

        m.displayTable();

        System.out.println("===============================================");
        System.out.println("entrySet--->");

        Set<Map.Entry<Integer,String>> es = m.entrySet();

        System.out.println("entrySet size: " + es.size());
        System.out.println("is entrySet empty: " + es.isEmpty());
        System.out.println("entrySet contains 45: " + es.contains(45));
        System.out.println("entrySet contains 145: " + es.contains(145));

        es.add(new MapNode<Integer, String>(111, "newVal"));

        Iterator<Map.Entry<Integer,String>> itr = es.iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer,String> entr = itr.next();
            System.out.println("[" + entr.getKey() + " --> " + entr.getValue() + "]");
        }

        System.out.println("===============================================");
        System.out.println("keySet--->");

        Set<Integer> ks = m.keySet();

        System.out.println("keySet size: " + ks.size());
        System.out.println("keySet contains 45: " + ks.contains(45));
        System.out.println("keySet contains 145: " + ks.contains(145));

        Iterator<Integer> kItr = ks.iterator();
        while (kItr.hasNext()) {
            Integer key = kItr.next();
            System.out.println("(" + key + ")");
        }
    }
}
