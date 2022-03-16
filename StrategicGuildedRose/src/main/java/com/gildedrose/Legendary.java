package com.gildedrose;

public class Legendary implements Behaviour{
    public void update(Item item){
        item.quality=80;
    }
    @Override
    public String toString(){
        return ", is legendary";
    }
}
