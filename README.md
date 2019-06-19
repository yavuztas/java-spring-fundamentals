# Java Spring Fundamentals
This is an educational repository aims to provide fundamental information and code samples about Java and mainly focused on Spring Framework. I intent to prepare this repository not only to refresh my knowledge but also for public benefit. So feel free to drop comments about your opinion and any contributions are welcome!

Note that Java 8 is required to build this project. Hope it helps to fellow developers!
### Open Closed Principal
#### 1. What is OCP?
Open Closed Principal in software programming means simply an ideal software application should be open for extensions but closed for modifications. Doing **modifications** here is thought for changing the existing codes of premade modules, classes, etc. On the other hand, what is mentioned when we say **extensions** is adding new classes, modules or even functions without touching the rest of the code base.
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
### IOC Containers and Dependecy Injection
#### 1. What are Containers in software?
#### 2. What is IOC Container?
#### 3. What is Dependency Injection?
