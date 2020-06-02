package com.util.image.upload;

import com.util.image.uploadPathMaker.PathDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UploaderTest {
    public UploaderTest(){
        System.out.println("UploaderTest");
    }

    @Autowired
    @Qualifier("amazonConcept")
    private Uploader uploader;

    @Test
    public void testUpload(){
        File file = new File("file\\suzi.jpg");

        uploader.upload(PathDefinition.AWS_THUMBNAIL.getFullFilePath(),file);
    }
}
