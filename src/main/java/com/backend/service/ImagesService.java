package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.Dtos.CategoryDto;
import com.backend.Dtos.ImagesDto;
@Service
public interface ImagesService {

	ImagesDto createImages(MultipartFile file,Long productId);

	ImagesDto updateImages(Long imageId, ImagesDto ImagesDto);

	    List<ImagesDto> getAllImages();

	    ImagesDto getImageById(Long imageId);

	    String deleteImage(Long imageId);
}
