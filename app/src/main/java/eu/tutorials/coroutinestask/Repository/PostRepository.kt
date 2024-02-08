package eu.tutorials.coroutinestask.Repository

import eu.tutorials.coroutinestask.Network.RetrofitBuilder
import eu.tutorials.coroutinestask.model.Data

class PostRepository {
    val retrofit = RetrofitBuilder()
    suspend fun getPost():List<Data> = retrofit.api.getPost()
}