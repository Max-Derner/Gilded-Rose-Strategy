package com.gildedrose;

public class SuperItem {
    Item item;
    Behaviour behaviour;
    public SuperItem(){};
    public SuperItem(Item item, Behaviour behaviour){
        this.item=item;
        this.behaviour=behaviour;
    }
    public void setBehaviour(Behaviour behaviour){
        this.behaviour=behaviour;
    }
    public void setItem(Item item){
        this.item=item;
    }
    public void update(){
        behaviour.update(this.item);
    }

    @Override
    public String toString() {
        return item.toString()+behaviour.toString();
    }

}
