package com.main;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        String name = "Kirill";
        String id1 = "1234565";
        String id2 = "1233e";
        List<String> goods = new ArrayList<>(List.of("car", "house", "phone"));
        try {
            ImmutableClient client1 = new ImmutableClient(name, id1, goods);
            client1.getGoods().add("gold");
            System.out.println(client1.getGoods());
            goods.add("gold");
            System.out.println(client1.getGoods());
            id1 = "1234A";
            System.out.println(client1.getId());
            ImmutableClient client2 = new ImmutableClient(name, id2, goods);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
