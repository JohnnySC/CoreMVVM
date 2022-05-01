package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.core.Mapper
import com.github.johnnysc.coremvvm.presentation.AbstractViewHolder
import java.util.*

/**
 * @author Asatryan on 26.04.2022
 */
class CurrenciesAdapter(
    private val changeFavorite: ChangeFavorite,
) : RecyclerView.Adapter<CurrencyViewHolder>(), Mapper.Unit<List<CurrencyUi>> {

    private val list = mutableListOf<CurrencyUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CurrencyViewHolder(
        changeFavorite,
        LayoutInflater.from(parent.context).inflate(R.layout.currency_layout, parent, false)
    )

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    override fun map(data: List<CurrencyUi>) {
        val diffCallback = DiffUtilsCallback(list, data)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        result.dispatchUpdatesTo(this)
    }
}

class CurrencyViewHolder(
    private val changeFavorite: ChangeFavorite,
    view: View
) : AbstractViewHolder<CurrencyUi>(view) {

    private val textView: TextView = view.findViewById(R.id.currencyTextView)
    private val compoundButton: CompoundButton = view.findViewById(R.id.compoundButton)

    private val mapper = CurrencyUi.Mapper.Ui(textView, compoundButton)

    override fun bind(data: CurrencyUi) {
        data.map(mapper)

        compoundButton.setOnClickListener {
            data.map(CurrencyUi.Mapper.ChangeFavorite(changeFavorite))
        }
    }
}

interface ChangeFavorite {

    fun changeFavorite(id: String)
}