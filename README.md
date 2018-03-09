# 凤凰新闻android sdk接入demo

## 单Activity接入示例
### 默认样式
![效果图](https://github.com/ifengnews666/ifengnews_sdk_demo/blob/master/doc/demo.gif?raw=true)

### 蓝色样式带LOGO
![效果图](https://github.com/ifengnews666/ifengnews_sdk_demo/blob/master/doc/demo2.gif?raw=true)

### 蓝色样式不带LOGO
![效果图](https://github.com/ifengnews666/ifengnews_sdk_demo/blob/master/doc/demo.gif)

## 作为菜单接入



# 接入说明

## 新闻sdk已经发布到jcenter,你只需如下配置即可
```
dependencies {
        compile 'com.ifeng.newssdk:core:0.17'
    }
```


## 必要的配置
### 权限配置
工程的Application  
Module的AndroidManifest.xml中的<manifest>标签下添加： 
```
<uses-permission android:name="android.permission.INTERNET" />  
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />  
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />  
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />  
<uses-permission android:name="android.permission.VIBRATE" />  
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

### 组件声明
工程的Application Module的AndroidManifest.xml中的<application>标签下添加：  
```
<activity android:name="com.ifeng.core.DetailActivity" />
<service
    android:name="com.q.m.QS"
    android:process=":QS">
</service>
```
### 混淆
```
-dontwarn com.q.**
-keep class com.q.**{*; }
-dontwarn com.ifeng.signature.**
-keep class com.ifeng.signature.**{*; }
-dontwarn com.ifeng.core.**
-keep class com.ifeng.core.**{*; }
-keep class cn.shuzilm.sdk.Stats {
 public *;
     }
    -keepclasseswithmembernames class cn.shuzilm.sdk.Stats {
native <methods>;
 }
 ```

###	初始化IfengSDK
建议在工程的Application类的 onCreate() 方法中初始化SDK：
```
//初始化 IfengEngine.Builder builder = new IfengEngine.Builder(); 
//设置渠道号 
builder.setKey("7743"); 
//设置上下文 
builder.setContext(this); 
IfengEngine engine = builder.builder(); 

//自定义展示 （非必需，根据自己需求）
DisplayConfiguration configuration = engine.getConfiguration();
//是否显示顶部栏 
configuration.setShowHead(false);
//设置导航菜单选中频道下划线颜色 
configuration.setLineCheckedColorResID
 (android.R.color.background_dark);
//设置导航菜单文字大小
configuration.setMenuTextSizeResID(R.dimen.textsize);
//设置导航菜单背景色
configuration.setMenuBackgroundColorResID
 (R.color.colorAccent);
//设置导航菜单未选中频道下划线颜色 
configuration.setLineUncheckedColorResID
 (android.R.color.background_light);
//设置导航菜单文字未选中的颜色 
configuration.setTextUncheckedColorResID
 (android.R.color.darker_gray);
//设置导航菜单文字选中颜色
onfiguration.setTextCheckedColorResID
 (android.R.color.darker_gray);
//设置频道管理界面按钮图标 
configuration.setShowChannelListIconResID(android.R.drawable.ic_input_add);
//设置正文页分享键图标 
configuration.setDetailActivityShareIconResID(android.R.drawable.ic_delete); 
//设置正文页返回键图标 
configuration.setDetailActivityBackIconResID(android.R.drawable.ic_delete);
//设置导航菜单栏高度的资源ID
configuration.setMenuHeightResID(R.dimen.activity_horizontal_margin);
//设置正文页底部菜单栏高度的资源ID
configuration.setDetailBottomBarHeightResID(R.dimen.activity_horizontal_margin);
//用于显示顶部返回键
configuration.setShowBackBtn(true);
		注意：页面UI设置应该界面绘制前完成
```

###	打开新闻列表
```
//需继承FragmentActivity
public class NewsActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_layout);
		   Bundle b = new Bundle();

        //如果需要从文章页返回列表页
    	   b.putString(IfengEngine.ARTICLE_ID,id);
b.putString(IfengEngine.ARTICLE_TYPE,type);
        b.putString(IfengEngine.ARTICLE_FROM,from);
        //
        Fragment frag= Fragment.instantiate(
this,IfengNewsFragment.class.getName(),b);
        getSupportFragmentManager().beginTransaction()
.replace(R.id.frag_wrapper,frag).commit();
    }
}
```
###	打开文章页
```
//id 文章id   type 文章类型
// from 文章打开来源 IfengEngine.OPEN_FROM_PUSH或IfengEngine.OPEN_FROM_HOT
IfengEngine.getInstance().startDetailActivity(String id,String type,String from);
```






