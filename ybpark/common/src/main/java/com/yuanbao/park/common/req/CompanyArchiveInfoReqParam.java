package com.yuanbao.park.common.req;

/**
 * @author: CrazyZhou
 * @description: 企业资料信息视图层实体类
 * @date: 2018-07-08 10:35
 * @param:
 */
public class CompanyArchiveInfoReqParam {

    private String archiveName;

    private String archiveUrl;

    private Long companyId;

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
