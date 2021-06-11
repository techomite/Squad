package com.andromite.footballsquad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andromite.footballsquad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    private lateinit var squadAdapter : SquadAdapter
    lateinit var leagueSelected : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        squadAdapter = SquadAdapter()



        binding.apply {

            serieaButton.isChecked = true
            leagueSelected = "seriea"

            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = squadAdapter


            serieaButton.setOnClickListener {
                serieaButton.isChecked = true
                leagueSelected = "seriea"
                callAPI()
            }
            premierLeagueButton.setOnClickListener {
                premierLeagueButton.isChecked = true
                leagueSelected = "premierleague"
                callAPI()
            }
            ligaButton.setOnClickListener {
                ligaButton.isChecked = true
                leagueSelected = "liga"
                callAPI()
            }
            bundesligaButton.setOnClickListener {
                bundesligaButton.isChecked = true
                leagueSelected = "bundesliga"
                callAPI()
            }
            ligue1Button.setOnClickListener {
                ligue1Button.isChecked = true
                leagueSelected = "ligue1"
                callAPI()
            }
        }


        callAPI()
        viewModel.squads.observe(this, {
            Log.e("12345",it.toString())
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            squadAdapter.submitList(it)

        })
        viewModel.scorer.observe(this, {
            Log.e("12345",it.toString())
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        })


    }

    fun callAPI(){
        binding.apply {
            recyclerView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
        viewModel.getSquads(leagueSelected)
        viewModel.getScoorer(leagueSelected)
    }
}