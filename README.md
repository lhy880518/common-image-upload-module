# common-image-upload-module

## 사용법(UploadTest.java 참조)
```
    @Autowired
    @Qualifier("amazonConcept")
    private Uploader uploader;
    
    File file = new File("file\\suzi.jpg");
    
    uploader.upload(PathDefinition.AWS_THUMBNAIL.getFullFilePath(),file);
```

## Q&A
Q. Amazon S3이외 업로드 객체를 사용하려면?  
A. com.util.image.upload.implementation 다른 모듈용 객체 추가 및 upload 구현

Q. upload path 룰이 변경되면?  
A. public abstract String getFullFilePath(); 를 [오버로딩](https://brunch.co.kr/@kimkm4726/2)하여 룰을 추가 한다.

Q. 데이터베이스 Insert 시점은 언제인가.  
A. 파일업로드 api와 데이터 insert api를 같이 사용하지 않고 분리해서 사용할 예정

Q. Validation Check는 어떻게 할 것인가.  
A. File null check는 spring validation을 사용할 예정이나 확장자 체크 혹은 이외의 체크들은 추가로 만들어서 api호출시점에 체크하여 리턴을 하는 방식으로 할 예정

Q. 

# 참고 사이트
1. https://brunch.co.kr/@kimkm4726/2