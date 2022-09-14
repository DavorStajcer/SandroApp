package hr.ferit.sandroblavicki.sandroapp.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.sandroblavicki.sandroapp.databinding.PostBinding

class HomePageRecyclerViewAdapter (
    private val context: Context,
    private var items: List<PostData>
        ) : RecyclerView.Adapter<HomePageRecyclerViewAdapter.PostViewHolder>() {


    inner class PostViewHolder(private val binding: PostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(postData: PostData) {
            binding.apply {
                username.text = postData.username
                description.text = postData.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: PostBinding = PostBinding.inflate(LayoutInflater.from(context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setPosts(newPosts : List<PostData>) {
        items = newPosts
    }
}