package jungsuk.chapter14_Ramda_Stream;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;


public class Stream_Optional {

    // Optional
    @Test
    public void Optional_Make () {

        String str = "abc";
        Optional<String> optVal = Optional.of(str);
        Optional<String> optVal2 = Optional.of("abc");

        // 참조변수의 값이 null일 가능성이 있으면, of() 대신 ofNullable()을 사용해야한다.
        // of()는 매개변수 값이 null 이면 NullPointExceptiondl 발생한다.

        Optional<String> optVal3 = Optional.ofNullable(null);
        optVal3 = Optional.<String>empty();

        String str1 = optVal.get();
        System.out.println(str1);
        String str3 = optVal3.orElse("empty");
        System.out.println(str3);

        String str4 = optVal3.orElseGet(String::new);   // null이면 new String();
        System.out.println(str4);
        String str5 = optVal3.orElseThrow(NullPointerException::new);   // null 이면 예외 발생
        System.out.println(str5);
    }

    @Test
    public void Optional_Int () {

        OptionalInt optionalInt = OptionalInt.of(0);
        OptionalInt optionalInt2 = OptionalInt.of(123);
        OptionalInt optionalInt3 = OptionalInt.empty();

        System.out.println(optionalInt2.getAsInt());
        System.out.println(optionalInt.isPresent());
        System.out.println(optionalInt.orElse(1234));
        System.out.println(optionalInt3.orElse(1234));
    }
}
