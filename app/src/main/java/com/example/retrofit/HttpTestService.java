package com.example.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * 测试接口service
 * Created by WZG on 2016/12/19.
 */

public interface HttpTestService {

    @FormUrlEncoded
    @POST("AppFiftyToneGraph/videoLink")
    Observable<String> getAllVedioBy(@Field("once_no") boolean once_no);

    /*上传文件*/
    @Multipart
    @POST("AppYuFaKu/uploadHeadImg")
    Observable<String> uploadImage(@Part("uid") RequestBody uid, @Part("auth_key") RequestBody  auth_key,
                                   @Part MultipartBody.Part file);

}
