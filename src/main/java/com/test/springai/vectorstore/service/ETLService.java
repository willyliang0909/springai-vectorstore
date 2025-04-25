package com.test.springai.vectorstore.service;

import com.test.springai.vectorstore.reader.MyDocumentReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ETLService {

    private final ApplicationContext context;

    public List<Document> read(String path) {
        MyDocumentReader documentReader = context.getBean("defaultPdfDocumentReader", MyDocumentReader.class);

        var docs = documentReader.read(path);

        if (log.isDebugEnabled()) {
            var pages = docs.stream()
                    .map(Document::getText)
                    .toList();

            for (var page: pages) {
                log.debug("-----------");
                log.debug(page);
            }
        }

        return docs;
    }

}
