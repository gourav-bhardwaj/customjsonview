## Jackson’s @JsonView in a Spring Boot Application

### Use cases for @JsonView
- Protect sensitive information being exposed
- Allow control over the data expose
- Separate views for the Http Request Methods

### Steps:
- In ObjectMapper, disable MapperFeature.DEFAULT_VIEW_INCLUSION otherwise the non-annotated field will also serialize.
- Create an interface with name 'Views' for different views of a DTO. Here you can create DTO based view interfaces like UserViews, EmployeeViews etc.
- Now above all DTO fields you can use @JsonView annotation with view class type.

*For More Information Visit https://reflectoring.io/jackson-jsonview-tutorial/*

