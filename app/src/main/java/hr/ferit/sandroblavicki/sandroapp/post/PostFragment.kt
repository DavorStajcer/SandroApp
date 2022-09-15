package hr.ferit.sandroblavicki.sandroapp.post

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import hr.ferit.sandroblavicki.sandroapp.databinding.PostFramentBinding
import hr.ferit.sandroblavicki.sandroapp.home.PostData
import hr.ferit.sandroblavicki.sandroapp.repositories.PostRepositoryImpl


class PostFragment : Fragment() {

    private lateinit var binding: PostFramentBinding
    private lateinit var viewModel: PostViewModel
    private lateinit var postCommentsRecyclerAdapter: PostCommentsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = PostViewModel(PostRepositoryImpl())
        binding = PostFramentBinding.inflate(LayoutInflater.from(context),container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val post: PostData? = getPostFromArgs();
        Log.v("jsonStuff", post?.toString() ?: "null")

        if(post == null){
            showErrorView()
            return
        }

        postCommentsRecyclerAdapter = PostCommentsRecyclerAdapter(requireContext(), listOf())
        binding.commentsRecyclerView.apply {
            adapter = postCommentsRecyclerAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.apply {
            comments.observe(viewLifecycleOwner) { comments ->
                postCommentsRecyclerAdapter.setComments(comments)
            }
            fetchCommentsForPost(post.postId)

        }
        binding.apply {
            username.text = post.username ?: "username is null"
            description.text = post.description
            Glide.with(requireContext()).load(post.imageUrl).into(image)
        }
    }

    private fun getPostFromArgs(): PostData? {
        var post: PostData? = null
        val postJsonString: String? = arguments?.getString("post")
        Log.v("jsonStuff", postJsonString ?: "null")
        if(postJsonString != null){
            post = Gson().fromJson(postJsonString,PostData::class.java)
        }
        return post
    }

    private fun showErrorView() {
        binding.apply {
            username.visibility = View.GONE
            image.visibility = View.GONE
            commentsRecyclerView.visibility = View.GONE
            description.visibility = View.GONE
            errorText.visibility = View.VISIBLE
        }
    }


}