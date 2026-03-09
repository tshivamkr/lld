# Java OOP Reference Notes (Deep Revision Guide)

These notes are designed for **quick revision with conceptual clarity**. Each topic includes:

- Definition
- Why the concept exists
- Important rules
- Example
- When it is used in real systems

---

# 1. Class

## Definition
A **class** is a blueprint that defines the structure and behavior of objects.

It describes:

- **State** → fields / variables
- **Behavior** → methods

## Why classes exist
Classes allow developers to model **real world entities** in code.

Examples:

| Real World | Class |
|------|------|
| Car | Car |
| User | User |
| Bank Account | BankAccount |

## Example

```java
class Car {

    String model;
    int speed;

    void accelerate() {
        speed++;
    }
}
```

---

# 2. Object

## Definition
An **object** is a runtime instance of a class.

Objects occupy memory and contain actual values.

## Example

```java
Car car = new Car();
car.model = "Tesla";
```

Here:

```
Class → blueprint
Object → actual entity
```

Multiple objects can be created from one class.

---

# 3. Encapsulation

## Definition
Encapsulation means **restricting direct access to object data and exposing controlled access through methods**.

## Why it exists
Without encapsulation, external code can corrupt object state.

Example problem:

```
balance = -100
```

Encapsulation prevents this.

## Implementation

- Make fields `private`
- Provide getters/setters

## Example

```java
class BankAccount {

    private int balance;

    public void deposit(int amount) {
        if(amount > 0)
            balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
```

## Real System Usage

Encapsulation protects:

- database entities
- domain models
- internal invariants

---

# 4. Inheritance

## Definition
Inheritance allows a class to reuse properties and behavior from another class.

It models an **"is-a" relationship**.

Example:

```
Dog is an Animal
```

## Example

```java
class Animal {

    void eat() {
        System.out.println("Animal eating");
    }
}

class Dog extends Animal {
}
```

Now Dog automatically has `eat()`.

## Benefits

- code reuse
- hierarchy modeling
- polymorphism support

## Problem with excessive inheritance

Deep hierarchies create rigid systems.

Modern systems often prefer **composition over inheritance**.

---

# 5. Polymorphism

## Definition
Polymorphism means **one interface can represent multiple behaviors**.

Example concept:

```
Animal animal = new Dog()
```

The variable type is Animal but behavior is Dog.

---

## Compile Time Polymorphism (Method Overloading)

Compiler decides which method to call.

Example

```java
int add(int a,int b)
int add(int a,int b,int c)
```

---

## Runtime Polymorphism (Method Overriding)

Method call resolved at runtime using **dynamic dispatch**.

Example

```java
Animal a = new Dog();
a.eat();
```

Actual method executed depends on runtime object type.

---

# 6. Abstraction

## Definition
Abstraction hides **implementation complexity** and exposes only **essential behavior**.

Example:

```
Car.start()
```

User doesn't know how engine works internally.

## Achieved Using

- abstract classes
- interfaces

---

# 7. Fields / Instance Variables

Variables defined inside a class but outside methods.

Each object gets its own copy.

Example

```java
class User {

    String name;
    int age;
}
```

---

# 8. Local Variables

Variables declared inside methods.

Scope limited to method execution.

Example

```java
void calculate() {

    int x = 10;
}
```

---

# 9. Static Variables

Static variables belong to **class rather than object**.

All instances share same memory.

Example

```java
class Counter {

    static int count;
}
```

Use cases

- counters
- shared configuration
- caches

---

# 10. Methods

Methods define behavior of objects.

Example

```java
void greet() {

    System.out.println("Hello");
}
```

Methods can access class fields.

---

# 11. Constructors

Constructors initialize objects during creation.

Rules:

- same name as class
- no return type

Example

```java
class User {

    String name;

    User(String name) {
        this.name = name;
    }
}
```

---

# 12. Default Constructor

If no constructor is defined, Java automatically creates one.

Example

```java
User user = new User();
```

---

# 13. Parameterized Constructor

Constructors that accept parameters.

Example

```java
User(String name, int age)
```

Used to initialize objects with specific values.

---

# 14. Constructor Chaining

Calling one constructor from another.

Example

```java
class User {

    User() {
        this("default");
    }

    User(String name) {}
}
```

Useful to avoid duplication.

---

# 15. Access Modifiers

Control visibility of classes and members.

| Modifier | Access Scope |
|------|------|
| private | same class |
| default | same package |
| protected | package + subclasses |
| public | everywhere |

---

# 16. Method Overloading

Multiple methods with same name but different parameter lists.

Example

```java
void print(int x)
void print(String s)
```

Compiler decides which method to call.

---

# 17. Method Overriding

Subclass redefining parent class behavior.

Example

```java
class Dog extends Animal {

    @Override
    void eat() {}
}
```

Rules

- method signature must match
- cannot reduce visibility

---

# 18. Static Methods

Belong to class rather than object.

Example

```java
Math.sqrt(4)
```

Used for

- utility functions
- stateless operations

---

# 19. Final Keyword

Prevents modification.

Three uses

### Final Variable

Value cannot change.

### Final Method

Cannot be overridden.

### Final Class

Cannot be extended.

Example

```
String class is final
```

---

# 20. this Keyword

Refers to current object.

Example

```java
this.name = name;
```

Used to resolve variable shadowing.

---

# 21. super Keyword

Refers to parent class.

Example

```java
super(name);
```

Used to call parent constructors or methods.

---

# 22. Abstract Classes

Abstract classes cannot be instantiated.

They may contain:

- abstract methods
- concrete methods

Example

```java
abstract class Shape {

    abstract double area();
}
```

---

# 23. Interfaces

Interface defines **behavior contract**.

Example

```java
interface Flyable {

    void fly();
}
```

Implemented by

```java
class Bird implements Flyable
```

Advantages

- multiple inheritance
- loose coupling
- plugable architecture

---

# 24. Association

Relationship between two independent objects.

Example

```
Teacher teaches Student
```

Both objects exist independently.

---

# 25. Aggregation

Weak ownership relationship.

Example

```
Department has Employees
```

Employees can exist without department.

---

# 26. Composition

Strong ownership relationship.

Example

```
House has Rooms
```

Rooms cannot exist without house.

---

# 27. Object Class Methods

Every class inherits from `Object`.

Important methods

```
toString()
equals()
hashCode()
clone()
```

These methods are critical when working with collections.

---

# 28. Immutable Objects

Immutable objects cannot change state after creation.

Example

```
String
Integer
LocalDate
```

Rules

- fields final
- no setters
- defensive copying

---

# 29. Inner Classes

Classes declared inside another class.

Types

```
Member Inner Class
Static Nested Class
Anonymous Class
```

Used to logically group classes.

---

# 30. Packages

Packages organize classes into namespaces.

Example

```java
package com.company.project
```

Benefits

- avoid name conflicts
- improve project organization

---

# 31. Enums

Enum represents fixed constants.

Example

```java
enum Direction {

    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

Enums can contain methods and fields.

---

# 32. Exceptions

Java uses exception hierarchy for error handling.

Two types

```
Checked Exception
Unchecked Exception
```

Example

```java
class CustomException extends Exception {}
```

---

# 33. Important Design Principles

## SOLID Principles

Five principles for maintainable OOP design.

## Favor Composition Over Inheritance

Prefer combining objects rather than deep inheritance hierarchies.

## Interface Based Design

Depend on interfaces rather than implementations.

## Dependency Inversion Principle

High level modules should depend on abstractions.

---

# End

