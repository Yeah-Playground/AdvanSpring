# AdvanSpring
Spring을 독학해보면서 작성한 프로젝트입니다.
어떤 목적보다는 Spring에 있는 여러 기능을 살펴보기 위해 작성되었습니다.

## Dependency
`@RestController`, `@GetMapping` 등의 web 기능을 이용하려면 아레의 dependency가 필요함
```kt
implementation("org.springframework.boot:spring-boot-starter-web")
```

## Reference
까먹을때마다 참고할 수 있는 index

- HTTP Request Handling
  - GET 요청 : [HelloController](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/controller/HelloController.kt)
  - POST 요청 : [PostController](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/controller/PostController.kt)
  - PUT 요청 : `@PutMapping`
  - Delete 요청 : `@DeleteMapping`
- Database
  - DTO : [ProductDto](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/dto/ProductDto.kt)
  - Entity : [ProductEntity](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/entity/ProductEntity.kt)
  - DAO :
    - [ProductDao](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/dao/ProductDao.kt)
    - [ProductDaoImpl](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/dao/impl/ProductDaoImpl.kt)
  - Repository : [ProductRepository](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/repository/ProductRepository.kt)
  - Service :
    - [ProductService](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/service/ProductService.kt)
    - [ProductServiceImpl](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/service/impl/ProductServiceImpl.kt) 
  - Controller : [ProductController](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/controller/ProductController.kt)
- Logging : [HelloController](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/kotlin/io/yeahx4/advanspring/controller/HelloController.kt)
- Validation : TBD
- Exception : TBD
- Test
  - Test : TBD
  - Coverage : TBD

## Tips
1. [application.properties](https://github.com/Yeah-Playground/AdvanSpring/blob/master/src/main/resources/application.properties)
```properties
spring.jpa.hibernate.ddl-auto=update
```
  - create : DROP + CREATE (for local)
  - create-drop : DROP + CREATE + DROP(종료) (for local)
  - update : 변경내용만 반영 (not for prod)
  - validate : Entity-table 비교 (prod)
  - none

2. `@PostMapping` 관련 문제
- 404 : 만약 `@PostMapping("/")` 라면 요청한 URL이 `/`로 끝나는지 확인할 것. (ex. `example.com/product/`)
- 403 : CSRF 비활성화
```kt
implementation("org.springframework.boot:spring-boot-starter-security")
```
```kt
@Configuration
class SpringConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()

        return http.build()
    }
}
```
