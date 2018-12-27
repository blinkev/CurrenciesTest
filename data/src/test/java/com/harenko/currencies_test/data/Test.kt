package com.harenko.currencies_test.data

import org.junit.Test
import java.math.BigDecimal
import java.math.RoundingMode

class Test {

    @Test
    fun test() {
        println(BigDecimal(0.1288).setScale(2, RoundingMode.DOWN).toString().replace(".", ","))
    }
}