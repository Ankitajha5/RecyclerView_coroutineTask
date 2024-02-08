package eu.tutorials.coroutinestask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.coroutinestask.Adapter.PostAdapter
import eu.tutorials.coroutinestask.Repository.PostRepository
import eu.tutorials.coroutinestask.ViewModel.PostViewModel
import eu.tutorials.coroutinestask.ViewModel.PostViewModelFactory
import eu.tutorials.coroutinestask.databinding.ActivityMainBinding
import eu.tutorials.coroutinestask.model.Data

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  postAdapter: PostAdapter
    private lateinit var  postViewModel: PostViewModel
    private var progressBar: ProgressBar? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressBar = binding.progressBar
        initRecyclerView()
        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel= ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postLiveData.observe(this, Observer {
            postAdapter.setData(it)
           progressBar?.visibility = View.GONE
            recyclerView.visibility  = View.VISIBLE
        })
    }
    private fun initRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView)
        postAdapter = PostAdapter(this, ArrayList())
        recyclerView.apply{
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}