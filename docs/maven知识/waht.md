### 主要功能
|       依赖管理       |           	自动下载和管理 .jar 文件，避免手动管理依赖           |
|:----------------:|:---------------------------------------------:|
|     标准化构建流程	     |     提供 clean、compile、test、package 等标准生命周期     |
| 项目模板（Archetype）	 |    快速生成项目结构（如 maven-archetype-quickstart）     |
|      多模块支持	      |              适用于大型项目，可以拆分为多个子模块               |
|      插件扩展	       | 支持自定义构建任务（如 maven-compiler-plugin 指定 Java 版本） |

### 依赖管理
1.      <!-- OkHttp 依赖 -->
        <dependency>
            <groupId>com.squareup.okhttp3</groupId>
            <artifactId>okhttp</artifactId>
            <version>4.12.0</version>
        </dependency>
    注意：报红不是问题；点刷新啊 下载包；存在C:\Users\dellpc\.m2\repository
    如果报黄 应该是版本不新 ；https://central.sonatype.com/ 中央仓库去找
2. 