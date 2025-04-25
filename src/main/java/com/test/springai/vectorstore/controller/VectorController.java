package com.test.springai.vectorstore.controller;

import com.test.springai.vectorstore.service.ETLService;
import com.test.springai.vectorstore.service.VectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VectorController {

    private final VectorService vectorService;

    private final ETLService etlService;

    @GetMapping("/vectors")
    public List<Document> query(@RequestParam String query) {
        return vectorService.simpleVectorSearch(query);
    }

    @GetMapping("/vectors/add")
    public void addVector() {
        vectorService.addVector();
    }

    @GetMapping("/etl")
    public void etl(@RequestParam String path) {
        etlService.read(path);
    }
}
