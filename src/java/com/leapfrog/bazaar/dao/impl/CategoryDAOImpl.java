/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leapfrog.bazaar.dao.impl;

import com.leapfrog.bazaar.dao.CategoryDAO;
import com.leapfrog.bazaar.dbutil.DbConnection;
import com.leapfrog.bazaar.entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manjil Tamang
 */
public class CategoryDAOImpl implements CategoryDAO {
    private DbConnection connection;
    
    public CategoryDAOImpl(){
        connection=new DbConnection();
    }

    @Override
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
        List<Category> categoryList=new ArrayList<Category>();
        connection.open();
        String sql="SELECT * FROM tbl_categories";
        PreparedStatement stmt=connection.initStatement(sql);
        
        ResultSet rs=connection.executeQuery();
        while(rs.next()){
           Category c=new Category();
           c.setId(rs.getInt("id"));
           c.setName(rs.getString("name"));
           c.setDescription(rs.getString("description"));
           c.setAddedDate(rs.getDate("added_date"));
           if(rs.getDate("modified_date")!=null){
               c.setModifiedDate(rs.getDate("modified_date"));
           }
           c.setStatus(rs.getBoolean("status"));
           
           
           categoryList.add(c);
           
        }
        
        connection.close();
        return categoryList;
        
        
    }

    @Override
    public Category getById(int id) throws ClassNotFoundException, SQLException {
        Category c=null;
        connection.open();
        String sql="SELECT * FROM tbl_categories WHERE id=?";
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs=connection.executeQuery();
        while(rs.next()){
           c=new Category();
           c.setId(rs.getInt("id"));
           c.setName(rs.getString("name"));
           c.setDescription(rs.getString("description"));
           c.setAddedDate(rs.getDate("added_date"));
           if(rs.getDate("modified_date")!=null){
               c.setModifiedDate(rs.getDate("modified_date"));
           }
           c.setStatus(rs.getBoolean("status"));
           
         
           
        }
        
        connection.close();       
        return c;
    }

    @Override
    public int insert(Category c) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="INSERT INTO tbl_categories(name,description,status) VALUES(?,?,?)";
        
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getDescription());
        stmt.setBoolean(3, c.getStatus());
        
        int result=connection.executeUpdate();
        
        connection.close();
        return result;
    }

    @Override
    public int update(Category c) throws ClassNotFoundException, SQLException {
        connection.open();
        String sql="UPDATE tbl_categories SET name=?,description=?,status=? WHERE id=?";
        
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getDescription());
        stmt.setBoolean(3, c.getStatus());
        stmt.setInt(4, c.getId());
        
        int result=connection.executeUpdate();
        
        connection.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
         connection.open();
        String sql="DELETE FROM tbl_categories WHERE id=?";
        System.out.println(sql);
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setInt(1, id);
       
        
        int result=connection.executeUpdate();
        
        connection.close();
        return result;
    }
    
}
