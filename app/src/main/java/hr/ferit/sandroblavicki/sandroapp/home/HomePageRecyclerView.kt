package hr.ferit.sandroblavicki.sandroapp.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import hr.ferit.sandroblavicki.sandroapp.databinding.PostBinding

class HomePageRecyclerViewAdapter (
    private val context: Context,
    private var items: List<PostData>,
    private val viewModel: HomeViewModel,
        ) : RecyclerView.Adapter<HomePageRecyclerViewAdapter.PostViewHolder>() {



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


    inner class PostViewHolder(private val binding: PostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(postData: PostData) {
            binding.apply {
                username.text = postData.username
                description.text = postData.description
                Glide.with(context).load(postData.imageUrl).into(image)
                postLinerLayout.setOnClickListener { _ ->
                    val postJsonString: String = Gson().toJson(postData)
                    Log.v("jsonStuff", postJsonString)
                    viewModel.navigateTo(HomeFragmentDirections.navigateToPostFragment(postJsonString))
                }
            }
        }
    }

}