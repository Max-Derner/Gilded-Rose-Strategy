package com.gildedrose;

public class Conjured implements Behaviour{
    public void update(Item item){
        item.quality-=2;
        if(item.sellIn<=0){
            item.quality-=2;
        }
        if(item.quality<0){
            item.quality=0;
        }
        item.sellIn--;
    }
    @Override
    public String toString(){
        return ", is conjured";
    }
}
