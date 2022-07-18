package dev.effence.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.effence.mycontacts.databinding.ActivityMainBinding
import dev.effence.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactBinding.inflate(layoutInflater)

        setContentView(binding.root)

        getExtras()
    }
    fun  getExtras(){
        val extras=intent.extras
        val name = extras?.getString("NAME","")
        val email= extras?.getString("EMAIL","")
        val phone=extras?.getString("PHONENUMBER","")
        val address=extras?.getString("ADDRESS","")
        val image=binding.imgimage
        Toast.makeText(this,"$name:$email:$phone:$address",Toast.LENGTH_LONG).show()
        binding.tvphonenumber.text=phone
        binding.tvmail.text=email
        binding.tvAddress.text=address
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)


    }
}