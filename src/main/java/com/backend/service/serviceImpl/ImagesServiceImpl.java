package com.backend.service.serviceImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.Dtos.ImagesDto;
import com.backend.Entities.Images;
import com.backend.Entities.Products;
import com.backend.repository.ImagesRepo;
import com.backend.repository.ProductsRepo;
import com.backend.service.ImagesService;

@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesRepo imagesRepo;


    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private ProductsRepo productsRepo;

    @Override
    public ImagesDto createImages(MultipartFile file,Long productId) {
        try {
        Products products = this.productsRepo.findById(productId)
        		 .orElseThrow(() -> new RuntimeException("Image not found with id: " + productId));;
            String directoryPath = "C:\\LidkarImages";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate a unique file name
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            // Save the file to the directory
            Path filePath = Paths.get(directoryPath, fileName);
            Files.write(filePath, file.getBytes());

            // Save the image path to the database
            Images image = new Images();
            image.setName(fileName); // You may want to change this to something more descriptive
            image.setPath(filePath.toString());
            image.setProduct(products);
            Images savedImage = imagesRepo.save(image);

            return modelMapper.map(savedImage, ImagesDto.class);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to save image: " + ex.getMessage());
        }
    }


    @Override
    public ImagesDto updateImages(Long imageId, ImagesDto imagesDto) {

        Images image = imagesRepo.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + imageId));

        image.setName(imagesDto.getName());
        image.setPath(imagesDto.getPath());

        Images updatedImage = imagesRepo.save(image);

        return modelMapper.map(updatedImage, ImagesDto.class);
    }

    @Override
    public List<ImagesDto> getAllImages() {
        List<Images> images = imagesRepo.findAll();

        return images.stream()
                .map(image -> modelMapper.map(image, ImagesDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ImagesDto getImageById(Long imageId) {
        Images image = imagesRepo.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + imageId));

        return modelMapper.map(image, ImagesDto.class);
    }

    @Override
    public String deleteImage(Long imageId) {
        Images image = imagesRepo.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + imageId));

        imagesRepo.delete(image);

        return "Image deleted successfully";
    }
}
