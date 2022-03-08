package segoviano.bryan.peliculas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorPeliculas: BaseAdapter {

    lateinit var context: Context
    var peliculas: ArrayList<Pelicula> = ArrayList()
    constructor(context: Context, peliculas: ArrayList<Pelicula>){
        this.context = context
        this.peliculas = peliculas
    }

    override fun getCount(): Int {
        //Indica el número de objetos de la lista
        return this.peliculas.size
    }

    override fun getItem(p0: Int): Any {
        //Indica el elemento individual con el que se puede interactuar
        return this.peliculas[p0]
    }

    override fun getItemId(p0: Int): Long {
        //pide el id del elemento en el que se esta trabajando
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //Obtener un inflador
        val inflador = LayoutInflater.from(this.context)
        var vista = inflador.inflate(R.layout.pelicula_view, null)

        var iv_img: ImageView = vista.findViewById(R.id.img_view)
        var tv_nombre: TextView = vista.findViewById(R.id.tv_nombre)
        var tv_duracion: TextView = vista.findViewById(R.id.tv_duracion)

        var pelicula: Pelicula = this.peliculas[p0]
        iv_img.setImageResource(pelicula.imagen)
        tv_nombre.setText(pelicula.nombre)
        tv_duracion.setText("Duración: " + pelicula.duracion)

        vista.setOnClickListener{
            val intent: Intent = Intent(this.context, PeliculaActivity::class.java)
            intent.putExtra("titulo", pelicula.nombre)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            intent.putExtra("poster", pelicula.imagen)
            this.context.startActivity(intent)
        }

        return vista
    }

}