## **Game Tutorial**

In this assignment, was used many different concepts of Object-Oriented Programming and it will be explained by steps.

### __Building a character__
To build an enemy, a warrior and a wizard, was created a Persona class. This class is responsible to is assigning the lifePoint, attackPoint and defensePoint. It's possible see it in Hero class too, that is a parent class and extends your atributes and methods to Warrior and Wizard class.That is, was used inheritance, because the classes Enemy and Hero, acquires all the properties of a Persona class and after, the classes Wizard and Warrior, acquires all the properties and behaviors of a Hero class, in order not to repeat code and take advantage of attributes and methods to the child class. It's possible see it in this code below. 

```java
public abstract class Persona{
    ...
}
``` 

```java
public class Enemy extends Persona {
    ...
}
``` 

```java
public abstract class Hero extends Persona{
    ...
}
``` 

```java
public class Warrior extends Hero{
    ...
}
``` 

```java
public class Wizard extends Hero{
    ...
}
``` 

In Persona and Hero classes it's possible to see the directive "abstract". It is a kind of special class that cannot be instantiated, only inherited. Therefore, an abstract class cannot have an object created from its instantiation. These classes are very important when we don't want to create an object from a “general” class, just from its “subclasses”.

As an example the three classes (Hero, Wizard and Warrior), being the Hero class a “general” class (class “parent”). When starting the program, you don't create a new Hero, but a Wizard or Warrior.

* ### __Creating an Enemy__

As enemy exteds Persona, it has all atributes and more your own atribute that is 
```java
public class Enemy extends Persona {

    private Integer magicPoint;
    private Integer desertDamage;
    private Integer forestDamage;
    private Integer riverDamage;
    ...
```

There are two options to create an enemy, one is by a randomic points and another is using an EnemyEnum, that has a three kind of enemys

* Randomic points
```java
    public Enemy(Random random) {
        super(random.nextInt((80 - 70) + 1) + 70, random.nextInt((15 - 10) + 1) + 10, random.nextInt((8 - 3) + 1) + 3);
    }
```
* By EnemyEnum
```java
public enum EnemyEnum {

    DRAGON {
        @Override
        Integer life() {
            return 87;
        }

        @Override
        Integer attackPointOnForest() {
            return this.attack();
        }
       ...
    },
    GOBLIN {
        ...
        @Override
        Integer attack() {
            return 18;
        }
        
        @Override
        Integer attackPointOnDesert() {
            return 0;
        }
        ...
    },
    ZOMBIE {
        ...
        @Override
        Integer defense() {
            return 10;
        }

        @Override
        Integer attackPointOnRiver() {
            return 0;
        }
        ...
    };
    abstract Integer life();
    abstract Integer attack();
    abstract Integer defense();
    abstract Integer magicPointDamage();
    abstract Integer attackPointOnForest();
    abstract Integer attackPointOnDesert();
    abstract Integer attackPointOnRiver();
}
```
As when there is a Dragon in forest the wizard damage must be the double, returns the same attack point, but in others sceneries and enemies, returns 0, because the damage is not modify.
```java
    public Enemy(EnemyEnum enemyEnum) {
        super(enemyEnum.life(), enemyEnum.attack(), enemyEnum.defense());
        this.magicPoint = enemyEnum.magicPointDamage();
        this.desertDamage = enemyEnum.attackPointOnDesert();
        this.forestDamage = enemyEnum.attackPointOnForest();
        this.riverDamage = enemyEnum.attackPointOnRiver();
    }
```
In this case, was passed as argument in Enemy constructor a kind of EnemyEnum and depending on the argument these four methods magicPointDamage(), attackPointOnDesert(), attackPointOnForest() and attackPointOnRiver() returns differents numbers, that is the same action in many different ways. That is called polymorphism, when one task is performed in different way. 

* ### __Creating an Equipment__

Initially, was declared an abstract method to be override in each enum and return different numbers.
```java
public enum EquipmentsEnum {
    ARMOR {
        @Override
        Integer improveDamage() {
            return 0;
        }
        ...
    },
    SWORD {
        @Override
        Integer improveDamage() {
            return 8;
        }
        ...
    },
    ARCHERY {
        @Override
        Integer improveDamage() {
            return 12;
        }
        ...
    };

    abstract Integer improveDamage();
    ...
}
```
To build an equipment was necessary an EquipmentsEnum, improveDamage, reduceDamage and inventorySpace.Was used polymorphism when one task is performed in different way, like in this code bellow 
```java
public class Equipment {

    private EquipmentsEnum name;
    private int improveDamage;
    private int reduceDamage;
    private int inventorySpace;

        public Equipment(EquipmentsEnum name) {
                this.name = name;
                this.improveDamage = name.improveDamage();
                this.reduceDamage = name.reduceDamage();
                this.inventorySpace = name.inventorySpace();
        }
}
```
In this case, was passed as argument on Equipment constructor a kind of EquipmentEnum and depending on the argument  these three methods improveDamage(), reduceDamage() and inventorySpace() returns differents numbers, that is the same action in many different ways. 

