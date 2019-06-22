# Spring Framework Fundamentals
This is an educational repository aims to provide fundamental information and code samples about Java and mainly focused on Spring Framework. I intent to prepare this repository not only to refresh my knowledge but also for public benefit. So feel free to drop comments about your opinion and any contributions are welcome!

Note that in order to build and run sample codes in this project Java 8 is required.

### Before Start
First of all before we dive into Spring, one should get familiar with some basic programming principals which are highly accepted in Java world and moreover strictly followed in Spring Framework. By this way, I believe this guide will be much more effective and easily understandable.
### Object Oriented Programming
One of the most popular programming paradigm is called Object Oriented Programming, generally abbreviated as OOP, suggests that **objects** should be used in computer programs. Objects are special structures in programming contain **data** in forms of their properties, also named as attributes. Besides they contain procedures which are responsible for altering this data. These are mostly called as functions.

Luckily Java was born as an OOP language and provides its high level users many structures formed by objects. Thus we do not need to worry about most of the low level operations. However there are further principals to learn in order to apply OOP correctly. These are widely known as solid principals in programming world. When we say solid they really form the **SOLID**. It is a funny story about that our former computer scientists culminated into a mnemonic acronym for five oop design principles intended to make software designs better and understandable.

#### 1. What are these SOLID principals?
We have five principals each of them stands for each letter **S-O-L-I-D** which are *Single Responsibility Principal, Open Closed Principal, Liskov Substitution Principal, Interface Segregation Principal and Dependency Inversion Principal.*

#### Single Responsibility Principal
Single Responsibility Principal in software programming suggests that a class should have only one single responsibility. By this way, one class can only modify one part of the software's specification. Classes trying to handle more than one responsibility will eventually ensue fragility and become impossible to maintain. Thus it is clearly seen that violation of this principal cause us the famous **God Object** anti-pattern.

An example to indicate a violation of single responsibility problem:
```java
/**
 * LoginManager.java
 */
 
if(LoginType.LOCAL_DB.equals(type)){

  // authenticating user from local db 
  
} else if(LoginType.REMOTE_DB.equals(type)){
  
  // authenticating user from remote db 
  
} else if(LoginType.LDAP.equals(type)){
  
  // authenticating user from ldap 
  
} else if(LoginType.SOCIAL.equals(type)){
  
 // authenticating user from social network accounts
  
}
// and this conditional cases can go on...
```
So this code seems to start smelling like becoming a god object. Although it looks like a semi-god for now but it definately intends to become bigger in time unless we do not stop it by **refactoring** like:
```java
// registering our manager implementations
context.registerBean(LocalDBLoginManager.class);
context.registerBean(RemoteDBLoginManager.class);
context.registerBean(LdapLoginManager.class);
context.registerBean(SocialLoginManager.class);

// Assuming that a DI mechanism handled internally by application context 
// and returns the right implementation according to login type we need
ILoginManager loginManager = context.getBean(ILoginManager.class);
loginManager.authenticate();
```
#### Open Closed Principal
#### 1. What is OCP?
Open Closed Principal in software programming simply means that an ideal software application should be open for extensions but closed for modifications. Doing **modifications** here is thought for changing the existing codes of premade modules, classes, etc. On the other hand, what is mentioned when we say **extensions** is adding new classes, modules or even functions without touching the rest of the code base.

Some implications of modification:
* Leads to unexpected bugs, especially in projects which does not have enough test coverage. 
* Increase fragility, decrease maintainability.
* Causes strictly tight modules and classes.
 
A clear example to show a piece of code which will probably need modifications later on:
```java
if(ModificationType.LESS.equals(type)){

  // less modification :)
  
} else if(ModificationType.MEDIUM.equals(type)){
  
  // medium modification :(
  
} else if(ModificationType.QUITE.equals(type)){
  
  // quite a lot modification :O
  
} else if(ModificationType.ENORMOUS.equals(type)){
  
  // vast modification >:O
  
}
// and this conditional cases can go on...
```
One proper solution to this problem is **Chain of Responsibility** pattern which is also a good example for design by extensions, can be achieved like the code below:
```java
// new modifier implementations can be easily added without touching the rest of the code
modifiers.add(new LessModifier());
modifiers.add(new MediumModifier());
modifiers.add(new QuiteModifier());
modifiers.add(new EnormousModifier());

// main part of the code that handles the logic is not affected, 
// actually this part should be in a separete class but left here for exemplary purposes
for(IModifier modifier: modifiers){
  modifier.modify(type);
}
```
#### 2. How the OCP can be used in Java?
One of the best practices is **programming to interface** when it comes to applying OCP into java. Programming to interface means to prefer using interfaces instead of concerete types unless you do not specifically need to. Interfaces are the contracts to expose the behaviour type of our program to the outer world. By the help of well defined interfaces you always have a chance to create new implementations and easily extend your project without affecting the world outside, which technically means adding extension. Hence we can say that interfaces really plays nice with the OCP.

