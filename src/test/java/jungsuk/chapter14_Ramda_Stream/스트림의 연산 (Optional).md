---
title: 스트림의 연산 (Optional)
created: '2021-11-16T03:22:17.841Z'
modified: '2021-11-16T05:04:42.152Z'
---

# 스트림의 연산 (Optional)

• 스트림의 다양한 연산을 이용해서 복잡한 작업들을 간단히 처리할수 있다.   
• 데이터베이스의 `SELECT`문과 비슷하다.

>스트림에 정의된 메서드 중에서 데이터 소스를 다루는 작업을 수행하는 것을 연산(openration) 이라고 한다.

• 스트림이 제공하는 연산은 `1.중간연산`과 `2.최종연산`으로 분류한다.  
• 🔥 `1.중간연산`은 연산결과를 스트림으로 반환해서 연속해서 연결할 수 있다.  
• 🔥 `2.최종연산`은 스트림의 요솔를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.

---

## 📁 Optional<T>
• `Optional<T>`은 'T타입의 객체'를 감싸는 래퍼 클래스이다.
• `Optional`타입의 객체에는 모든타입의 객체를 담을수 있다.

>JDK 1.8부터 추가되었다.

```java
public final class Optional<T> {

    private final T value;

    // ...    
}
```

• 최종 연산의 결과를 그냥 반환하는게 아니라 `Optional` 객체에 담아서 반환을 하면, 반환된 결과가 `null`인지 매번 `if`문으로 체크하는 대신 `Optional`에 정의된 메서드를 통해서 간단히 처리할 수 있다.
• 🔥 `Optional<T>`를 이용하면, 널 체크를 위한 if문 없이도 `NullPointException`이 발생하지 않는 보다 간결하고 안전한 코드를 작성하는 것이 가능하다.

---

## 📁 Optional<T>객체 생성하기
• 🔥 `Optional`객체를 생성할 떄는 `of()` 또는 `ofNullable()`을 사용한다.
• 참조변수의 값이 null일 가능성이 있으면, `of()` 대신 `ofNullable()`을 사용해야한다. `of()`는 매개변수 값이 null 이면 `NullPointException`이 발생한다.

```java
String str = "abc";
Optional<String> optVal = Optional.of(str);
Optional<String> optVal2 = Optional.of("abc");
// 참조변수의 값이 null일 가능성이 있으면, of() 대신 ofNullable()을 사용해야한다.
Optional<String> optVal3 = Optional.ofNullable(null);
```

• `Optional<T>`타입의 참조변수를 기본값으로 초기화 할때는 `empty()`를 사용한다. null로 초기화가 가능하지만 `empty()`가 바람직하다.

```java
Optional<String> optVal = Optional.of("abc");
optVal = Optional.<String>empty();
```

## 📁 Optional<T>객체의 값 가져오기
• `get()` 함수를 사용한다.
• 값이 null 일때는 `NoSuchElementException`이 발생하며, 이를 대비해서 `orElse()`로 대체할 값을 지정할 수 있다.

```java
Optional<String> optVal = Optional.of("abc");
Optional<String> optVal3 = Optional.ofNullable(null);
String str1 = optVal.get();     // null이면 예외발생
String str3 = optVal3.orElse("empty");    //  null일경우, empty 반환
```

• `orElseGet()` : null을 대체할 값을 반환하는 람다식을 지정할 수 있다.
• `orElseThrow()` :  null일때 지정된 예외를 발생시킴

```java
String str4 = optVal3.orElseGet(String::new);   // null이면 new String();
String str5 = optVal3.orElseThrow(NullPointerException::new);   // null 이면 예외 발생
```

• `isPresent()` : `Optional`객체의 값이 null이면 `false`를, 아니면 `true`를 반환한다. 
• `ifPresent(Consumer<T> block)` : `Optional`객체의 값이 null이면 아무일도 하지 않고, 아니면 주어진 람다식을 실행한다.

---

## 📁 OptionalInt, OptionalLong, OptionalDouble
• `IntStream`과 같은 기본형 스트림의 최종 연산의 일부는 `Optional` 대신 `OptionalInt`,`OptionalLong`, `OptionalDouble`을 반환한다.
• 반환타입이 객체가 아니라, 기본형 자료형인것만 다르고 나머지는 `Optional`과 똑같다.

```java
OptionalInt optionalInt = OptionalInt.of(0);
OptionalInt optionalInt2 = OptionalInt.of(123);
OptionalInt optionalInt3 = OptionalInt.empty();

System.out.println(optionalInt2.getAsInt());
System.out.println(optionalInt.isPresent());
System.out.println(optionalInt.orElse(1234));
System.out.println(optionalInt3.orElse(1234));
```






