/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leapfrog.bazaar.service;

import com.leapfrog.bazaar.dao.CategoryDAO;
import com.leapfrog.bazaar.dao.impl.CategoryDAOImpl;
import com.leapfrog.bazaar.entity.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Manjil Tamang
 */
public class CategoryService {
    private CategoryDAO categoryDAO=new CategoryDAOImpl();
    
    public int insert(Category c) throws ClassNotFoundException, SQLException{
        return categoryDAO.insert(c);
    }
    
    public int update(Category c) throws ClassNotFoundException, SQLException{
        return categoryDAO.update(c);
    }   

    public int delete(int id) throws ClassNotFoundException, SQLException{
        return categoryDAO.delete(id);
    }
    
    public List<Category> getAll() throws ClassNotFoundException, SQLException{
        return categoryDAO.getAll();
    }
    
    public Category getById(int id) throws ClassNotFoundException, SQLException{
        return categoryDAO.getById(id);
    }    
    
}
