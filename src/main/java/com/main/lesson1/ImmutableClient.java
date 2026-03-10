package com.main.lesson1;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClient{
    private final String name;
    private final String id;
    private final List<String> goods;

    public ImmutableClient(String name, String id, List<String> goods){
        this.name = name;
        if(id.matches("\\d+")){
            this.id = id;
        } else {
            throw new IllegalArgumentException("Id must contain only digits");
        }
        this.goods = new ArrayList<>();
        this.goods.addAll(goods);
    }

    public String getName() {
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public List<String> getGoods(){
        return new ArrayList<>(this.goods);
    }

}
