# Gilded-Rose-Strategy
This is my attempt at implementing a Strategy Pattern for Terry Hughes' Guilded Rose Kata


This is my first attempt at implementing a Strategy Pattern. I think usually I would have changed the Item class to hold a behaviour but one of the Kata's rules is that you don't change the Item class.

So, instead there is a new superItem class that holds as variables one Item and one Behaviour.

Each Behaviour is a class implementing the Behaviour interface which allows for the delegation of updating quality which gives easier to read code that has less chance of bug introduction when editing the behaviour of a specific Behaviour implementing class or when adding an entirely new behaviour through a new class.

SuperItem delegates the toString method back to Item and to Behaviour, and SuperItem delegates the update method to the stored Behaviour class.


Again, if you're here then it's more than likely I have asked you to be here. So thanks for coming, make sure you take an aged brie and a few concert tickets back with you. But seriously, it means a lot to me that you would help.
