package com.saymeevetime;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.junit.jupiter.api.Test;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

/**
 *
 * @author jiacheng
 * @date 28/8/25 23:35 Thursday
 * @description :
 *
 */
public class RAGTest {

    @Test
    public void testReadDocument() {
        //使用FileSystemDocumentLoader读取指定目录下的知识库文档
        //并使用默认的文档解析器TextDocumentParser对文档进行解析
        Document document = FileSystemDocumentLoader.loadDocument("/Users/mesay/imooc/xiaozhi/langchain4j_hospital/langchain4j_hospital/src/main/resources/2022.txt");
        System.out.println(document.text());


        // 加载单个文档
//        Document document = FileSystemDocumentLoader.loadDocument("E:/knowledge/file.txt",new TextDocumentParser());
        // 从一个目录中加载所有文档
//        List<Document> documents = FileSystemDocumentLoader.loadDocuments("E:/knowledge", new TextDocumentParser());

        // 从一个目录中加载所有的.txt文档
//        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

//        List<Document> documents = FileSystemDocumentLoader.loadDocuments("E:/knowledge", pathMatcher,new TextDocumentParser());
        // 从一个目录及其子目录中加载所有文档
//        List<Document> documents = FileSystemDocumentLoader.loadDocumentsRecursively("E:/knowledge", new TextDocumentParser());

    }

    @Test
    public void testParsePDF() {
        Document document = FileSystemDocumentLoader.loadDocument(
                "E:/knowledge/医院信息.pdf",
                new ApachePdfBoxDocumentParser()
        );
        System.out.println(document);
    }


}
