package segoviano.bryan.peliculas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import segoviano.bryan.peliculas.AdaptadorPeliculas
import segoviano.bryan.peliculas.Pelicula
import segoviano.bryan.peliculas.R
import segoviano.bryan.peliculas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    var peliculas: ArrayList<Pelicula> = ArrayList()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        llenarPeliculas()
        var adaptador = AdaptadorPeliculas(root.context, this.peliculas)

        var listView: ListView = binding.listviewPeliculas
        listView.adapter = adaptador

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenarPeliculas(){
        val peliculaUno = Pelicula(0, getString(R.string.peliUno), getString(R.string.peliUnoSinop), "182 minutos", R.drawable.avengers)
        val peliculaDos = Pelicula(1, getString(R.string.peliDos), getString(R.string.peliDosSinop), "128 minutos", R.drawable.civilwar)
        val peliculaTres = Pelicula(2, getString(R.string.peliTres), getString(R.string.peliTresSinop), "122 minutos", R.drawable.joker)
        val peliculaCuatro = Pelicula(3, getString(R.string.peliCuatro), getString(R.string.peliCuatroSinop), "100 minutos", R.drawable.nemo)
        val peliculaCinco = Pelicula(5, getString(R.string.peliCinco), getString(R.string.peliCincoSinop), "132 minutos", R.drawable.shazam)
        val peliculaSeis = Pelicula(6, getString(R.string.peliSeis), getString(R.string.peliSeisSinop), "151 minutos", R.drawable.wonderwoman)
        val peliculaSiete = Pelicula(7, getString(R.string.peliSiete), getString(R.string.peliSieteSinop), "99 minutos", R.drawable.sonic)
        peliculas.add(peliculaUno)
        peliculas.add(peliculaDos)
        peliculas.add(peliculaTres)
        peliculas.add(peliculaCuatro)
        peliculas.add(peliculaCinco)
        peliculas.add(peliculaSeis)
        peliculas.add(peliculaSiete)
    }

}