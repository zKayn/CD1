package control;

import dao.DAO;
import entity.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="AddControl", urlPatterns={"/Add"})
public class AddControl extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        //Tài khoản
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Đánh giá
        String namemovies = request.getParameter("namemovies");
        String content = request.getParameter("content");
        String score = request.getParameter("score");
        //Thông tin phim
        String nameinfomovies = request.getParameter("nameinfomovies");
        String performer = request.getParameter("performer");
        String director = request.getParameter("director");
        String country = request.getParameter("country");
        String year = request.getParameter("year");
        String time = request.getParameter("time");
        String series = request.getParameter("series");
        String summary = request.getParameter("summary");
        //Phim
        String images = request.getParameter("images");
        String Link = request.getParameter("Link");
        String genre = request.getParameter("genre");
        String catalog = request.getParameter("catalog");
        //Thể loại
        String nametype = request.getParameter("nametype");
        //Danh mục
        String namecatalog = request.getParameter("namecatalog");
        
        if(username != null & password !=null){
            dao.themAdTaiKhoan(username, password);
        }if(username != null & namemovies != null & content != null & score != null){
            dao.themAdDanhGia(username, namemovies, content, score);
        }if(nameinfomovies != null & performer != null & director != null & country != null & year != null & time != null & series != null){
            dao.themAdThongTinPhim(nameinfomovies, performer, director, country, year, time, series, summary);
        }if(images != null & Link != null & genre != null & catalog != null){
            dao.themAdPhim(namemovies,"./Image/"+ images,"./Video/"+ Link);
            dao.themAdTheLoaiPhim(genre);
            dao.themAdDanhMucPhim(catalog);
        }if(nametype != null){
            dao.themAdTheLoai(nametype);
        }if(namecatalog != null){
            dao.themAdDanhMuc(namecatalog);
        }
        
        response.sendRedirect("Admin");
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
