Simple RESTful example that create or delete registries for Visitor.

Is build on Spring Boot so after compile just run[

´java -jar crud-0.0.1-SNAPSHOT.war´

By default the ´dev´ profile is active so the database is in memory.

You can use the ´prod´ profile for use a PostgreSQL external database, but you  need to configure the ENV variables:

´${CRUD_DB_URL}´ for spring.datasource.url property
´${CRUD_DB_USERNAME}´ for spring.datasource.username property
´${CRUD_DB_PASSWORD}´ for spring.datasource.password property
