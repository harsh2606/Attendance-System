package com.system.datasource

import com.system.network.APIinterface

class UserRepository(apiInterface: APIinterface) {

    private var apiInterface: APIinterface? = apiInterface

//    fun login(loginDataModel: LoginDataModel): MutableLiveData<LoginData> {
//        val data = MutableLiveData<LoginData>()
//        val call = apiInterface!!.login(loginDataModel)
//        Debug.e("API", call.request().url.encodedPath)
//        Debug.e("body", Gson().toJson(loginDataModel))
//        call.enqueue(object : Callback<LoginData> {
//            override fun onFailure(call: Call<LoginData>, t: Throwable) {
//                data.value = LoginData(Constant.getFailureCode())
//                Debug.e("login isFailed", t.message)
//            }
//
//            override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
//                val loginStatus = response.code()
//                try {
//                    if (response.isSuccessful) {
//                        val loginData = response.body()
//                        loginData!!.statusCode = loginStatus
//                        data.value = loginData
//                        Debug.e("login isSuccessful", Gson().toJson(loginData))
//                    } else {
//                        try {
//                            val inputAsString =
//                                response.errorBody()!!.source().inputStream().bufferedReader()
//                                    .use { it.readText() }
//                            Debug.e("Input", inputAsString)
//                            val sb = StringBuilder()
//                            sb.append(inputAsString)
//                            val loginData = Gson().fromJson<LoginData>(
//                                JSONObject(inputAsString).toString(),
//                                object : TypeToken<LoginData>() {}.type
//                            )
//                            loginData.statusCode = loginStatus
//                            data.value = loginData
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                            data.value = LoginData(loginStatus)
//                        }
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    data.value = LoginData(loginStatus)
//                }
//            }
//        })
//        return data
//    }
//
//    fun logOut(): MutableLiveData<LogoutData> {
//        val data = MutableLiveData<LogoutData>()
//        val call = apiInterface!!.logOut()
//        Debug.e("API", call.request().url.encodedPath)
//        call.enqueue(object : Callback<LogoutData> {
//            override fun onFailure(call: Call<LogoutData>, t: Throwable) {
//                data.value = LogoutData(Constant.getFailureCode())
//                Debug.e("login isFailed", t.message)
//            }
//
//            override fun onResponse(call: Call<LogoutData>, response: Response<LogoutData>) {
//                val loginStatus = response.code()
//                try {
//                    if (response.isSuccessful) {
//                        val loginData = response.body()
//                        loginData!!.statusCode = loginStatus
//                        data.value = loginData
//                        Debug.e("login isSuccessful", Gson().toJson(loginData))
//                    } else {
//                        try {
//                            val inputAsString =
//                                response.errorBody()!!.source().inputStream().bufferedReader()
//                                    .use { it.readText() }
//                            Debug.e("Input", inputAsString)
//                            val sb = StringBuilder()
//                            sb.append(inputAsString)
//                            val loginData = Gson().fromJson<LogoutData>(
//                                JSONObject(inputAsString).toString(),
//                                object : TypeToken<LogoutData>() {}.type
//                            )
//                            loginData.statusCode = loginStatus
//                            data.value = loginData
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                            data.value = LogoutData(loginStatus)
//                        }
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    data.value = LogoutData(loginStatus)
//                }
//            }
//        })
//        return data
//    }
//
//    fun getArea(id: String): MutableLiveData<AllArea> {
//        val data = MutableLiveData<AllArea>()
//        val call = apiInterface!!.getArea(id)
//        Debug.e("API", call.request().url.encodedPath)
//        Debug.e("body", Gson().toJson(id))
//        call.enqueue(object : Callback<AllArea> {
//            override fun onFailure(call: Call<AllArea>, t: Throwable) {
//                data.value = AllArea(Constant.getFailureCode())
//                Debug.e("login isFailed", t.message)
//            }
//
//            override fun onResponse(call: Call<AllArea>, response: Response<AllArea>) {
//                val loginStatus: Int = response.code()
//                try {
//                    if (response.isSuccessful) {
//                        val loginData = response.body()
//                        loginData!!.statusCode = loginStatus
//                        data.value = loginData
//                        Debug.e("login isSuccessful", Gson().toJson(loginData))
//                    } else {
//                        try {
//                            val inputAsString =
//                                response.errorBody()!!.source().inputStream().bufferedReader()
//                                    .use { it.readText() }
//                            Debug.e("Input", inputAsString)
//                            val sb = StringBuilder()
//                            sb.append(inputAsString)
//                            val loginData = Gson().fromJson<AllArea>(
//                                JSONObject(inputAsString).toString(),
//                                object : TypeToken<AllArea>() {}.type
//                            )
//                            loginData.statusCode = loginStatus
//                            data.value = loginData
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                            data.value = AllArea(loginStatus)
//                        }
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    data.value = AllArea(loginStatus)
//                }
//            }
//        })
//        return data
//    }
//
//    fun forgetPassword(forgetPasswordDataModel: ForgetPasswordDataModel): MutableLiveData<ForgetPasswordData> {
//        val data = MutableLiveData<ForgetPasswordData>()
//        val call = apiInterface!!.forgetPassword(forgetPasswordDataModel)
//        Debug.e("API", call.request().url.encodedPath)
//        Debug.e("body", Gson().toJson(data))
//        call.enqueue(object : Callback<ForgetPasswordData> {
//            override fun onFailure(call: Call<ForgetPasswordData>, t: Throwable) {
//                data.value = ForgetPasswordData(Constant.getFailureCode())
//                Debug.e("forgetPassword isFailed", t.message)
//            }
//
//            override fun onResponse(
//                call: Call<ForgetPasswordData>,
//                response: Response<ForgetPasswordData>
//            ) {
//                var httpStatus = response.code()
//                try {
//                    if (response.isSuccessful) {
//                        val breakEndData = response.body()
//                        breakEndData!!.statusCode = httpStatus
//                        data.value = breakEndData
//                        Debug.e("forgetPassword isSuccessful", Gson().toJson(breakEndData))
//                    } else {
//                        try {
//                            val inputAsString =
//                                response.errorBody()!!.source().inputStream().bufferedReader()
//                                    .use { it.readText() }
//                            Debug.e("Input", inputAsString)
//                            val sb = StringBuilder()
//                            sb.append(inputAsString)
//                            val breakEndData = Gson().fromJson<ForgetPasswordData>(
//                                JSONObject(inputAsString).toString(),
//                                object : TypeToken<ForgetPasswordData>() {}.type
//                            )
//                            breakEndData.statusCode = httpStatus
//                            data.value = breakEndData
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                            data.value = ForgetPasswordData(httpStatus)
//                            Debug.e("forgetPassword isFailed", e.message)
//                        }
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    data.value = ForgetPasswordData(httpStatus)
//                    Debug.e("forgetPassword isFailed", e.message)
//                }
//            }
//        })
//        return data
//    }
//
//    fun updateProfile(param: MultipartBody): MutableLiveData<LoginData> {
//        val data = MutableLiveData<LoginData>()
//        val call = apiInterface!!.updateProfile(param)
//        Debug.e("API", call.request().url.encodedPath)
//        Debug.e("body", Gson().toJson(data))
//        call.enqueue(object : Callback<LoginData> {
//            override fun onFailure(call: Call<LoginData>, t: Throwable) {
//                data.value = LoginData(Constant.getFailureCode())
//                Debug.e("updateProfile isFailed", t.message)
//            }
//
//            override fun onResponse(
//                call: Call<LoginData>,
//                response: Response<LoginData>
//            ) {
//                var httpStatus = response.code()
//                try {
//                    if (response.isSuccessful) {
//                        val breakEndData = response.body()
//                        breakEndData!!.statusCode = httpStatus
//                        data.value = breakEndData
//                        Debug.e("updateProfile isSuccessful", Gson().toJson(breakEndData))
//                    } else {
//                        try {
//                            val inputAsString =
//                                response.errorBody()!!.source().inputStream().bufferedReader()
//                                    .use { it.readText() }
//                            Debug.e("Input", inputAsString)
//                            val sb = StringBuilder()
//                            sb.append(inputAsString)
//                            val breakEndData = Gson().fromJson<LoginData>(
//                                JSONObject(inputAsString).toString(),
//                                object : TypeToken<LoginData>() {}.type
//                            )
//                            breakEndData.statusCode = httpStatus
//                            data.value = breakEndData
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                            data.value = LoginData(httpStatus)
//                            Debug.e("updateProfile isFailed", e.message)
//                        }
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    data.value = LoginData(httpStatus)
//                    Debug.e("updateProfile isFailed", e.message)
//                }
//            }
//        })
//        return data
//    }


}