

# SpringBoot2.x整合swagger-bootstrap-ui

## 一、访问Swagger

**URL地址：**  http://localhost:8080/doc.html 

**访问效果：**![swagger-bootstrap-ui](C:\Users\cao\Desktop\swagger-bootstrap-ui.png)



## 二、Swagger-BootStrap-Ui官网

### GitHub

**GitHub源码：**  https://github.com/xiaoymin/swagger-bootstrap-ui/blob/master/README_zh.md 

### GitEE

**GitEE源码：** https://gitee.com/xiaoym/knife4j 

### 其他

**源码分析：** https://www.xiaominfo.com/2019/05/20/springfox-0/ 

**演示示例：** http://swagger-bootstrap-ui.xiaominfo.com/doc.html 

**在线文档：** https://doc.xiaominfo.com/ 



## 三、项目Demo示例

Demo示例见另外项目地址：https://gitee.com/xiaoym/swagger-bootstrap-ui-demo

| 模块                            | 说明                                                         |
| ------------------------------- | ------------------------------------------------------------ |
| knife4j-spring-boot-demo        | 在Spring Boot架构下集成knife4j的项目示例                     |
| knife4j-spring-boot-single-demo | 在Spring Boot单体架构下集成knife4j的项目示例                 |
| knife4j-spring-cloud-gateway    | 在Spring Cloud微服务架构下通过gateway网集成knife4j的示例     |
| swagger-bootstrap-ui-demo-mvc   | 在Spring MVC模式下集成swagger-bootstrap-ui                   |
| swagger-bootstrap-ui-demo       | 在Spring Boot单体架构下集成swagger-bootstrap-ui              |
| swagger-bootstrap-ui-gateway    | 在Spring Cloud微服务架构下通过gateway网关集成swagger-bootstrap-ui |
| swagger-bootstrap-ui-zuul       | 在Spring Cloud微服务架构下通过zuul网关集成swagger-bootstrap-ui |

## 四、Swagger文档注解

> swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。

**@Api：**修饰整个类，描述Controller的作用
**@ApiOperation：**描述一个类的一个方法，或者说一个接口
**@ApiParam：**单个参数描述
**@ApiModel：**用对象来接收参数
**@ApiProperty：**用对象接收参数时，描述对象的一个字段
**@ApiResponse：**HTTP响应其中1个描述
**@ApiResponses：**HTTP响应整体描述
**@ApiIgnore**：使用该注解忽略这个API
**@ApiError ：**发生错误返回的信息
**@ApiParamImplicitL：**一个请求参数
**@ApiParamsImplicit** 多个请求参数