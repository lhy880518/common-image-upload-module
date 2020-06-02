package com.util.image.uploadPathMaker;

import com.util.image.uploadPathMaker.builder.Main;
import com.util.image.uploadPathMaker.builder.Resource;
import com.util.image.uploadPathMaker.builder.Root;
import com.util.image.uploadPathMaker.builder.Sub;

public enum PathDefinition {

    AWS_THUMBNAIL{
        public String getFullFilePath(){
            Resource resource = new Resource.Builder(Root.ISW_PRIVATE)
                    .with(Main.USER, null)
                    .with(Sub.THUMBNAIL, null)
                    .build();

            return resource.getFullPath();
        }
    };

    public abstract String getFullFilePath();
}
