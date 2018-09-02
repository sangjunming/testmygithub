package com.yuanbao.park.common.req;


public class CompanyServerReqParam extends BasePageReqParam {
	
    private Long id;

    private Long parkId;
    
    private String keyword;
    
    private String name;

    private String photo;

    private String serviceTitle;
    
    private String successedCase;

    private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParkId() {
		return parkId;
	}

	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public String getSuccessedCase() {
		return successedCase;
	}

	public void setSuccessedCase(String successedCase) {
		this.successedCase = successedCase;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
   
 }