package com.example.test.service;

import com.example.test.model.Product;
import com.example.test.repository.ProductRepository;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Service
public class ProductService {
    @Autowired
    public ProductRepository repository;

    public void saveProduct(Product product) throws IOException, ZipException {
        Logger logger = LoggerFactory.getLogger(ProductService.class);
        StringBuilder sb = new StringBuilder();
        sb.append("Test String");

        File f = new File("C:\\Users\\payam\\Projects\\test\\test.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry e = new ZipEntry("mytext.txt");
        out.putNextEntry(e);

        byte[] data = sb.toString().getBytes();
        out.write(data, 0, data.length);
        unzip1();
        out.closeEntry();

        out.close();
        product.setFile(data);
        logger.info("dsfasdfasdfasdfadsfadsf");
        repository.save(product);
    }

    public void unzip1() throws ZipException {
        String zipFilePath = "C:\\Users\\payam\\Projects\\test\\test\\zip-files";

        String destDir = "C:\\Users\\payam\\Projects\\test\\test\\unzipped-files";
        ZipFile zipFile = new ZipFile(zipFilePath + "\\" + "test.zip");
        zipFile.extractAll(destDir);

    }
    public void unzip() throws IOException {
        String zipFilePath = "C:\\Users\\payam\\Projects\\test\\test\\zip-files";

        String destDir = "C:\\Users\\payam\\Projects\\test\\test\\unzipped-files";

        FileInputStream fis = new FileInputStream(zipFilePath + "\\" + "test.zip");
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry ze = zis.getNextEntry();
        String fileName = ze.getName();
        File newFile = new File(destDir + "\\" + fileName);
        System.out.println("Unzipping to " + newFile.getAbsolutePath());
        //create directories for sub directories in zip
        new File(newFile.getParent()).mkdirs();
        FileOutputStream fos = new FileOutputStream(newFile);
        int len;
        byte[] buffer = new byte[1024];
        while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        //close this ZipEntry
        zis.closeEntry();
        ze = zis.getNextEntry();
    }
    public List<Product> getProducts(){
        return repository.getProductsByStoredProcedure();
    }
}
