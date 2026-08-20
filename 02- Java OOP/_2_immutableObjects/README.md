# Immutability in Java

## What is Immutability?

An immutable object is an object whose state **cannot be changed after it is created**.

For example:

```java
public static void main(String[] args)
{
	ImmutablePerson person = new ImmutablePerson("Alice", 25, "alice@gmail.com");
}
```

Once `person` is created, its `name`, `age`, and `email` cannot be changed.

If we need different data, we create a **new object** instead.


<br>


## Why use Immutability?

Immutability helps make code:

-   Easier to understand
-   Safer to use
-   More predictable
-   Easier to debug
-   Safer when objects are shared between different parts of an application or threads

The main idea is:

> Don't change the existing object. Create a new one.


<br>


## How to create an Immutable Class

A common immutable class follows these rules:

1.  Make the class **`final`**
2.  Make fields **`private final`**
3.  Set the fields only in the constructor
4.  Don't create `setters`
5.  Return new objects when a change is needed

Example:

```java
public final class Person 
{

    private final String name;
    private final int age;

    public Person(String name, int age) 
    {
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

There are no setters, so the object cannot be modified after creation.


<br>


## `set` vs `with`

This is one of the most important ideas.

### Mutable approach

A mutable class might have:

```java
person.setAge(30);
```

This changes the existing object.

```css
Before:
Person
Age = 25

      ↓ setAge(30)

After:
Person
Age = 30
```

### Immutable approach

An immutable class uses something like:

```java
Person newPerson = person.withAge(30);
```

This creates a new object.

```css
Original:
Person
Age = 25

      ↓ withAge(30)

New object:
Person
Age = 30
```

The original object is still unchanged.


<br>


## The `with` Pattern

A `with` method usually looks like this:

```java
public Person withAge(int newAge) 
{
    return new Person(name, newAge);
}
```

For example:

```java
Person person = new Person("Alice", 25);

Person olderPerson = person.withAge(30);
```

The method effectively does:

```java
return new Person("Alice", 30);
```

So we now have two objects:

```css
person:
name = Alice
age  = 25

olderPerson:
name = Alice
age  = 30
```

The original object was never changed.


<br>


## Real-World Example: Rental Contract

A rental contract is a good example of immutability.

```java
RentalContract contract =
        new RentalContract(
                "Alice",
                "Helsinki Street 10",
                LocalDate.of(2026, 9, 1),
                12,
                1000
        );
```

If we want to change the rent:

```java
RentalContract newContract = contract.withMonthlyRent(1200);
```

We don't modify the original contract.

Instead:

```java
Original Contract
-----------------
Tenant: Alice
Rent:   1000

        ↓ withMonthlyRent(1200)

New Contract
------------
Tenant: Alice
Rent:   1200
```

The original contract is still available and unchanged.

This can be useful when we want to keep the original state or avoid unexpected changes.


<br>


## Another Real-World Example: Money

Money is another good example.

Instead of changing a money object: 

```java
money.setAmount(150);  ❌
```

we can create a new value: 

```java
Money newMoney = money.add(50); ✅
```

For example:

```css
Original:
$100

      ↓ add(50)

New:
$150
```

The original **`$100`** object remains unchanged.




<br>



## Immutability and Date/Time

Java's modern date/time API is a good real-world example.

For example:

```java
LocalDate today = LocalDate.now();

LocalDate tomorrow = today.plusDays(1);
```

**`plusDays()`** does not change **`today`**.

Instead, it returns a new **`LocalDate`**.

```java
today
2026-08-20

      ↓ plusDays(1)

tomorrow
2026-08-21
```

This follows the same idea as:

```java
person.withAge(30);
```


<br>


## Why `final`?

Consider:

```java
private final String name;
```

`final` means that after the field receives its value, it cannot be assigned another value.

For example:

```java
this.name = name;
```

is allowed in the constructor.

But later:

```java
this.name = "Bob";
```

is not allowed.

This helps us keep the object's state unchanged.

----------




## What about Setters?

An immutable class should not have setters such as:

```java
public void setName(String name) 
{
    this.name = name;
}
```

A setter changes the existing object.

Instead, use a method that returns a new object:

```java
public Person withName(String newName) 
{
    return new Person(newName, age);
}
```


<br>


## Immutability with Objects

**`final`** fields are not always enough when a field contains a mutable object.

For example:

```java
private final List<String> items;
```

The reference cannot be changed, but the list itself might still be modified:

```java
items.add("Phone");
```

For collections, immutable classes often need **defensive copying** or immutable collections.

For example:

```java
this.items = List.copyOf(items);
```

And when returning the list:

```java
public List<String> getItems() 
{
    return items;
}
```

`List.copyOf()` helps prevent external code from modifying the internal collection.


<br>


## When is Immutability Useful?

Immutability is especially useful for:

-   Configuration objects
-   DTOs and request/response objects
-   Value objects
-   Money and financial values
-   Date and time values
-   Objects shared between multiple parts of an application
-   Multithreaded applications

It is not necessary to make every class immutable.

The important question is:

> Should this object's state be allowed to change?

If the answer is no, immutability can be a very good choice.


<br>


## Quick Comparison




| Mutable| Immutable| 
|---|---|
|  Object can change 	|  Object cannot change  | 
|  Often uses setters	|  No setters	| 
|  `setAge(30)` |  `withAge(30)`	|
|  Modifies existing object |   Creates a new object |
|  Can be harder to track changes  |  Easier to reason about |



