package com.yuanbao.park.entity;

/**
 * @author: CrazyZhou
 * @description: 图片上传实体类
 * @date: 2018-06-28 10:18
 * @param:
 */
public class FileInfoData {
    private String fileName;

    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    //图片大小
    private Long size;

    //图片尺寸
    private String measurements;

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMeasurements() {
        return measurements;
    }

    public Long getSize() {
        return size;
    }
}
