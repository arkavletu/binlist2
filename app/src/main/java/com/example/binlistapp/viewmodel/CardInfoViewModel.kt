package com.example.binlistapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.binlistapp.dao.CardInfoDao
import com.example.binlistapp.db.AppDb
import com.example.binlistapp.dto.Bank
import com.example.binlistapp.dto.CardInfo
import com.example.binlistapp.dto.Country
import com.example.binlistapp.dto.Number
import com.example.binlistapp.entity.CardInfoEntity
import com.example.binlistapp.model.FeedModel
import com.example.binlistapp.repo.CardInfoRepo
import com.example.binlistapp.repo.CardInfoRepoImpl
import com.example.binlistapp.util.SingleLiveEvent

private val empty = CardInfo(
    com.example.binlistapp.dto.Number(2,false),"false","","",false,
    Country("","","","","",1,1),
    Bank("","url","",""),1
)

class CardInfoViewModel(application: Application) : AndroidViewModel(application),CardInfoDao {

    private val repository: CardInfoRepo = CardInfoRepoImpl()
    private val _data = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel>
        get() = _data
//    private val _postCreated = SingleLiveEvent<Unit>()
//    val postCreated: LiveData<Unit>
//        get() = _postCreated
    private val edited = MutableLiveData(empty)




    fun loadInfo(bin:String) {
        _data.value = FeedModel(loading = true)
        repository.getAsync(object : CardInfoRepo.Callback<List<CardInfo>> {
            override fun onSuccess(posts: List<CardInfo>) {
                _data.value = FeedModel(posts = posts, empty = posts.isEmpty())

            }

            override fun onError(e: Exception) {
                _data.value = FeedModel(error = true)
            }
        },bin)
    }

//    fun save() {
//        edited.value?.let {
//            repository.save(it, object : CardInfoRepo.Callback<CardInfo> {
//                //
//            })
//            _postCreated.value = Unit
//        }
//        edited.value = empty
//    }

    override fun getAll(): LiveData<List<CardInfoEntity>> {
        TODO("Not yet implemented")
    }

    override fun insert(entity: CardInfoEntity) {

    }
}