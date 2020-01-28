package com.example.myapplication2.backendAPIHandlers

import com.example.myapplication2.interfaceClass.IWebAPIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

enum class APIType {
    UserList,
    UserInfo;
}

class APICaller(var iWebAPIResponse: IWebAPIResponse) {
    private var mCompositeDisposable = CompositeDisposable()
    fun callAPI(pageSize: Int, type: APIType) {
        when (type) {
            APIType.UserList -> {
                mCompositeDisposable.add(
                    RetrofitAPIConfig.getInstance().create()
                        .getUserList(pageSize)
                        .subscribeOn(Schedulers.io()).observeOn(
                            AndroidSchedulers.mainThread()
                        ).subscribeWith(object : DisposableSingleObserver<Any>() {
                            override fun onSuccess(t: Any) {
                                iWebAPIResponse.onSuccess(t,APIType.UserList)
                            }

                            override fun onError(e: Throwable) {
                                iWebAPIResponse.onFailure(e.message!!)
                            }
                        })
                )
            }
            APIType.UserInfo -> {
                mCompositeDisposable.add(
                    RetrofitAPIConfig.getInstance().create()
                        .getUserInfo(pageSize)
                        .subscribeOn(Schedulers.io()).observeOn(
                            AndroidSchedulers.mainThread()
                        ).subscribeWith(object : DisposableSingleObserver<Any>() {
                            override fun onSuccess(t: Any) {
                                iWebAPIResponse.onSuccess(t,APIType.UserInfo)
                            }

                            override fun onError(e: Throwable) {
                                iWebAPIResponse.onFailure(e.message!!)
                            }
                        })
                )
            }
        }
    }
}