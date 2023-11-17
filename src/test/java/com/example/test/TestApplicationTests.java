package com.example.test;

import com.example.test.model.Product;
import com.example.test.service.ProductService;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class TestApplicationTests {
@Autowired
protected ProductService productService;
	@Test
	void contextLoads() throws IOException, ZipException {
		productService.	saveProduct(new Product("sdfsadfasdfa"));
	}
	@Test
	void getProducts() throws IOException, ZipException {
		productService.getProducts();
	}
}
