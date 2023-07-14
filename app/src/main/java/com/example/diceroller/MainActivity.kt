package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.diceroller.databinding.ActivityMainBinding
import kotlinx.coroutines.Runnable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnroll.setOnClickListener {

                rollDice()

            }
        }
    }

    private fun getRandomDiceİmage():Int{

        return when((1..6).random()){
            1->R.drawable.dice1
            2->R.drawable.dice2
            3->R.drawable.dice3
            4->R.drawable.dice4
            5->R.drawable.dice5

            else -> R.drawable.dice6
        }
    }



    private fun rollDice(){
        binding.apply {
            btnroll.isEnabled=false

            val diceRoller=object:Runnable{
                var counter=0
                override fun run() {
                    counter++
                    if(counter>10){

                        diceimg.setImageResource(getRandomDiceİmage())
                        btnroll.isEnabled
                    }
                    else{
                        diceimg.setImageResource(getRandomDiceİmage())
                        Handler(Looper.getMainLooper()).postDelayed(this,100)
                    }
                    TODO("Not yet implemented")
                }
            }
            Handler(Looper.getMainLooper()).postDelayed(diceRoller,0)
        }
    }

}