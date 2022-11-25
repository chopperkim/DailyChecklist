package kr.co.pigland.dailychecklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.pigland.dailychecklist.databinding.CheckItemBinding

class ChecklistAdapter(private val checklist: List<CheckItem>) :
    RecyclerView.Adapter<ChecklistAdapter.ChecklistViewHolder>() {
    class ChecklistViewHolder(val binding: CheckItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChecklistViewHolder {
        return ChecklistViewHolder(CheckItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ChecklistViewHolder, position: Int) {
        holder.binding.check = checklist[position]
    }

    override fun getItemCount(): Int = checklist.size
}