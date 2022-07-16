package dev.effence.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.effence.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContact()

    }
    fun displayContact(){
        var contact1=Contact("Abby","07234565","abbu@gmail.com","78d","https://img.67896789freepik.com/free-photo/photo-shocked-woman-with-afro-haircut-holds-lips-curious-emotions_273609-17453.jpg?t=st=1657948302~exp=1657948902~hmac=035dd9c1737da55dfc8aa2d2cf70627c795de467aaec0c70bf9df4189f1c911f&w=740")
        var contact2=Contact("Bem","07234565","ben@gmail.com","78d","https://img.freepik.com/premium-photo/african-american-business-women-are-using-laptops-work-office-black-people_369024-32.jpg?w=740")
        var contact3=Contact("Christine","07234565","chri@gmail.com","78d","https://img.freepik.com/free-photo/portrait-young-afro-american-latin-woman-listening-music-with-headphones-street-outdoors_58466-11830.jpg?size=626&ext=jpg&uid=R64942783&ga=GA1.2.1993557071.1654705356")

        var contactlist=listOf(contact1,contact2,contact3)
        var contactsAdapter= ContactRvAdapter(contactlist)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter


    }
}