* ### __Creating a Warrior or a Wizard__

As Warrior and Wizard exteds Hero, it have all atributes and more your own methods.
* __Wizard__ 

By default, lifePoint is 100, attackPoint is 10 and defensePoint is 5.

```java 
public class Wizard extends Hero{

    public Wizard(List<Equipment> inventory) {
        super(100, 10, 5, inventory);
    }

    public Integer attackUsingMagic(Enemy enemy){
        return enemy.getLifePoint() - (this.getAttackPoint() + enemy.getMagicPoint());
    }
}
```

* Before
In a oldest way to use this function is passing as argument a hero, that can be a Wizard or a Warrior, and when this function was called, the user choose what kind of hero it wants.
```java
public class Hero extends Persona{
    ...

    public Integer usePotions(Enemy enemy, Hero hero) {
        return (int) (enemy.getLifePoint() - hero.getAttackPoint() * 1.15);
    }
}
```

```java
wizard.usePotions(enemy, wizard);
```
**or**

```java
warrior.usePotions(enemy, warrior);
```
However, this way is not good, and isn't necessary to put the kind of hero as argument, because you already call this function in a hero.

* After
Look, here rather than put a Hero as argument, will be only passed the enemy and will be used the directive "this", that use the own object in this function. 

```java
public class Hero extends Persona{
    ...

    public Integer usePotions(Enemy enemy) {
        return (int) (enemy.getLifePoint() - this.getAttackPoint() * 1.15);
    }
}
```

```java
wizard.usePotions(enemy);
```
**or** 

```java
warrior.usePotions(enemy);
```
This way is correctly, more simple and elegant.

* __Warrior__ 

By default, lifePoint is 100, attackPoint is 8 and defensePoint is 3.

```java
public class Warrior extends Hero {

    public Warrior(List<Equipment> inventory) {
        super(100, 8, 3, inventory);
    }

    @Override
    public Integer usePotions(Enemy enemy) {
        return (int) (enemy.getLifePoint() - this.getAttackPoint() * 1.10);
    }
}
```

The usePotions method was override to change the calculation instead of being 1.15, becomes 1.10.

### __Building a Scnery__

To build a scnery, it's necessary a Hero, and two kind of enemys. The Scenery class is abstract and only is possible instanciate a River, Desert or Forest. 

There are two kind of constructors in each scenery, one has a Hero and two Enemies, and other has one Hero and one Enemy.

```java
public Scenery(Hero hero, Enemy enemy1, Enemy enemy2) {
        this.hero = hero;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
    }

    public Scenery(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }
```
* __BattleOnScenery Interface__

It's possible see in this interface which attackOnScenery method.
```java
public interface BattleOnScenery {

    Integer attackOnScenery(Enemy enemy, Hero hero);
}
```
This method is overrrid in these differents classes and returns differents numbers.

**The differences in each scenery are the methods to change the scenery and the override method attackOnScenery.**

* __River__ 
```java
public class River extends Scenery implements BattleOnScenery {
    ...
    public Scenery changeToDesert() {
        return new Desert(this.getHero(), new Enemy(), new Enemy());
    }

    public Scenery changeToForest() {
        return new Forest(this.getHero(), new Enemy(), new Enemy());
    }

    @Override
    public Integer attackOnScenery(Enemy enemy, Hero hero) {
        return enemy.getLifePoint() - (hero.getAttackPoint() + enemy.getMagicPoint() + enemy.getRiverDamage());
    }
}
```

* __Desert__ 
```java
public class Desert extends Scenery implements BattleOnScenery {
    ...
    public Scenery changeToForest() {
        return new Forest(this.getHero(), new Enemy(), new Enemy());
    }

    public Scenery changeToRiver() {
        return new River(this.getHero(), new Enemy(), new Enemy());
    }

    @Override
    public Integer attackOnScenery(Enemy enemy, Hero hero) {
        return enemy.getLifePoint() - (hero.getAttackPoint() + enemy.getMagicPoint() + enemy.getDesertDamage());
    }
}

```

* __Forest__ 
```java
public class Forest extends Scenery implements BattleOnScenery {
public Scenery changeToDesert() {
    ...
    public Scenery changeToDesert() {
        return new Desert(this.getHero(), new Enemy(), new Enemy());
    }


    public Scenery changeToRiver() {
        return new River(this.getHero(), new Enemy(), new Enemy());
    }

    @Override
    public Integer attackOnScenery(Enemy enemy, Hero hero) {
        return enemy.getLifePoint() - (hero.getAttackPoint() + enemy.getMagicPoint() + enemy.getForestDamage());
    }
}    
```