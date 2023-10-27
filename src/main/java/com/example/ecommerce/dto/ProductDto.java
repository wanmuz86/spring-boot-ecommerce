package com.example.ecommerce.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

@Data
public class ProductDto {

    private Long id;

    private  String name;
    private Double price;

    private String description;
   // private byte[] byteImg;

    private Long categoryId;

  //  private Blob img;
}