Example to show an advantage of using interfaces over concerete types:
```java
public interface Coffee {
  public void taste();
}

Coffee coffee = new FilterCoffee();

// you taste filter coffee!
coffee.taste();

// After some time we'd like to discover a new taste and changed our coffee formula!
Coffee coffee = new EspressoCoffee();

// now you taste espresso, we do not need to modify the code below!
coffee.taste();
```

#### Liskov Substitution Principle
Liskov Substitution Principle suggests that objects in a software program should be replaceable with the instances of their subtypes without need to change properties of this objects. Another use case of interfaces transpires here, since we need a behavioral similarity between subtypes, also called as **strong behavioral subtyping**. Different behaviours can output different results so we need to group subtypes with the similar behaviour by using interfaces not to break our program's expected output.

An example to demonstrate this problem:
```java
public class Fish {
  public void swim(){
    System.out.println("I'm swimming")
  }
}

public class DeadFish extends Fish {
  public void swim(){
    System.out.println("Cannot swim because I'm dead!")
  }
}

// Assume that we need a fishing pool which every Fish instance should swim.
// However as you can see some instances will not be able to swim because they are dead.
List<Fish> pool = new ArrayList<>();
pool.add(new Fish());
pool.add(new Fish());
pool.add(new DeadFish());

for(Fish fish:pool){
  fish.swim();
}
```
An elegant solution comes with the help of interfaces to discriminate subtypes according to their behaviors:
```java
public interface Alive {
  public void swim();
}

public interface Dead {
  public void sink();
}

public class AliveFish extends Fish implements Alive {
  public void swim(){
    System.out.println("I'm swimming :)");
  }
}

public class DeadFish extends Fish implements Dead {
  public void sink(){
    System.out.println("I'm sinking :(");
  }
}

// So we need only alive fish for our fishing pool. 
// Now we are sure that every Fish instance in our pool can swim!
List<Alive> pool = new ArrayList<>();
pool.add(new AliveFish());
pool.add(new AliveFish());
pool.add(new AliveFish());

for(Fish fish:pool){
  fish.swim();
}
```

#### Interface Segregation Principle
Interface Segregation Principle in a software simply tells us that instead of one general-purpose interface, it is better to use many client-specific ones. One obvious problem we can encounter when we violate this principal is the boilerplate invasion of meaningless, empty methods.

Let us show this problem with an example:
```java
public interface Animal {
  
  public void swim();
  
  public void fly();
  
  public void run();
  
}

public class SwimmingAnimal implements Animal {

  public void swim(){
    System.out.println("Oh it's swimming, I know how to swim :)");
  }
  
  /*
   * Ideally we do not need to implement the methods below
   */
  public void fly(){
    System.out.println("What am i going to do?");
  }
  
  public void run(){
    System.out.println("What am i going to do?");
  }
  
}
```
And the solution would be splitting our general interface into more specific ones such as:
```java
public interface CanSwim extends Animal {
  public void swim();
}

public interface CanFly extends Animal {
  public void fly();
}

public interface CanRun extends Animal {
  public void run();
}

// no need to implement unnecessary methods 
public class SwimmingAnimal implements CanSwim {
  public void swim(){
    System.out.println("Oh it's swimming, I know how to swim :)");
  }
}
```

#### Dependency Inversion Principle
Dependency Inversion Principle states that in a software program high level objects should not depend on low level objects on the contrary both should depend abstractions. Not unlike, concerete classes should depend on abstractions not vice versa. After these abstract explanations let us be a little bit more exemplery.

An example of a DIP violation:
```java
public class OperatingSystem {
  
  private HttpService httpService = new HttpService();
  private SmtpService smtpService = new SmtpService();
  
  public void runOnStartup() {
    httpService.startHttpd();
    smtpService.startSmtpd();
  }
}
```
Instead of depending concerete ones we should definately make an abstraction by the help of interfaces and refactor our tiny operating system to accept only abstract services in order to initiate on os start up. See the code below:
```java
public class HttpService implements IService {
  public void start(){
    System.out.println("Starting httpd service...");
  }
}

public class SmtpService implements IService {
  public void start(){
    System.out.println("Starting smtpd service...");
  }
}

public class OperatingSystem {
  
  private List<IService> services = new ArrayList<>();
  
  public void register(IService service){
    this.services.add(service);
  }
  
  public void runOnStartup() {
    this.services.forEach(s -> s.start());
  }
}
```

After we explained OOP and the solid principals shortly we will go on containers, inversion of control and dependecy injection terms in programming and give some examples how they are used in Spring Framework.
### IOC Containers and Dependecy Injection
#### 1. What are Containers in software?
#### 2. What is IOC Container?
#### 3. What is Dependency Injection?
