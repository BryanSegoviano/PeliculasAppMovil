package segoviano.bryan.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var peliculas: ArrayList<Pelicula> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llenarPeliculas()
        var adaptador = AdaptadorPeliculas(this, this.peliculas)

        var listView: ListView = findViewById(R.id.listview)
        listView.adapter = adaptador
    }

    fun llenarPeliculas(){
        val peliculaUno = Pelicula(0, getString(R.string.peliUno), getString(R.string.peliUnoSinop), "182", R.drawable.avengers)
        val peliculaDos = Pelicula(1, getString(R.string.peliDos), getString(R.string.peliDosSinop), "128", R.drawable.civilwar)
        val peliculaTres = Pelicula(2, getString(R.string.peliTres), getString(R.string.peliTresSinop), "122", R.drawable.joker)
        val peliculaCuatro = Pelicula(3, getString(R.string.peliCuatro), getString(R.string.peliCuatroSinop), "100", R.drawable.nemo)
        val peliculaCinco = Pelicula(5, getString(R.string.peliCinco), getString(R.string.peliCincoSinop), "132", R.drawable.shazam)
        val peliculaSeis = Pelicula(6, getString(R.string.peliSeis), getString(R.string.peliSeisSinop), "151", R.drawable.wonderwoman)
        val peliculaSiete = Pelicula(7, getString(R.string.peliSiete), getString(R.string.peliSieteSinop), "99", R.drawable.sonic)
        peliculas.add(peliculaUno)
        peliculas.add(peliculaDos)
        peliculas.add(peliculaTres)
        peliculas.add(peliculaCuatro)
        peliculas.add(peliculaCinco)
        peliculas.add(peliculaSeis)
        peliculas.add(peliculaSiete)
    }

}