## **Game Tutorial**

In this assignment, about my internship program, was solicited that I build a backend of a kind of RPG game, using many concepts of object-oriented programming, and it will be explained by steps.

To do these tasks I needed to build two kind of heroes and different enemies. All these could attack and defend, but some has special attacks and the heroes can use equipments to improve your attack or protect yourself. The battle are started in one kind of scenery, and it's possible move between them. 

## __Building a character__
To build an enemy, a warrior and a wizard, was created a Persona class. This class is responsible to is assigning the lifePoint, attackPoint and defensePoint. It's possible see it in Hero class too, that is a parent class and extends your attributes and methods to Warrior and Wizard class.That is, was used inheritance, because the classes Enemy and Hero, acquires all the properties of a Persona class and after, the classes Wizard and Warrior, acquires all the properties and behaviors of a Hero class, in order not to repeat code and take advantage of attributes and methods to the child class. It's possible see it in this code below. 

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

### __Creating an Enemy__

As enemy extends Persona, it has all attributes and more your own attribute that is 
```java
public class Enemy extends Persona {

    private Integer magicPoint;
    private Integer desertDamage;
    private Integer forestDamage;
    private Integer riverDamage;
    ...
```

There are two options to create an enemy, one is by a random points and another is using an EnemyEnum, that has a three kind of enemies

#### **Random points**
```java
    public Enemy(Random random) {
        super(random.nextInt((80 - 70) + 1) + 70, random.nextInt((15 - 10) + 1) + 10, random.nextInt((8 - 3) + 1) + 3);
    }
```
#### **By EnemyEnum**
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
In this case, was passed as argument in Enemy constructor a kind of EnemyEnum and depending on the argument these four methods magicPointDamage(), attackPointOnDesert(), attackPointOnForest() and attackPointOnRiver() returns different numbers, that is the same action in different ways. That is called polymorphism, when one task is performed in different way. 

### __Creating an Equipment__

Initially, was declared an abstract method to be overridden in each enum and return different numbers.
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
To build equipment was necessary an EquipmentsEnum, improveDamage, reduceDamage and inventorySpace.Was used polymorphism when one task is performed in different way, like in this code bellow 
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
In this case, was passed as argument on Equipment constructor a kind of EquipmentEnum and depending on the argument  these three methods improveDamage(), reduceDamage() and inventorySpace() returns different numbers, that is the same action in many ways. 

### __Creating a Warrior or a Wizard__

As Warrior and Wizard extends Hero, it has all attributes and more your own methods.
#### __Wizard__ 

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

#### **Before**
In oldest way to use this function is passing as argument a hero, that can be a Wizard or a Warrior, and when this function was called, the user choose what kind of hero it wants.
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

#### __Warrior__ 

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

## __Building a Scenery__

To build a scenery, it's necessary a Hero, and two kind of enemies. The Scenery class is abstract and only is possible instantiate a River, Desert or Forest. 

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
### __BattleOnScenery Interface__

It's possible see in this interface which attackOnScenery method.
```java
public interface BattleOnScenery {

    Integer attackOnScenery(Enemy enemy, Hero hero);
}
```
This method is override in these different classes and returns different numbers.

**The differences in each scenery are the methods to change the scenery and the override method attackOnScenery.**

#### __River__ 
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

#### __Desert__ 
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

#### __Forest__ 
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

## __JUnit 5 Tests__

JUnit is an open-source framework,that is a Java unit testing framework, and it is used to write and run repeatable automated tests.

Before, it's important to know about JUnit annotations and methods.

### **@Test**

Tells JUnit what a class's test methods are.

### **@BeforeEach**

Starts before all tests the method that contains this annotation.

### **@DisplayName**

Shows the test method name in more detail.

### **@Description**

Shows a short description of the test method.

### **Assertions**

Is a collection of methods that assert whether certain common test conditions match what is expected. Was used __*Assertions.assertAll()*__ to test more than one method in the same time and __*assertEquals()*__ to test the method through an expected result.

### __Testing a hero__

To test a Warrior or a Wizard, it's the same, but the expected results are different.
WizardTest has all tests than WarriorTest and shouldAttackNewEnemy(). 
```java
class WizardTest {

    private Wizard wizard;
    private Enemy enemy1, enemy2, dragon, goblin, zombie;

    @BeforeEach
    public void start() {
        Random random = new Random();
        this.wizard = new Wizard(null);
        this.dragon = new Enemy(EnemyEnum.DRAGON);
        this.goblin = new Enemy(EnemyEnum.GOBLIN);
        this.zombie = new Enemy(EnemyEnum.ZOMBIE);
        this.enemy1 = new Enemy(random);
        this.enemy2 = new Enemy(random);
    }

    @Test
    public void shouldAttackEnemy() 
        Assertions.assertAll(() -> assertEquals(80, wizard.attackEnemy(enemy1)),
                             () -> assertEquals(80, wizard.attackEnemy(enemy2)));
    }

    @Test
    public void shouldDefendTheEnemyAttack() {
        Assertions.assertAll(() -> assertEquals(80, wizard.defendFromEnemy(enemy1)),
                             () -> assertEquals(80, wizard.defendFromEnemy(enemy2)));
    }
    
    @Test
    public void shouldAttackEnemyWithPotion() {
        Assertions.assertAll(() -> assertEquals(80, wizard.usePotions(enemy1)),
                             () -> assertEquals(80, wizard.usePotions(enemy2)));
    }

    @Test
    public void shouldAttackNewEnemy() {
        Assertions.assertAll(() -> assertEquals(67, wizard.attackUsingMagic(dragon)),
                             () -> assertEquals(62, wizard.attackUsingMagic(goblin)),
                             () -> assertEquals(58, wizard.attackUsingMagic(zombie)));
    }
}
```

