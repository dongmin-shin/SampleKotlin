package com.example.dongminshin.samplekotlin.chapter.chapter28;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by DongMinShin on 16. 8. 4..
 */
public class Chapter28JavaTest {

    private static int coc = 3;

    static class OuterJava {
        private int bar = 1;

        static class NestedJava {
            static int foo() {
                return 2;
            }
        }
    }

    static class OuterJavaWithInner {
        private static int bar = 1;

        static class InnerJava {
            int foo() {
                return bar;
            }

            int test() {
                return coc;
            }
        }
    }

    @Test
    public void test_outer_java() {
        // 접근 불가
//        Chapter28KotlinTest.OuterKotlin.NestedKotlin()

        // Static 로 선언해줘야 외부에서 접근 가능
        int result = OuterJava.NestedJava.foo();
        assertEquals(result, 2);
    }

    @Test
    public void test_inner_java() {
        OuterJavaWithInner.InnerJava innerJava = new OuterJavaWithInner.InnerJava();
        assertEquals(innerJava.foo(), 1);
        assertEquals(innerJava.test(), 3);
    }

}
