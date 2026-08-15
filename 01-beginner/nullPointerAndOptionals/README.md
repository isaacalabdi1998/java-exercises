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

> [!WARNING]
> Avoiding NullPointerException.
> Check for `null` before using the object.


```java
public static void main(String[] args)
{
	if (name != null) 
	{ 
		System.out.println(name.length()); 
	}
}
```
<br>

> [!TIP]
> However, Java provides `Optional` as a cleaner way to represent a value that may or may not exist.

<br>



## 2. Declare & initialize Optional


**`Optional<T>`**  

 Where **T** the type of data
- Optional `<String>` ...
- Optional `<Integer>` ...
- Optional `<Double>` ...
- Optional `<LocalDate>`...
	




### There are 3 Optional  static methods should use when declare an `Optional`
```java
1- Optional.of()
2- Optional.ofNullable()
3- Optional.empty()
```

<br>

**1-**  Use **`of()`** when you know the value is **not null**.

```js
/*------- true way -------*/
String  name1  =  "i love java";
Optional<String> opt1 = Optional.of(name1);


/* ----- wrong way ---------*/
String name2 = null;
Optional<String> opt2 = Optional.of(name2);  // NullPointerException
```

> [!WARNING]
> If the value is `null`, it throws `NullPointerException`:


> [!CAUTION]
> `Optional.of(value);`   value must NOT be null

<br>




**2-**  Use **`ofNullable()`** when the value **might be null**.

```js
 String name = null;
 Optional<String> opt= Optional.ofNullable(name);
 
 System.out.println(opt.isEmpty()); // true
```

> [!IMPORTANT]
> Optional.ofNullable(value);
> Use this when you are **not sure whether the value is null**.


<br>



**3-**  Use **`empty()`**  when need to create `Optional` with **no value**.

```java
Optional<String> empty = Optional.empty();
```


<br>


## 3. Important Methods in Optional


 **`isPresent()`**
 
If a value is present, returns `true`, otherwise `false`.

<br>

**`isEmpty()`**
Checks whether there is no value.

<br>

**`get()`**
If a value is present, returns the value.

> [!WARNING]
> throws `NoSuchElementException` if a value is not present.


<br>

**`orElse()`**
Provides a default value if the `Optional` is empty.


```js
String nullName = null;  
String name = Optional.ofNullable(nullName).orElse("java-8");  
  
System.out.println(name);  
/* Output:   java-8   */
```

<br>

**`orElseThrow()`**

Throws an exception if the value is missing.
If a value is present, returns the value, otherwise throws `NoSuchElementException`

```js
String nullName = null;  
String name = Optional.ofNullable(nullName).orElseThrow();
```


> [!WARNING]
> throws `NoSuchElementException` if a value is not present.



<br>
<br>


## 4. Quick Comparison




| Method| Null allowed?| Result|
|---|---|---|
| Optional.**of(`value`)** | ❌ No   | Contains value |
| Optional.**ofNullable(`value`)** | ✅ Yes |  Value or empty
| Optional.**empty()**  | — | Always empty


<br>
<br>
