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