In other words, all these tests should do something, and that's it what it does. If some test isn't equal than expected, an error is shown and the real expected result too. 

### __Testing an enemy__

Here, as the enemy points are random, it's impossible previously know the real expected result, only after the test, and then, it's possible calculate to know it's working very well.

```java
    @Test
    public void shouldAttackPersona() {
        Assertions.assertAll(() -> assertEquals(80, enemy1.attackHero(this.hero)),
                             () -> assertEquals(90, enemy2.attackHero(this.hero)));
    }

    @Test
    public void shouldDefendTheEPersonaAttack() {
        Assertions.assertAll(() -> assertEquals(80, enemy1.defend()),
                             () -> assertEquals(80, enemy2.defend()));
    }
```
### __Testing an equipment__

In this test class, was tested if the equipment improve damage, reduce damage and take up space in the inventory.

```java
class EquipmentTest {
    ...
    @Test
    public void shouldImproveDamage() {
        Assertions.assertAll(() -> assertEquals(0, armor.getImproveDamage()),
                             () -> assertEquals(8, sword.getImproveDamage()),
                             () -> assertEquals(12, archery.getImproveDamage()));
    }

    @Test
    public void shouldReduceDamage() {
        Assertions.assertAll(() -> assertEquals(6, armor.getReduceDamage()),
                             () -> assertEquals(3, sword.getReduceDamage()),
                             () -> assertEquals(0, archery.getReduceDamage()));
    }

    @Test
    public void shouldShowInventorySpace() {
        Assertions.assertAll(() -> assertEquals(4, armor.getInventorySpace()),
                             () -> assertEquals(2, sword.getInventorySpace()),
                             () -> assertEquals(3, archery.getInventorySpace()));
    }
}
```

### __Testing on scenery__
In all sceneries the methods are equals, but the results are different. It's worth remembering that in the forest the dragon has a double attack and this is tested here.

There is the __*shouldChangeToForest()*__ method too, but they are in others sceneries test.

```java
class RiverTest {
    ...
    @Test
    public void shouldChangeToDesert() {
        assertEquals(new Forest(hero, enemy1, enemy2).getHero(), forest.changeToDesert().getHero());
    }

    @Test
    public void shouldChangeToRiver() {
        assertEquals(new River(hero, enemy1, enemy2).getHero(), forest.changeToRiver().getHero());
    }

    @Test
    public void shouldDuplicateDamageOnDragon(){
        Assertions.assertAll(() -> assertEquals(47, forestDragon.attackOnScenery(dragon, hero)),
                             () -> assertEquals(62, forestGoblin.attackOnScenery(goblin, hero)),
                             () -> assertEquals(58, forestZombie.attackOnScenery(zombie, hero)));
    }
}
```
### __Black Box Testing__

This kind of test, that is also known as behavioral testing, is a software testing method in which the functionalities of software applications are tested without having implementation details and internal paths. Black Box Testing mainly focuses on input and output of software applications and it is entirely based on software requirements and specifications. 

|How it works|
|--|
|Initially, the requirements and specifications of the system are examined|
|Tester determines expected outputs for all those inputs|
|Software tester constructs test cases with the selected inputs|
|The test cases are executed|
|Software tester compares the actual outputs with the expected outputs|
|Defects if any are fixed and re-tested|

It's possible see it in GameTest class, that all tests of all classes are putten in same class.

```java
public class GameTest {

    private Wizard hero;
//    private Warrior hero;
    private Enemy enemy1;
    private Enemy enemy2;
    private Forest forest;
    private Desert desert;
    private River river;
    private Equipment archery;
    private Equipment armor;
    private Equipment sword;
    private List<Equipment> equipments = new ArrayList<>();

    @BeforeEach
    public void startEnemy() {
        Random random = new Random();
        this.enemy1 = new Enemy(random);
        this.enemy2 = new Enemy(random);
    }

    @BeforeEach
    public void startSceneryWithPerson() {
        this.hero = new Wizard(null);
//        this.hero = new Warrior(null);
        this.forest = new Forest(this.hero, enemy1, enemy2);
        this.desert = new Desert(this.hero, enemy1, enemy2);
        this.river = new River(this.hero, enemy1, enemy2);
        //Equipments
        this.archery = new Equipment(EquipmentsEnum.ARCHERY);
        this.armor = new Equipment(EquipmentsEnum.ARMOR);
        this.sword = new Equipment(EquipmentsEnum.SWORD);
        equipments.add(archery);
        equipments.add(armor);
        equipments.add(sword);
        hero.setInventory(equipments);
    }
    ...
}
```

Therefore, all classes were instantiated in this test class, so that all tests were executed.

## __Conclusion__

By the end, to build this backend of a little game system it was necessary to know so many contents about java and object orientation programming and to turn it more elegant and professional was used JUnit 5 tool to construct a solid workspace to test all classes. For sure for me was a good way to improve my knowledge and learn more about these techniques.