package hr.ferit.sandroblavicki.sandroapp.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hr.ferit.sandroblavicki.sandroapp.home.PostComment
import hr.ferit.sandroblavicki.sandroapp.repositories.PostRepository

class PostViewModel (
    private val postRepository: PostRepository,
        ) {

    private val _comments = MutableLiveData<List<PostComment>>()
     val comments : LiveData<List<PostComment>> = _comments


    fun fetchCommentsForPost(postId: String){
        val comments: List<PostComment> = postRepository.getCommentsForPost(postId)
        _comments.value = comments
    }


}