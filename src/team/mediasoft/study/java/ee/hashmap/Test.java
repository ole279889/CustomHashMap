package team.mediasoft.study.java.ee.hashmap;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        CustomHashMap<Integer, String> m = new CustomHashMap<Integer, String>();

        m.put(27, "hjhj");
        m.put(67, "fhfgh");
        m.put(97, "ghjg");
        m.put(57, "hjkk");
        m.put(77, "jklj");
        m.put(87, "kl;kl;");
        m.put(17, "l;'l'");
        m.put(70, "zcxzx");
        m.put(47, "xcv");
        m.put(37, "xvxxv");
        m.put(127, "kl;kkl;");
        m.put(167, "yuiy");
        m.put(197, "hjkhjk");
        m.put(107, "n,m,n,");
        m.put(147, "etet");
        m.put(137, "zzzzz");

        m.put(25, "1hjhj");
        m.put(65, "1fhfgh");
        m.put(95, "1ghjg");
        m.put(55, "1hjkk");
        m.put(75, "1jklj");
        m.put(85, "1kl;kl;");
        m.put(15, "1l;'l'");
        m.put(550, "1zcxzx");
        m.put(45, "1xcv");
        m.put(35, "1xvxxv");
        m.put(125, "1kl;kkl;");
        m.put(165, "1yuiy");
        m.put(195, "1hjkhjk");
        m.put(105, "1n,m,n,");
        m.put(145, "1etet");
        m.put(135, "1zzzzz");

        m.displayTable();

        System.out.print("-------------->" + m.get(167));

        Set<Map.Entry<Integer,String>> st = m.entrySet();
        System.out.print(st.size());
        Iterator<Map.Entry<Integer,String>> itr = st.iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer,String> entr = itr.next();
            System.out.println("[" + entr.getKey() + " --> " + entr.getValue() + "]");
        }
        System.out.println("===============================================");
        Set<Integer> ks = m.keySet();
        Iterator<Integer> kItr = ks.iterator();
        while (kItr.hasNext()) {
            Integer key = kItr.next();
            System.out.println("(" + key + ")");
        }

        //for(Map.Entry<Integer,String> entr: st) {
        //    System.out.print("[" + entr.getKey() + " --> " + entr.getValue() + "]");
        //}
        //List allK = m.getAllKeys();
        //allK.forEach((key) -> System.out.print("<<" + key.toString() + ">>"));

    }
}
