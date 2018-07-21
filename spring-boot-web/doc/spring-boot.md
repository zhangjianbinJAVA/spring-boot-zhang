## spring boot 核心
- @EnableAutoConfiguration   
  为当前项目进行自动配置   
- 关闭特定的自动配置   
  @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
- 定制 Banner  
  网址：http://patorjk.com/software/taag  
- 使用xml配置时的配置   
  加载xml配置 @ImportResource({"classpath:some-context.xml"})  
- 外部配置  
    -  java -jar xx.jar --server.port=9090  
- 类型安全的配置 
    - @ConfigurationProperties 加载 properties 文件内的配置，prefix 属性指定 properties 的配置
    的前缀，能过 locations 指定 properties 文件的位置
    
## spring boot 原理
> 自动配置的源码在 spring-boot-autoconfigure jar内
### 查看当前项目中已启用的和未启用的自动配置的报告
在 配置文件中 debug=true        
  
- @ConfigurationProperties 注解的类中的构造函数中的参数，只要当前项目中有bean时，则当项目启动时，会自动注入  
- spring boot 的web配置，增加自已的额外的配置时，自定义的配置类继承WebMvcConfigurerAdapter，这样spring boot
  的自动配置和自定义的配置同时有效
- 在已有的配置文件内添加bean的话，则注意当前类要声明为 static

## WebSocket
> WebSocket 为浏览器和服务端提供了双工异步通信的功能。   


## spring jdbc 自动配置
- org.springframework.boot.autoconfigure.jdbc 报下，通过 spring.datasource 为前缀的属性自动配置 DataSource;
- spring boot 提供了一个初始化数据的功能，放置在类路径下的 schema.sql 文件会自动用来初始化表结构，放置在类路径下的data.sql
  文件会自动用来填充表数据


## spring 的事务
-  spring 的事务机制提供了一个 PlatformTransactionManager 接口，不同的数据访问技术的事务使用不同的接口实现
-  @Transactional 注解在方法上表明该方法需要事务支持，这是一个基于AOP的实现操作
-  @EnableTransactionManagement 注解在配置类上来开启声明式事务的支持，使用了@EnableTransactionManagement后
   spring 容器会自动扫描注解 @Transactional 的方法和类

## spring boot 的事务支持
- 自动配置的事务管理器  
  如 jdbc 实物配置 DataSourceTransactionManagerAutoConfiguration
- 自动开启注解事务的支持  
  spring boot 专门用于配置事务的类为 TransactionAutoConfiguration，而在 DataSourceTransactionManagerAutoConfiguration 
  配置里还开启了对声明式事务的支持。所以在 spring boot 中，无须显示开启使用 @EnableTransactionManagement 注解
  
  Spring的7种事务传播行为类型
  ```
  1、PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。
  2、PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。‘
  3、PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。
  4、PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。
  5、PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
  6、PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
  7、PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
  ``` 
### spring 支持的 数据缓存 Cache
针对不同的缓存持术，需要实现不同的 CacheManager

