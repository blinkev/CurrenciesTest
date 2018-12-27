package com.harenko.currencies_test.ui.main.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.StableId
import com.harenko.currencies_test.ui.BR
import com.harenko.currencies_test.ui.R
import com.harenko.currencies_test.ui.databinding.ItemBaseCurrencyBinding
import com.harenko.currencies_test.ui.databinding.ItemCurrencyBinding
import com.harenko.currencies_test.ui.main.DataStatus
import com.harenko.currencies_test.ui.main.commasToDots
import com.harenko.currencies_test.ui.main.di.UiComponentHolder
import com.harenko.currencies_test.ui.main.main.di.MainActivityModule
import com.harenko.currencies_test.ui.main.main.item.BaseCurrencyUiItem
import com.harenko.currencies_test.ui.main.main.item.CurrencyUiItem
import com.jakewharton.rxbinding3.view.focusChanges
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    private val listData = ArrayList<StableId>()

    private val adapter = LastAdapter(listData, BR.item, stableIds = true)
            .map<BaseCurrencyUiItem, ItemBaseCurrencyBinding>(R.layout.item_base_currency) {
                onCreate { viewHolder ->
                    viewHolder.binding.valueView.apply {
                        textChanges()
                                .skipInitialValue()
                                .subscribeBy(
                                        onNext = {
                                            try {
                                                val input = it.toString()
                                                val multiplier = if (input.isBlank()) {
                                                    BigDecimal(0)
                                                } else {
                                                    BigDecimal(input.commasToDots())
                                                }
                                                (listData.first() as BaseCurrencyUiItem).multiplierTyped = input
                                                viewModel.changeMultiplier(multiplier)
                                            } catch (inputException: Throwable) {
                                                inputException.printStackTrace()
                                            }
                                        },
                                        onError = Throwable::printStackTrace
                                )
                        focusChanges()
                                .subscribeBy(
                                        onNext = {
                                            if (!it) hideKeyboard()
                                        },
                                        onError = Throwable::printStackTrace
                                )
                    }
                }
            }
            .map<CurrencyUiItem, ItemCurrencyBinding>(R.layout.item_currency) {
                onClick { viewHolder ->
                    viewModel.changeBaseCurrency(viewHolder.binding.item as CurrencyUiItem)
                }
                onBind { viewHolder ->
                    viewHolder.binding.valueView.setOnClickListener {
                        viewModel.changeBaseCurrency(viewHolder.binding.item as CurrencyUiItem)
                    }
                }
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupComponent()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defaultListAnimator = DefaultItemAnimator()
        defaultListAnimator.supportsChangeAnimations = false
        listView.itemAnimator = defaultListAnimator

        adapter.into(listView)
        observeCurrencies()

        lifecycle.addObserver(viewModel)
    }

    override fun onStop() {
        super.onStop()
        viewModel
    }

    private fun setupComponent() {
        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModelImpl::class.java)
        val component = viewModel.screenComponent
        if (component == null) {
            (application as UiComponentHolder).uiComponent.provideMainActivityComponent(MainActivityModule(viewModel)).apply {
                viewModel.screenComponent = this
                inject(this@MainActivity)
                inject(viewModel)
            }
        } else {
            component.inject(this)
        }
    }

    private fun observeCurrencies() {
        viewModel.currencies.observe(this, Observer {
            when (it) {
                is DataStatus.Data -> {
                    errorTextView.visibility = View.GONE

                    listData.clear()
                    listData.addAll(listOf(it.data.baseCurrencyItem) + it.data.currencyList)
                    listView?.post {
                        if (it.data.isBaseCurrencyChanged) {
                            adapter.notifyDataSetChanged()
                        } else {
                            adapter.notifyItemRangeChanged(1, listData.size - 1)
                        }
                    }
                }
                is DataStatus.Error -> {
                    it.error.printStackTrace()
                    errorTextView.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun hideKeyboard() {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(window.decorView.windowToken, 0)
    }
}