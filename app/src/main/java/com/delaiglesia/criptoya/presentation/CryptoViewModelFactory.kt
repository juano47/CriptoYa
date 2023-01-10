package com.delaiglesia.criptoya.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.delaiglesia.criptoya.data.repository.CryptoRepository
import com.delaiglesia.unitconverterapp.CryptoViewModel
import javax.inject.Inject

//las clases que tienen un constructor se les puede agregar directamente el @Inject
//pero las interfaces o clases abstractas no, por eso se hace con un Module
class CryptoViewModelFactory @Inject constructor(
    private val app: Application,
    private val repository: CryptoRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        CryptoViewModel(app, repository) as T
}