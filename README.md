# Java Spring Fundamentals
This is an educational repository aims to provide fundamental information and code samples about Java and mainly focused on Spring Framework. I intent to prepare this repository not only to refresh my knowledge but also for public benefit. So feel free to drop comments about your opinion and any contributions are welcome!

Note that in order to build and run sample codes in this project Java 8 is required.

### Before Start
First of all before we dive into Spring, one should get familiar with some basic programming principals which are highly accepted in Java world and moreover strictly followed in Spring Framework. By this way, I believe this guide will be much more effective and easily understandable. So let's get started on this.
### Object Oriented Programming
One of the most popular programming paradigm is called Object Oriented Programming, generally abbreviated as OOP, suggests that **objects** should be used in computer programs. Objects are special structures in programming contain **data** in forms of their properties, also named as attributes. Besides they contain procedures which are responsible for altering this data. These are mostly called as functions.

Luckily Java was born as an OOP language and provides its high level users many structures formed by objects. Thus we do not need to worry about most of the low level operations. However there are further principals to learn in order to apply OOP correctly. These are widely known as solid principals in programming world. When we say solid they really form the **SOLID**. It is a funny story about that our former computer scientists culminated into a mnemonic acronym for five oop design principles intended to make software designs better and understandable.

#### 1. What are these SOLID principals?
We have five principals each of them stands for each letter **S-O-L-I-D** which are *Single Responsibility Principal, Open Closed Principal, Liskov Substitution Principal, Interface Segregation Principal and Dependency Inversion Principal.*

### SOLID Principals in detail
### Single Responsibility Principal
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
.
.
.
```
So this code seems to start smelling like becoming a god object. Although it looks like a semi-god for now but it definately intends to become bigger in time unless we do not stop it by **refactoring** like:
```java
// registering our manager implementations
ApplicationContext.registerBean(LocalDBLoginManager.class);
ApplicationContext.registerBean(RemoteDBLoginManager.class);
ApplicationContext.registerBean(LdapLoginManager.class);
ApplicationContext.registerBean(SocialLoginManager.class);

// Assuming that a DI mechanism handled internally by application context 
// and returns the right implementation according to login type we need
ILoginManager loginManager = ApplicationContext.getBean(ILoginManager.class);
loginManager.authenticate();
```
### Open Closed Principal
#### 1. What is OCP?
Open Closed Principal in software programming simply means that an ideal software application should be open for extensions but closed for modifications. Doing **modifications** here is thought for changing the existing codes of premade modules, classes, etc. On the other hand, what is mentioned when we say **extensions** is adding new classes, modules or even functions without touching the rest of the code base.

Implications of modification:
* Leads to unexpected bugs, especially in projects which does not have enough test coverage. 
* TODO
 
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
.
.
.
```
Benefits of extensions:
* TODO

#### 2. How the OCP can be used in Java?
TODO: Mention about programming to interface

### Liskov Substitution Principle
In a software, objects should be replaceable with instances of their subtypes without altering.

### Interface Segregation Principle
Interfaces should be separated into many client-specific ones which is better than one general-purpose interface.

### Dependency Inversion Principle
Should prefer depending upon abstract classes rather than concerete ones.

### IOC Containers and Dependecy Injection
#### 1. What are Containers in software?
#### 2. What is IOC Container?
#### 3. What is Dependency Injection?
