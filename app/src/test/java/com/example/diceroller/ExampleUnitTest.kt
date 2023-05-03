package com.example.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    //test functions must be annotated with the @Test
    //the annotation seems like a metadata tags for pieces of code that change the way the code is compiled.
    //The annotation lets the compiler know that the following method is a test,
    @Test
//    fun addition_isCorrect() {
//        assertEquals(5, 2 + 3)
//    }

    //Create generate_number function
    fun generates_number() {
        val dice = Dice(6)
        val rollResult = dice.roll1()

        //This method takes two parameters: a String and a Boolean. If the assertion fails, the string
        // is a message to display in the console. The Boolean is a conditional statement.
        assertTrue("The value of rollResult was not between 1 and 6", rollResult in 1..6)
    }
}