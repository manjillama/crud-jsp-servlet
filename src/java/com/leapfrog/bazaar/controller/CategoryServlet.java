/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leapfrog.bazaar.controller;

import com.leapfrog.bazaar.entity.Category;
import com.leapfrog.bazaar.service.CategoryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manjil Tamang
 */
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService=new  CategoryService();
    @Override
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            Boolean dispatch=true;
            String page="/WEB-INF/jsp/admin/category/index.jsp";
            if(request.getRequestURI().toLowerCase().contains("/add")){
                page="/WEB-INF/jsp/admin/category/add.jsp";
            }
            else if(request.getRequestURI().toLowerCase().contains("/edit")){
                
                if(request.getParameter("id")==null || request.getParameter("id").isEmpty()){
                    response.sendRedirect(request.getContextPath() + "/Admin/Category?error");
                    dispatch=false;
                   
                }
                page="/WEB-INF/jsp/admin/category/edit.jsp";
                int id=Integer.parseInt(request.getParameter("id"));
                request.setAttribute("category", categoryService.getById(id));
                
            }
            else if(request.getRequestURI().toLowerCase().contains("/delete")){
                if(request.getParameter("id")==null || request.getParameter("id").isEmpty()){
                    response.sendRedirect(request.getContextPath() + "/Admin/Category?error");
                   
                   
                }
                int id=Integer.parseInt(request.getParameter("id"));
                
                categoryService.delete(id);
                response.sendRedirect(request.getContextPath() + "/Admin/Category?success");
                 dispatch=false;
            }
            else{
                
                request.setAttribute("categories", categoryService.getAll());
            }
            
            if(dispatch){
                request.getRequestDispatcher(page).forward(request, response);
            }
            
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            Category category=new Category();
            category.setName(request.getParameter("name"));
            category.setDescription(request.getParameter("description"));
            category.setStatus(false);

            if(request.getParameter("status")!=null){
               
               category.setStatus(true); 
                
            }
 
                try{
                    int result=0;
                    if(request.getParameter("id")==null)
                    {
                        result=categoryService.insert(category);
                    }
                    else{
                        int id=Integer.parseInt(request.getParameter("id"));
                        category.setId(id);
                        result=categoryService.update(category);
                    }
                    if(result>0){
                        response.sendRedirect(request.getContextPath() + "/Admin/Category?success");
                    }
                    else{
                        response.getWriter().println("I am here");
                        ////response.sendRedirect(request.getContextPath() + "/Admin/Category/edit?error");
                    }

                }catch(Exception ex){
                    response.getWriter().println(category.toString());
                    //response.sendRedirect(request.getContextPath() + "/Admin/Category/Add?error");
                }



            }
    }

    


