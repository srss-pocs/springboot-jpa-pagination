package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.jpa.entity.Product;
import com.example.jpa.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	public Product getProduct(int id) {
		return productRepository.findById(id).get();
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product updateProduct(Product productRequest) {
		return productRepository.save(productRequest);
	}

	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "product deleted";
	}
	
	public List<Product> findAllProducts() {
        return productRepository.findAll();
    }


    public List<Product> findProductsWithSorting(String field){
        return  productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Product> findProductsWithPagination(int offset,int pageSize){
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  products;
    }

}