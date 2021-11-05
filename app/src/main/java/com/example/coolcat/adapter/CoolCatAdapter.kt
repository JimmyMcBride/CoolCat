package com.example.coolcat.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coolcat.constants.Constants
import com.example.coolcat.databinding.CatImageBinding
import com.example.coolcat.extensions.loadUrl
import com.example.coolcat.repo.remote.CatInfo
import com.example.coolcat.view.AllBreedsActivity
import com.example.coolcat.view.BreedDetailsActivity
import java.io.Serializable

class CoolCatAdapter: RecyclerView.Adapter<CoolCatAdapter.CoolCatViewHolder>() {

    private val catInfo = mutableListOf<CatInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoolCatViewHolder {
        return CoolCatViewHolder.getInstance(parent)
    }

    override fun onBindViewHolder(holder: CoolCatViewHolder, position: Int) {
        holder.loadInfo(catInfo[position])
    }

    override fun getItemCount(): Int {
        return catInfo.size
    }

    fun updateCatInfo(catInfo: List<CatInfo>) {
        val size = this.catInfo.size
        this.catInfo.clear()
        notifyItemRangeRemoved(0, size)

        this.catInfo.addAll(catInfo)
        notifyItemRangeInserted(0, catInfo.size)
    }

    class CoolCatViewHolder(
        private val binding: CatImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun loadInfo(catInfo: CatInfo) = with(binding) {
//            ivImage.loadUrl(url)
            ivImage.loadUrl(catInfo.image?.url ?: "https://www.clipartkey.com/mpngs/m/152-1520367_user-profile-default-image-png-clipart-png-download.png")
            tvCatName.text = catInfo.name
//            ivImage.setOnClickListener()
            clCatWrapper.setOnClickListener {
                // Code here executes on main thread after user presses button
                val intent = Intent(binding.root.context, BreedDetailsActivity::class.java)
                intent.putExtra(Constants.BREED_ID, catInfo as Serializable)
                startActivity(binding.root.context, intent, null)
            }

        }

        companion object {

            fun getInstance(parent: ViewGroup): CoolCatViewHolder {
                val binding = CatImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CoolCatViewHolder(binding)
            }
        }
    }
}