package com.gildedrose;

public class Aged implements Behaviour{
    public void update(Item item){
        item.quality++;
        if(item.sellIn<=0){
            item.quality++;
        }
        if(item.quality>50){
            item.quality=50;
        }
        item.sellIn--;
    }
    @Override
    public String toString(){
        return ", is aged";
    }
}
