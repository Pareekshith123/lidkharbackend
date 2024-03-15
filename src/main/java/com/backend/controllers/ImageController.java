package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.Dtos.ImagesDto;
import com.backend.service.ImagesService;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImagesService imagesService;

    @PostMapping("/upload/{productId}")
    public ResponseEntity<ImagesDto> uploadImage(@RequestParam("file") MultipartFile file ,@PathVariable Long productId) {


        ImagesDto imagesDto = imagesService.createImages(file,productId);
        return new ResponseEntity<>(imagesDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ImagesDto>> getAllImages() {

        List<ImagesDto> imagesDtoList = imagesService.getAllImages();
        return new ResponseEntity<>(imagesDtoList, HttpStatus.OK);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<ImagesDto> getImageById(@PathVariable Long imageId) {


     try {
    	   ImagesDto imagesDto = imagesService.getImageById(imageId);
           return new ResponseEntity<>(imagesDto, HttpStatus.OK);
	} catch (Exception e) {
       return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable Long imageId) {


        String message = imagesService.deleteImage(imageId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
