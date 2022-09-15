package hr.ferit.sandroblavicki.sandroapp.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.sandroblavicki.sandroapp.databinding.CommentBinding
import hr.ferit.sandroblavicki.sandroapp.home.PostComment

class PostCommentsRecyclerAdapter(
    private val context: Context,
    private var postComments: List<PostComment>
) : RecyclerView.Adapter<PostCommentsRecyclerAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = CommentBinding.inflate(LayoutInflater.from(context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(postComments[position])
    }

    override fun getItemCount(): Int = postComments.size

    inner class CommentViewHolder(
        private val binding: CommentBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(postComment: PostComment) {
            binding.apply {
                username.text = postComment.username
                comment.text = postComment.comment
            }
        }
    }

    fun setComments(newComments: List<PostComment>){
        postComments = newComments
    }

}