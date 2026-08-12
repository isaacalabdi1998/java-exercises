# Null Pointer & Optionals in Java


## 1. What is Null Pointer

A **NullPointerException (NPE)** happens when you try to use an object reference that is **`null`**.

```java
public static void main(String[] args)
{
	String name = null;
	System.out.println(name.length()); // NullPointerException


	// or
	String brand = null;  
	System.out.println(brand.toUpperCase()); // Cannot invoke "String.toUpperCase()" because "brand" is null
}
```
<br>


```markdown
> [!WARNING]
> Avoiding NullPointerException.
> Check for `null` before using the object:
```


```java
public static void main(String[] args)
{
	if (name != null) 
	{ 
		System.out.println(name.length()); 
	}
}
```


```markdown
> [!TIP]
> However, Java provides `Optional` as a cleaner way to represent a value that may or may not exist.
```


<br>


## 2. Optional

**`Optional<T>`** is a container that can hold:

-   A value
-   No value (`empty`)

<br>

It coulde be....
- Optional`<String>`...
- Optional`<Integer>`...
- Optional`<LocalDate>`...



```java
public static void main(String[] args)
{
	Optional<String> name = Optional.of("Isaac");
}
```

Think of it as:

```
Optional<String>
    ├── value
    └── empty
```
<br>

### 2.1. `Optional.of()`




Use **`of()`** when you **know the value is NOT null**.

```java
Optional<String> name = Optional.of("John");
```

If the value is `null`, it throws `NullPointerException`:

```java
public static void main(String[] args)
{
	String name = null;
	Optional<String> optional = Optional.of(name);  // NullPointerException
}
```

```markdown
> [!IMPORTANT]
> Optional.of(value); // value must NOT be null
```

<br>



### 2.2 `Optional.ofNullable()`


Use `ofNullable()` when the value **might be null**.

```java
public static void main(String[] args)
{
	String name = null; 
	Optional<String> optional = Optional.ofNullable(name);
}
```



Example:

```java
public static void main(String[] args)
{
	String name = getName();
	Optional<String> optionalName = Optional.ofNullable(name);
}
```


```markdown
> [!IMPORTANT]
> Optional.ofNullable(value);
> Use this when you are **not sure whether the value is null**.
```

<br>
<br>

### 2.3 `Optional.empty()`


Creates an `Optional` with **no value**.
Optional<String> name = Optional.empty();
It is equivalent to:
```
Optional<String>
       ↓
    no value
```
You can use it when you intentionally want to return "nothing":

```java
public Optional<String> findName() 
{ 
	return Optional.empty(); 
}
```

<br>

## 3. Quick Comparison


| Method| Null allowed?| Result|
|---|---|---|
| Optional.empty() |  —  | Always empty |
| Optional.of(value) | ❌ No |  Contains value
| Optional.ofNullable(value) | ✅ Yes | Value or empty
---

### Remember
```java
Optional.of("Java"); // value must exist 
Optional.empty();    // no value
Optional.ofNullable(value); // value may be null 
```

<br>



## 4. Checking an Optional

### `isPresent()`


Checks whether a value exists.
```java
if (optionalName.isPresent()) 
{
    System.out.println(optionalName.get());  
    // if a value is present, returns the value.
}
```


### `isEmpty()`

Checks whether there is no value.

```java
if (optionalName.isEmpty()) 
{
    System.out.println("No name");
}
```


> **`isEmpty()`** is available since Java 11.

<br>

## 5. Getting a Value Safely


### `orElse()`

Provides a default value if the `Optional` is empty.

```java
String name = Optional.ofNullable(null).orElse("Unknown");
```

Result:
```
Unknown
```
<br>

### `orElseGet()`

Creates the default value only when needed.

```java
String name = Optional.ofNullable(null).orElseGet(() -> "Unknown");
```

<br>

### `orElseThrow()`

Throws an exception if the value is missing.

```java
String name = Optional.ofNullable(null).orElseThrow();
```



<br>


## 6. Best Practice


Use:

```java
Optional.of(value);
```

when you **guarantee**  `value` is not null.


<br>
Use:

```java
Optional.ofNullable(value);
```

when `value`  **may be null**.


<br>
Use:

```java
Optional.empty();
```

when you intentionally want to represent **no value**.

<br>

### The main idea

```
null
 ↓
can cause NullPointerException

Optional
 ↓
represents "value or no value" explicitly
```

**Quick memory rule:**

> **`of()`** = definitely a value  
> **`ofNullable()`** = maybe a value  
> **`empty()`** = no value
