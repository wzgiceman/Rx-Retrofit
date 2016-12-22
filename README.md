#Rx-Retrofit极简方式使用

为了方便快速集成，这里去掉回调base统一处理，结果返回服务器原始数据，在回调`onNext`中自行挑选`gson`解析第三方包处理

##依赖

根目录下`build.gradle`添加仓地址

```java
	maven { url 'https://jitpack.io' }
```

依赖库

```java
	compile 'com.github.wzgiceman:Rx-Retrofit:-SNAPSHOT'
```

##使用
###1.初始化`RxRetrofitApp`

```java
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //app和基础baseurl
        RxRetrofitApp.init(this,"http://www.izaodao.com/Api/");
    }
}

```
###2.初始化`HttpManager`对象

```java
//传递数据回调接口`HttpOnNextListener`和RxAppCompatActivity对象
HttpManager x=new HttpManager(this, this);
```

###3.初始api接口数据

一个api接口需要创建一个api类基础BaseApi，可动态设置缓存，加载框显示等处理，同时给定post请求接口参数

例如：
```java
public class SubjectPostApi extends BaseApi {
    //    接口需要传入的参数 可自定义不同类型
    private boolean all;

    /**
     * 默认初始化需要给定回调和rx周期类
     * 可以额外设置请求设置加载框显示，回调等（可扩展）
     * 设置可查看BaseApi
     */
    public SubjectPostApi() {
        setShowProgress(true);
        setCancel(true);
        setMothed("AppFiftyToneGraph/videoLink");
        setCache(false);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        //可定义多个ApiService接口类，随意切换
        HttpTestService httpService = retrofit.create(HttpTestService.class);
        return httpService.getAllVedioBy(all);
    }

}
```

###4.回调处理
HttpOnNextSubListener接口类抽象了两个回调方法
```java
    /**
     * 成功后回调方法
     * @param resulte 这里是服务器返回的原始数据无任何处理
     * @param mothead
     */
   void onNext(String resulte,String mothead);

    /**
     * 失败
     * 失败或者错误方法
     * 自定义异常处理
     * @param e
     */
    void onError(ApiException e);

```

***

[更多用法可以参考MainActivity](https://github.com/wzgiceman/Rx-Retrofit/blob/master/app/src/main/java/com/example/retrofit/activity
/MainActivity.java)

完整使用请查看demo
***
##其他版本


>[回调判断版本-Rxjava+ReTrofit+okHttp深入浅出-终极封装String方案](https://github.com/wzgiceman/RxjavaRetrofitDemo-string-master)

>[兄弟版本-Rxjava+ReTrofit+okHttp深入浅出-终极封装Gson方案](https://github.com/wzgiceman/RxjavaRetrofitDemo-master)



封装原理博客专栏：

>[Rxjava+ReTrofit+okHttp深入浅出-终极封装](http://blog.csdn.net/column/details/13297.html)



