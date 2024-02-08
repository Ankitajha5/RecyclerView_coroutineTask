package eu.tutorials.coroutinestask.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.coroutinestask.R
import eu.tutorials.coroutinestask.model.Data

class PostAdapter(private val context: Context, private var postList:List<Data> ): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       return PostViewHolder(LayoutInflater.from(parent.context)
           .inflate(R.layout.list_view,parent, false))
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.id.text = post.id.toString()
        holder.title.text = post.title

    }

    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val id: TextView=itemView.findViewById(R.id.id)
        val title: TextView = itemView.findViewById(R.id.title)


    }

    fun setData( postList: List<Data>){
       this.postList = postList
        notifyDataSetChanged()
    }
}