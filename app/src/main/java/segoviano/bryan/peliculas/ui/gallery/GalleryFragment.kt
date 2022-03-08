package segoviano.bryan.peliculas.ui.gallery

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
import segoviano.bryan.peliculas.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    var series: ArrayList<Pelicula> = ArrayList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        llenarSeries()
        var adaptador = AdaptadorPeliculas(root.context, this.series)

        var listView: ListView = binding.listviewSeries
        listView.adapter = adaptador

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenarSeries(){
        val serieUno = Pelicula(0, getString(R.string.serieUno), getString(R.string.serieUnoSinop), "2 Temp", R.drawable.boys)
        val serieDos = Pelicula(1, getString(R.string.serieDos), getString(R.string.serieDosSinop), "5 Temp", R.drawable.casapapel)
        val serieTres = Pelicula(2, getString(R.string.serieTres), getString(R.string.serieTresSinop), "3 Temp", R.drawable.dark)
        val serieCuatro = Pelicula(3, getString(R.string.serieCuatro), getString(R.string.serieCuatroSinop), "1 Temp", R.drawable.loki)
        val serieCinco = Pelicula(5, getString(R.string.serieCinco), getString(R.string.serieCincoSinop), "2 Temp", R.drawable.mandalorian)
        val serieSeis = Pelicula(6, getString(R.string.serieSeis), getString(R.string.serieSeisSinop), "11 Temp", R.drawable.walkingdead)
        series.add(serieUno)
        series.add(serieDos)
        series.add(serieTres)
        series.add(serieCuatro)
        series.add(serieCinco)
        series.add(serieSeis)
    }

}