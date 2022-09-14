package hr.ferit.sandroblavicki.sandroapp.repositories

import hr.ferit.sandroblavicki.sandroapp.home.PostData

class PostRepositoryImpl : PostRepository() {

    private val posts  = listOf<PostData>(
        PostData(
            userId = "1",
            username = "Dacalino",
            imageUrl = "imageurlsms",
            description = "Dasidsajdisaj"
        ),
        PostData(
            userId = "2",
            username = "Dacalino 2",
            imageUrl = "imageurlsms",
            description = "Dasidsajdisaj 2"
        ),
        PostData(
            userId = "3",
            username = "Dacalino 3",
            imageUrl = "imageurlsms",
            description = "Dasidsajdisaj 3"
        ),        PostData(
            userId = "4",
            username = "Dacalin4 o",
            imageUrl = "imageurlsms",
            description = "Dasidsajdisaj 4"
        ),


    )

    override fun getPosts(): List<PostData> {
        return posts
    }

    override fun updatePost(postId: String) {
        TODO("Not yet implemented")
    }
}