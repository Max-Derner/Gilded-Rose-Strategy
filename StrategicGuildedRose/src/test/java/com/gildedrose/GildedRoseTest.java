package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void testThatIKnowHowReferencesWork(){
        Behaviour b1;
        Behaviour b2 = new Aged();
        b1=b2;
        assertEquals(b1,b2);
    }

    @Test
    void superItemDefaultConstructorProvidesNullPointers(){
        SuperItem item = new SuperItem();
        assertNull(item.behaviour);
        assertNull(item.item);
    }

    @Test
    void superItemCanHaveItemAssigned(){
        SuperItem item = new SuperItem();
        assertNull(item.item);
        item.setItem(new Item("foo",0,0));
        assertNotNull(item.item);
    }

    @Test
    void superItemAndRegularCanUseToStringFunction(){
        SuperItem item = new SuperItem(new Item("foo",1,2),new Regular());
        assertEquals("foo, 1, 2, is regular",item.toString());

    }

    @Test
    void agedCanUseToStringFunction(){
        SuperItem item = new SuperItem(new Item("foo",1,2),new Aged());
        assertEquals("foo, 1, 2, is aged",item.toString());

    }

    @Test
    void conjuredCanUseToStringFunction(){
        SuperItem item = new SuperItem(new Item("foo",1,2),new Conjured());
        assertEquals("foo, 1, 2, is conjured",item.toString());

    }

    @Test
    void ticketCanUseToStringFunction(){
        SuperItem item = new SuperItem(new Item("foo",1,2),new Ticket());
        assertEquals("foo, 1, 2, is ticket",item.toString());

    }
    @Test
    void legendaryCanUseToStringFunction(){
        SuperItem item = new SuperItem(new Item("foo",1,2),new Legendary());
        assertEquals("foo, 1, 2, is legendary",item.toString());

    }

    @Test
    void regularCantHaveQualityLessThan0(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",1,-3),new Regular())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].item.quality);
    }

    @Test
    void ConjuredCantHaveQualityLessThan0(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",1,-3),new Conjured())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].item.quality);
    }

    @Test
    void ticketsDoNotExceedQualityOf50(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",1,49),new Ticket())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].item.quality);
    }

    @Test
    void agedDoesNotExceedQualityOf50(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",-1,49),new Aged())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].item.quality);
    }

    @Test
    void testSuperItemCanBeRReassignedABehaviourAtRuntime(){
        Behaviour originalBehaviour;
        SuperItem superDuper = new SuperItem(new Item("foo",0,0),new Aged());
        originalBehaviour=superDuper.behaviour;
        assertEquals(originalBehaviour,superDuper.behaviour);
        superDuper.setBehaviour(new Legendary());
        assertNotEquals(originalBehaviour,superDuper.behaviour);
    }

    @Test
    void testSuperItemWorksAndImNotStupid(){
        Item item = new Item ("Aged fucking Brie",10,10);
        SuperItem superDuper = new SuperItem(item,new Aged());
        superDuper.update();
        assertEquals(11,superDuper.item.quality);
    }

    @Test
    void limitTestForTicketAtSellIn11(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",11,0),new Ticket())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].item.quality);
    }

    @Test
    void limitTestForTicketAtSellIn10(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",10,0),new Ticket())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].item.quality);
    }

    @Test
    void limitTestForTicketAtSellIn6(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",6,0),new Ticket())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].item.quality);
    }

    @Test
    void limitTestForTicketAtSellIn5(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",5,0),new Ticket())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3,app.items[0].item.quality);
    }

    @Test
    void limitTestForTicketAtSellIn1(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",1,0),new Ticket())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3,app.items[0].item.quality);
    }

    @Test
    void limitTestForTicketAtSellIn0(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",0,50),new Ticket())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].item.quality);
    }

    @Test
    void qualityTestForLegendary(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",0,0),new Legendary())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80,app.items[0].item.quality);
    }

    @Test
    void qualityTestForAged(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",1,0),new Aged())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].item.quality);
    }

    @Test
    void qualityAndLimitTestForAged(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",0,0),new Aged())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].item.quality);
    }

    @Test
    void qualityTestForConjured(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",1,10),new Conjured())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8,app.items[0].item.quality);
    }

    @Test
    void qualityAndLimitTestForConjured(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",0,10),new Conjured())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6,app.items[0].item.quality);
    }

    @Test
    void qualityTestForRegular(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",1,10),new Regular())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9,app.items[0].item.quality);
    }

    @Test
    void qualityAndLimitTestForRegular(){
        SuperItem[] items = new SuperItem[] {new SuperItem(new Item("foo",0,10),new Regular())};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8,app.items[0].item.quality);
    }

}
