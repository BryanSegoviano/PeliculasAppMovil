package segoviano.bryan.peliculas.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import segoviano.bryan.peliculas.AdaptadorPeliculas
import segoviano.bryan.peliculas.Pelicula
import segoviano.bryan.peliculas.R
import segoviano.bryan.peliculas.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    var favoritos: ArrayList<Pelicula> = ArrayList()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        llenarFavoritos()
        var adaptador = AdaptadorPeliculas(root.context, this.favoritos)

        var listView: ListView = binding.listviewFav
        listView.adapter = adaptador

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenarFavoritos(){
        val favUno = Pelicula(0, getString(R.string.favUno), getString(R.string.favUnoSinop), "6 Temp", R.drawable.bojack)
        val favDos = Pelicula(1, getString(R.string.favDos), getString(R.string.favDosSinop), "5 Temp", R.drawable.breaking)
        val favTres = Pelicula(2, getString(R.string.favTres), getString(R.string.favTresSinop), "8 Temp", R.drawable.got)
        val favCuatro = Pelicula(3, getString(R.string.favCuatro), getString(R.string.favCuatroSinop), "4 Temp", R.drawable.reasons)
        val favCinco = Pelicula(5, getString(R.string.favCinco), getString(R.string.favCincoSinop), "4 Temp", R.drawable.shingeki)
        favoritos.add(favUno)
        favoritos.add(favDos)
        favoritos.add(favTres)
        favoritos.add(favCuatro)
        favoritos.add(favCinco)
    }

}