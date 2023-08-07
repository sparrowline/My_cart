package com.sr.mycart.service;

import java.util.List;

import com.sr.mycart.Dao.CategoryDao;
import com.sr.mycart.dto.Category;

public class CategoryService {
	
	CategoryDao categoryDao = new CategoryDao();
	
	public Category saveCategory(Category category) {
		  return categoryDao.saveCategory(category);
		}
	
	
	public List<Category> displayCategory(){
		return categoryDao.displayCategory();
	}
	
	public Category getCategoryById(int cid) {
		return categoryDao.getCategoryById(cid);
	}
	
	
	

}
