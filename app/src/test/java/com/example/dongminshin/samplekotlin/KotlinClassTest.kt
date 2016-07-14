package com.example.dongminshin.samplekotlin

import org.junit.Test

/**
 * Created by DongMinShin on 16. 6. 26..
 */
class KotlinClassTest {

    // interface members are 'open' by default
    interface KotlinInterface {
        fun a()
        fun b() {
            println("call b() by ${KotlinInterface::class.java}")
        }
    }

    class KotlinImplements : KotlinInterface {
        override fun a() {
            println("call a() by ${KotlinImplements::class.java}")
        }
    }

    @Test
    fun interface_test() {
        KotlinImplements().a()
        KotlinImplements().b()
    }

    open class KotlinOpen {
        open fun c() {
            println("call c() by ${KotlinOpen::class.java}")
        }

        fun d() {
            println("call d() by ${KotlinOpen::class.java}")
        }

        open fun e() {
            println("call e() by ${KotlinOpen::class.java}")
        }
    }

    class KotlinExtendsNoOverriding : KotlinOpen() {
    }

    class KotlinExtendsOverriding : KotlinOpen() {
        override fun c() {
            super.c()
            println("override c() call by ${KotlinExtendsOverriding::class.java}")
        }
    }

    @Test
    fun open_test() {
        KotlinExtendsNoOverriding().c()
        KotlinExtendsNoOverriding().d()

        KotlinExtendsOverriding().c()
        KotlinExtendsOverriding().d()
    }

    abstract class KotlinAbstract : KotlinOpen() {
        override fun c() {
            super.c()
            println("override c() call by ${KotlinAbstract::class.java}")
        }

        override abstract fun e()
    }

    abstract class KotlinAbstractB : KotlinOpen() {
        override fun c() {
            super.c()
            println("override c() call by ${KotlinAbstract::class.java}")
        }

        override abstract fun e()
    }

    class KotlinExtendsAbstractClass : KotlinAbstract() {
        override fun e() {
            println("override e() call by ${KotlinExtendsAbstractClass::class.java}")
        }

        override fun c() {
            super.c()
            println("override c() call by ${KotlinExtendsAbstractClass::class.java}")
        }
    }

    @Test
    fun abstract_test() {
        KotlinExtendsAbstractClass().c()
        KotlinExtendsAbstractClass().d()
        KotlinExtendsAbstractClass().e()
    }
}