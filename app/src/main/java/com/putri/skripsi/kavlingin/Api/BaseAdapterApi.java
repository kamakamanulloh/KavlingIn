package com.putri.skripsi.kavlingin.Api;


import com.putri.skripsi.kavlingin.Value;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseAdapterApi {
    @FormUrlEncoded
    @POST("adddonasi.php")
    Call<Value> daftar(@Field("iduser") String iduser,
                       @Field("idpost") String idpost,
                       @Field("donasi") String donasi,
                       @Field("email") String email,
                       @Field("transfer") String transfer);


    @FormUrlEncoded
    @POST("login.php")
    public Call<ResponseBody> loginRequest(@Field("email") String email,
                                           @Field("password") String password);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);

    @GET("read.php")
    Call<Value> view();
}
