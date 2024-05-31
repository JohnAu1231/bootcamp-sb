### Spring boot
- @SpringBootApplication
- @ComponetScan
- @Component, @Controller, @Serivce, @Configurtation
- @Bean
- @Autowired
- @GetMapping, @PostMapping
- @RequestParam, @PathVariable
- @JsonProperty(DTO)
- @RestController (@ResponseBody, @Controller)
- @PostConstruct (run after bean creation, before server start completed)
- @RestControllerAdvie (@ControllerAdive + @ResponseBody)
- @ExceptionHandler
- @SpringBootTest, @WebMvcTest, @MockBean, @SpyBean
- mockMvc.perform(), andExpect()
- @Value


### Spring boot  (Spring) vs Java
- Spring Context & Bean , DI& IOC (Dependency Injection & Inversion of Control)
- Global Exception Handing (Parent Concept - Exception.class, RuntimeException.class)
- Auto Deserialization (JSON to Java Object) & Serialization (Java Object to JSON)
- application.yml
- Data Transfer Object (DTO)

### Lombok (Maven Project Java/Spring boot)
- @Data (@Getter, @Setter, toString, @RequireArgsConstrucotr)
- @ToString
- @Getter
- @Setter
- @AllArgsConstructor
- @noArgsConstructor
- @EqualAndHashCode

### Others
- Custom Libraries (infra folder)
  - ApiResp.class
  - UrlBuilder.class
  - BusinessRuntimeException.calss, SysCode.class
  - GlobalExceptionHandler.class

- Mockito, Junit5, Hamcrest
- @Mock, @Spy, @InjectMock, @BeforeAll, @BeforeEach, @AfterAll, @AfterEach
- Mockitio.when().thenResult(), verify(), asserThat, etc.
- RestTemplate
