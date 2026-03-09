# Java Core & Advanced Concepts Notes

## 1. Method Overriding

Method overriding occurs when a subclass provides a specific
implementation of a method that is already defined in its parent class.

### Rules

-   Method name must be the same
-   Parameters must be the same
-   Return type must be compatible
-   Happens between parent and child classes
-   Resolved at **runtime** (runtime polymorphism)

### Example

``` java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

------------------------------------------------------------------------

## 2. Method Overloading

Method overloading means multiple methods with the same name but
different parameter lists in the same class.

### Rules

Method signature must differ by: - Number of parameters - Type of
parameters - Order of parameters

Return type alone cannot differentiate methods.

### Example

``` java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

------------------------------------------------------------------------

## 3. final Keyword

### final Variable

Value cannot be reassigned.

``` java
final int x = 10;
```

### final Method

Cannot be overridden by subclasses.

``` java
class Parent {
    final void show() {}
}
```

### final Class

Cannot be inherited.

Example:

``` java
final class Utility {}
```

Example from Java: `String` class is final.

------------------------------------------------------------------------

## 4. Method References

A method reference is a shorthand syntax for calling a method using
lambda expressions.

Syntax:

    ClassName::methodName

### Example

``` java
list.forEach(System.out::println);
```

### Types

1.  Reference to static method
2.  Reference to instance method of an object
3.  Reference to instance method of a class
4.  Constructor reference

Example:

``` java
Supplier<List<String>> listSupplier = ArrayList::new;
```

------------------------------------------------------------------------

## 5. Lambda Expressions

Lambda expressions are anonymous functions introduced in Java 8.

Syntax:

    (parameters) -> expression

### Example

``` java
Runnable r = () -> System.out.println("Running");
```

### Functional Interface

Lambda expressions work with interfaces that contain **exactly one
abstract method**.

Example:

``` java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

Calculator c = (a, b) -> a + b;
```

### Common Functional Interfaces

-   Function
-   Predicate
-   Consumer
-   Supplier

Example:

``` java
Predicate<Integer> isEven = x -> x % 2 == 0;
```

------------------------------------------------------------------------

## 6. Immutability

An immutable object cannot be modified after creation.

Example: `String` is immutable.

### Rules to create immutable classes

1.  Declare class as `final`
2.  Make fields `private` and `final`
3.  No setter methods
4.  Initialize fields through constructor
5.  Return defensive copies of mutable objects

### Example

``` java
final class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

Advantages: - Thread safety - Safe caching - Better design

------------------------------------------------------------------------

## 7. Packages

Packages are used to organize Java classes into namespaces.

### Example

``` java
package com.company.service;
```

### Benefits

-   Organizes large projects
-   Avoids class name conflicts
-   Controls access using modifiers

### Rules

1.  Package declaration must be first line in file
2.  Only one package per file
3.  Directory structure must match package name
4.  Package names usually lowercase
5.  Reverse domain naming convention

Example:

    com.company.project

### Built-in Packages

-   java.lang
-   java.util
-   java.io
-   java.time

`java.lang` is imported automatically.

------------------------------------------------------------------------

## 8. Access Modifiers

Access modifiers control visibility of classes, methods, and variables.

### Types

  Modifier    Same Class   Same Package   Subclass   Other Package
  ----------- ------------ -------------- ---------- ---------------
  private     Yes          No             No         No
  default     Yes          Yes            No         No
  protected   Yes          Yes            Yes        No
  public      Yes          Yes            Yes        Yes

### private

Accessible only within same class.

### default

Accessible within same package.

### protected

Accessible within package and subclasses.

### public

Accessible everywhere.

Example:

``` java
public class User {

    private String name;

    public String getName() {
        return name;
    }
}
```

------------------------------------------------------------------------

## 9. Enums

Enum represents a fixed set of constants.

### Example

``` java
enum Status {
    PENDING,
    APPROVED,
    REJECTED
}
```

Usage:

``` java
Status s = Status.APPROVED;
```

### Enum With Fields

``` java
enum Status {

    PENDING(1),
    APPROVED(2),
    REJECTED(3);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
```

### Useful Methods

-   `values()`
-   `valueOf()`
-   `ordinal()`

### Example

``` java
for (Day d : Day.values()) {
    System.out.println(d);
}
```

### Important Rule

Enum constructors are **implicitly private**.
