package segoviano.bryan.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PeliculaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)

        val tvTitulo: TextView = findViewById(R.id.txtTitulo)
        val tvSinopsis: TextView = findViewById(R.id.txtSinopsis)
        val ivPoster: ImageView = findViewById(R.id.imgPelicula)

        val bundle = intent.extras

        if(bundle != null){
            var titulo: String = bundle.getString("titulo","")
            var sinopsis: String = bundle.getString("sinopsis","")
            var poster: Int = bundle.getInt("poster")

            tvTitulo.setText(titulo)
            tvSinopsis.setText(sinopsis)
            ivPoster.setImageResource(poster)
        }

    }
}