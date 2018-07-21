## spring Aware
> spring Aware 的目的是为了让 Bean 获得 spring 容器的服务
- BeanNameAware 获取到容器中bean的名称
- BeanFactoryAware 获取当前 bean factory ，这样可以调用容器的服务
- ApplicationContextAware*  当前的 application context ，可以获取spring 容器的所有服务
- MessageSourceAware  获取 message source ，这样可以获得文本信息
- ResourceLoaderAware 获取资源加载器，可以获得外部资源文件

## 多线程 
spring 通过任务执行器 TaskExecutor 来实现多线程和并发编程
通过在配置类中能过 @EnableAsync 开启对异步任务的支持，在实际的Bean 的方法中使用@Async 注解来声明是一个异步任务


## Enable* 注解的工作原理
> 所有的注解都有一个 @Import注解，是用来导入配置类的，其实是导入了一些自动配置的Bean

### 导入的配置主式主要分为以下三种类型
- 第一类：直接导入配置类

  例如 @EnableScheduling

- 第二类： 依据条件选择配置类

  例如： @EnableAsync ，AsyncConfigurationSelector 通过条件来选择需要导入的配置类

- 第三类 动态注册Bean

  例如： @EnableAspectJAutoProxy，ImportBeanDefinitionRegistrar 接口的作用是在运行时自动添加Bean到已有的配置类，
  重写registerBeanDefinitions 方法，其中 AnnotationMetadata 参数用来获取当前配置类上的注解，BeanDefinitionRegistry
  参数用来注册 Bean
  
  
## spring mvc 
- @ControllerAdvice 对于控制器的全局配置放在同一个位置
- ExceptionHandler 用于全局处理控制器里的异常
- @InitBinder 用来设置 WebDataBinder ，WebDataBinder 用来过自动绑定前台请求参数至Model中
- @ModelAttribute 作用是绑定键值对到 Model 里，也可以是让全局的 @RequestMapping 都能获得在些处设置的键值对
- produces 可定制返回的 response 的媒体类型和字符集
- spring mvc 的定制配置类需要继承一个 WebMvcConfigurerAdapter 类，并在配置类上添加 @EnableWebMvc 注解，否则重写的方法无效。
  registry.addResourceLocations 方法指的是文件放置的目录 addResourceHandler 指对外暴露的访问路径
- 继承 HandlerInterceptorAdapter 类实现 自定义拦截器  WebMvcConfigurerAdapter 类中的 addInterceptors 方法注册自定义的拦截器
- 路径参数如果带 . 的话，后面的值将忽略，例如访问 /a/b/xx.yy ,通过重写 WebMvcConfigurerAdapter 类 的 configurePathMatch 方法，
  设置 configurer.setUseSuffixPatternMatch(false) 即可。
- MultipartResolver 配置bean ，对上传文件进行控制
- spring mvc 异步 
 
    http://blog.csdn.net/yangchangji/article/details/70888776
 
    http://blog.didispace.com/books/spring-mvc-4-tutorial/publish/21-3/4-asynchronous-request-processing.html

## HttpMessageConverter 是用来处理 request 和 response 里的数据
  例如： MappingJackson2HttpMessageConverter、StringHttpMessageConverter 等 
  
  自定义 HttpMessageConverter 实现：继承 AbstractHttpMessageConverter 接口来实现自定义的HttpMessageConverter
  - readInternal 方法，处理请求的数据
  - supports 方法，只处理什么类
  - writeInternal 方法，处理如何输出数据到 response
  - 配置自定义的 HttpMessageConverter 

## 服务器端推送技术
> 当客户端向服务端发送请求，服务端会抓住这个请求不放，等有数据更新的时候才返回给客户端，当客户端接收到消息后，再向服务端发送请求，
周而复始。SSE（server send event服务端发送事件）需要浏览器支持，另一个是websocket，websocket是双向通信信的技术（跨浏览器的）.
输出媒体类型为：produces="text/event-stream"，这是服务端 SSE的支持




  

    
