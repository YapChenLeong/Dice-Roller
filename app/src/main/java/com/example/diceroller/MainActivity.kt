package com.example.diceroller

//frameworks of numerous classes
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //onCreate Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Save reference to the button object in a variable called rollButton
        //Resource IDs are of them form R.<type>.<name>; for example R.string.roll
        val rollButton: Button = findViewById(R.id.button)//find the resource ID for the Button

        //Associate with the Button
        rollButton.setOnClickListener {
            //within the curley braces, put instructions for what should happen when the button is tapped.

            rollDice()

            // Create a Toast.makeText() method to display Toast text by calling the show() method.
            val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll1 = dice.roll1()
        val diceRoll2 = dice.roll2()

        // Find the ImageView in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView1)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        // Update the content description
        diceImage1.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)

        val sumOfDice = diceRoll1 + diceRoll2

        resultTextView.text = sumOfDice.toString()

    }
}//end of Main Activity Class

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll1(): Int {
        return (1..numSides).random()
    }
    fun roll2(): Int {
        return (1..numSides).random()
    }
}