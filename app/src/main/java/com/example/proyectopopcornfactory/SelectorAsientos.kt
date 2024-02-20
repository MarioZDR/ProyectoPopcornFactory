package com.example.proyectopopcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectopopcornfactory.databinding.ActivitySeatSelectionBinding
import android.content.Intent

class SelectorAsientos : AppCompatActivity() {
    private lateinit var binding: ActivitySeatSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeatSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var selectedSeat = -1
        var posMovie = -1
        val bundle = intent.extras

        if(bundle!=null)
        {
            binding.tittleSeats.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }else{
            binding.tittleSeats.setText("Texto Default")
            posMovie = 1
        }

        binding.confirm.setOnClickListener{
            if(selectedSeat > 0){
                Toast.makeText(this,"Enjoy the movie! :D",Toast.LENGTH_LONG).show()
                CatalogoPeliculas.catalogo.get(posMovie).seats.add(Cliente("Default","Default",selectedSeat))
                val intent = Intent(this, MainActivity::class.java).apply {}
                this!!.startActivity(intent)
            }
        }


        binding.row1.setOnCheckedChangeListener{
            group, checkedId ->
            if(checkedId > -1)
            {
                selectedSeat = checkedId
                binding.row2.clearCheck()
                binding.row3.clearCheck()
                binding.row4.clearCheck()
                binding.row1.check(checkedId)
            }
        }
        binding.row2.setOnCheckedChangeListener{
                group, checkedId ->
            if(checkedId > -1)
            {
                selectedSeat = checkedId
                binding.row1.clearCheck()
                binding.row3.clearCheck()
                binding.row4.clearCheck()
                binding.row2.check(checkedId)
            }
        }
        binding.row3.setOnCheckedChangeListener{
                group, checkedId ->
            if(checkedId > -1)
            {
                selectedSeat = checkedId
                binding.row2.clearCheck()
                binding.row1.clearCheck()
                binding.row4.clearCheck()
                binding.row3.check(checkedId)
            }
        }
        binding.row4.setOnCheckedChangeListener{
                group, checkedId ->
            if(checkedId > -1)
            {
                selectedSeat = checkedId
                binding.row2.clearCheck()
                binding.row3.clearCheck()
                binding.row1.clearCheck()
                binding.row4.check(checkedId)
            }
        }

    }

}