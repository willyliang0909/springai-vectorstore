##  couchbase vector store

### prerequisitesPrerequisites
```shell
docker run -d --name couchbase-spring-ai -p 8091-8096:8091-8096 -p 11210-11211:11210-11211 couchbase:enterprise-7.6.5
```

<br>

**application.properties**
```properties
spring.couchbase.connection-string=${COUCHBASE_CONNECTION_STRINGS:localhost}
spring.couchbase.username=${COUCHBASE_USERNAME:admin}
spring.couchbase.password=${COUCHBASE_PASSWORD:couchbase}

#init bucket, scope, collection, index
spring.ai.vectorstore.couchbase.initialize-schema=true
```
initialize-schema: 讓spring自動生成bucket等必要couchbase設定

<br>

**CouchbaseSearchVectorStore default config**

|Property|Default|
|--|--|
|spring.ai.vectorstore.couchbase.index-name|spring-ai-document-index|
|spring.ai.vectorstore.couchbase.bucket-name|default|
|spring.ai.vectorstore.couchbase.scope-name|default|
|spring.ai.vectorstore.couchbase.collection-name|default|
|spring.ai.vectorstore.couchbase.dimensions|1536|
|spring.ai.vectorstore.couchbase.similarity|dot_product|
|spring.ai.vectorstore.couchbase.optimization|recall|




