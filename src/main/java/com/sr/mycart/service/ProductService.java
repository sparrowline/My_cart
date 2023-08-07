package com.sr.mycart.service;

import java.util.List;

import com.sr.mycart.Dao.ProductDao;
import com.sr.mycart.dto.Product;

public class ProductService {
	
	ProductDao dao = new ProductDao();
	
	public Product saveProduct(Product product) {
		return dao.saveProduct(product);
		
	}
	
	public List<Product> getAllProductsById(int cid){
		return dao.getAllProductsById(cid);
	}
}
