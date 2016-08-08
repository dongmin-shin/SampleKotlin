package com.example.dongminshin.samplekotlin.chapter.chapter28

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by DongMinShin on 16. 8. 4..
 */
class Chapter28KotlinTest {

    /**
     * Outer, Inner 테스트
     */
    class OuterKotlin {
        private val bar: Int = 1

        class NestedKotlin {
//                        fun foo() = bar     // Inner 클래스에서 Outer의 멤버 변수에 접근 불가
            fun foo() = 2
        }
    }

    class OuterKotlinWithInner {
        private val bar: Int = 1

        inner class InnerKotlin {
            fun foo() = bar
        }
    }

    class AccessTestOuterMember {
        private val bar: Int = 1

        class InnerKotlin {
//            fun foo() = bar   // Kotlin 에서는 불가능 but, Java에서는 가능
        }
    }

    @Test
    fun test_outer_kotlin() {
        // NestedKotlin 객체를 만들어서 foo 메소드에 접근
        val result = OuterKotlin.NestedKotlin().foo() // == 2
        assertEquals(result, 2)
    }

    @Test
    fun test_outer_kotlin_with_inner() {
        val outerKotlinWithInner = OuterKotlinWithInner()
        val innerKotlin = outerKotlinWithInner.InnerKotlin()


        // OuterKotlinWithInner 객체를 만든 뒤, InnerKotlin 객체를 다시 만들어서 foo 에 접근
        val result = OuterKotlinWithInner().InnerKotlin().foo()
        assertEquals(result, 1)
    }


    /**
     * Enum 테스트
     */
    enum class Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    enum class HasParameter(val code: Int) {
        UP(10), DOWN(20), LEFT(30), RIGHT(40)
    }

    // Enum 상수들은 내부에 익명 클래스를 선언할 수 있다.
    enum class AnonymousEnums {
        WAITING {
            override fun signal() = TALKING
        },

        TALKING {
            override fun signal() = WAITING
        };

        abstract fun signal(): AnonymousEnums
    }

    @Test
    fun test_enum() {
        assertEquals(Day.SUNDAY.name, "SUNDAY")
        assertEquals(Day.SUNDAY.ordinal, 0)
        assertEquals(Day.SUNDAY.toString(), "SUNDAY")

        assertEquals(HasParameter.UP.code, 10)
        assertEquals(HasParameter.valueOf("UP"), HasParameter.UP)

        val hasParameterList: Array<HasParameter> = HasParameter.values()
        hasParameterList.forEach { println(it) }

        assertEquals(AnonymousEnums.WAITING.signal(), AnonymousEnums.TALKING)
    }

    /**
     * Sealed class 테스트
     */

    sealed class Expr {
        class Const(val number: Double) : Expr()
        class Sum(val e1: Expr, val e2: Expr) : Expr()
        object NotANumber : Expr()
    }

    // 모든 경우를 다루기 때문에 else절이 필요 없다.
    fun eval(expr: Expr): Double = when (expr) {
        is Expr.Const -> expr.number
        is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
        Expr.NotANumber -> Double.NaN
    }

    sealed class Option<out T> {
        class Some<out T> : Option<T>()
        object None : Option<Nothing>()
    }

    @Test
    fun test_sealed_class() {
        val constA = Expr.Const(3.25)
        val constB = Expr.Const(5.10)

        assertEquals(constA.number, 3.25)
        assertEquals(constB.number, 5.10)

        val sealedSum = Expr.Sum(constA, constB)
        println("sealedSum : $sealedSum")

        val option = Option.Some<Int>() ?: Option.None

        val result = when (option) {
            is Option.Some<*> -> "Contains a value"
            is Option.None -> "Empty"
        }

        assertEquals(result, "Contains a value")
    }

    class MyException(message: String?) : Throwable(message) {
    }

    /**
     * Exception Test
     */
    @Test(expected = MyException::class)
    fun test_throw_exception() {
        throw MyException("Exception message")
    }

    @Test
    fun test_try_catch() {
        var message = "ExceptionTest"

        try {
            throw MyException("try-catch exception")
        } catch (exception: MyException) {
            message = exception.message.toString()
            assertEquals(exception.message, "try-catch exception")
        } finally {
            println("Finally : " + message)
        }
    }


}

















