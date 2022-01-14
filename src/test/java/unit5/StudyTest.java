package unit5;

import jdk.jfr.Enabled;
import junit5.Study;
import junit5.StudyStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * packageName : unit5
 * fileName : StudyTest
 * author : 윤신영
 * date : 2022-01-13
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-13   윤신영     최초 생성
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        // 환경변수 가져오기
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue(true);

        assumingThat("Local".equalsIgnoreCase("Local"),() -> {
            assertTrue(true);
        });
    }

    @Test
    @DisplayName("Assertion")
    void assertion() {

        assertEquals(1, 1, "값이 같지 않음");

        assertNotNull(new Study());

        assertTrue(1 < 2);

        assertAll(
                () -> assertEquals(1, 1, "값이 같지 않음"),
                () -> assertTrue(1 < 2)
        );

        assertThrows(NullPointerException.class, () -> {
           String str = null;
           str.length();
        });

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(90);
        });
    }

    @Test
    @Tag("slow")
    void test() {
    }

    //@FastTest
    @Test
    @Tag("fast")
    void fastTest() {
        System.out.println("fastTest");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void BeforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("AfterAll");
    }

    @AfterEach
    void AfterEach() {
        System.out.println("AfterEach");
    }


}
