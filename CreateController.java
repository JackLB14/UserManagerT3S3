/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {
    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "admin.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkValidation=true;
        UserError userError= new UserError();
        try {
            String userID= request.getParameter("userID");
            String fullName= request.getParameter("fullName");
            String roleID= request.getParameter("roleID");
            String password= request.getParameter("password");
            String confirm= request.getParameter("confirm");
            UserDAO dao =new UserDAO();
            //validation cow banr
            boolean checkDuplicate= dao.checkDuplicate(userID);
            if(checkDuplicate){
                checkValidation = false;
                userError.setUserIDError("Duplicate UserID !!!!!");
            }
            if(!password.equals(confirm)){
                userError.setPasswordError("Password khong khop");
                checkValidation = false;
            }
            if(fullName.length()>20 || fullName.length()<5){
                userError.setFullNameError("Full Name is in range [5-20]");
                checkValidation = false;
            }
            //xong check validaton co ban -> bao loi ve cho user neu co
            if(checkValidation){
                UserDTO user = new UserDTO(userID, fullName, roleID, password);
                boolean checkInsert = dao.insert(user);
                if(checkInsert){
                    url= SUCCESS;
                }
            }else{
                request.setAttribute("USER_ERROR", userError);
            }
        }catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
