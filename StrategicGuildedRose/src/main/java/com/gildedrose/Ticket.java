package com.gildedrose;

public class Ticket implements Behaviour{
    public void update(Item item){
        if(item.sellIn<=0){
            item.quality=0;
        }else{
            item.quality++;
            if(item.sellIn<=10){
                item.quality++;
            }
            if(item.sellIn<=5){
                item.quality++;
            }
        }
        if(item.quality>50){
            item.quality=50;
        }
        item.sellIn--;
    }
    @Override
    public String toString(){
        return ", is ticket";
    }
}
