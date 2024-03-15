package com.backend.Dtos;


public class ImagesDto {

    private Long imageId;
    private String name;
    private String path;
    
	public ImagesDto() {
		super();
	}

	public ImagesDto(Long imageId, String name, String path) {
		super();
		this.imageId = imageId;
		this.name = name;
		this.path = path;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
}
