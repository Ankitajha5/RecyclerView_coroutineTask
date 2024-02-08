package eu.tutorials.coroutinestask.Network

import eu.tutorials.coroutinestask.model.Data
import retrofit2.http.GET

interface Api {
   @GET("posts")
    suspend fun getPost():List<Data>
}