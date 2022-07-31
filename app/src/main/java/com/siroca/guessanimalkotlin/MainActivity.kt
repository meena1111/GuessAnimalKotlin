package com.siroca.guessanimalkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.siroca.guessanimalkotlin.databinding.ActivityMainBinding
import com.siroca.guessanimalkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var isGiraffe = false
    var isCat = false
    var isDog = false
    private var nameAnimal = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnDog.setOnClickListener {
                binding.ivCapture.setImageResource(R.drawable.dog_cute)
                isGiraffe = false
                isDog = true
                isCat = false
                nameAnimal = "Dog"
            }
            btnCat.setOnClickListener {
                ivCapture.setImageResource(R.drawable.cat)
                isGiraffe = false
                isDog = false
                isCat = true
                nameAnimal = "Cat"
            }

            btnGiraffe.setOnClickListener {
                binding.ivCapture.setImageResource(R.drawable.giraffe)
                isGiraffe = true
                isDog = false
                isCat = false
                nameAnimal = "Giraffe"
            }

            btnThatDog.setOnClickListener {
                if (isDog) {
                    Toast.makeText(applicationContext, "Верно", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Неверно", Toast.LENGTH_LONG).show()
                }
            }

            btnThatCat.setOnClickListener {
                if (isCat) {
                    Toast.makeText(applicationContext, "Верно", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Неверно", Toast.LENGTH_LONG).show()
                }
            }

            btnThatGiraffe.setOnClickListener {
                if (isGiraffe) {
                    Toast.makeText(applicationContext, "Верно", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Неверно", Toast.LENGTH_LONG).show()
                }
            }

            btnSend.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("key", nameAnimal)
                startActivity(intent)
            }
        }
    }
}
