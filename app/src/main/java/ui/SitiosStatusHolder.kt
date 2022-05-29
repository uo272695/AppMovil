package ui


import android.os.Build
import android.provider.Settings.Global.getString
import androidx.recyclerview.widget.RecyclerView
import android.view.View;
import androidx.annotation.RequiresApi
import com.example.appmovil.R
import com.example.appmovil.databinding.SimpleListItemBinding

class SitiosStatusHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val itemBinding = SimpleListItemBinding.bind(itemView)


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun bind(sitio: ArrayList<String>) {
        itemBinding.text1.text =
            String.format(R.string.itemHolder.toString(),
                sitio[4],sitio[9],sitio[2],sitio[10])
    }

}
