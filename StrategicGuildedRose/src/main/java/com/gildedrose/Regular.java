package com.gildedrose;

public class Regular implements Behaviour{
    public void update(Item item){
        item.quality--;
        if(item.sellIn<=0){
            item.quality--;
        }
        if(item.quality<0){
            item.quality=0;
        }
        item.sellIn--;
    }
    @Override
    public String toString(){
        return ", is regular";
    }
}
