package com.test.springai.vectorstore.reader;

import org.springframework.ai.document.Document;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import java.util.List;

public interface MyDocumentReader {

    List<Document> read(Resource resource);

    default List<Document> read(String path) {
        Resource resource = new PathResource(path);
        return read(resource);
    }
}
