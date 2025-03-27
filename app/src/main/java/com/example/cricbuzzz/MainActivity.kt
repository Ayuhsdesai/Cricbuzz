package com.example.cricbuzzz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cricbuzzz.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Live"
                1 -> "Recent"
                else -> "Live"
            }
        }.attach()

    }

//    private fun callRetrofitApi() {
//        RetroFirInstance().callapi().GetCricApii().enqueue(object : Callback<CricBuzzMain> {
//            override fun onResponse(call: Call<CricBuzzMain>, response: Response<CricBuzzMain>) {
//                if (response.isSuccessful) {
//                    response.body()?.let { result ->
//                        Log.e("RETROFIT", "onResponse: $result")
//
//                        // Ensure typeMatches is not null before setting adapter
//                        result.typeMatches?.let { matches ->
//                            binding.recyclerview.adapter =
//                                RecyclerAdapter(matches, this@MainActivity)
//                        }
//                    }
//                } else {
//                    Log.e("RETROFIT", "Error: ${response.errorBody()?.string()}")
//                }
//            }
//
//            override fun onFailure(call: Call<CricBuzzMain>, t: Throwable) {
//                Log.e("RETROFIT", "onFailure: ${t.localizedMessage}")
//            }
//        })
//    }
}