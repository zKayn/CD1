package control;

import dao.DAO;
import entity.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="HomeControl", urlPatterns={"/Home"})
public class HomeControl extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //B1: get data from dao
    	DAO dao = new DAO();
        List<TheLoai> listTL = dao.getAllTheLoai();
        List<DanhMuc> listDM = dao.getAllDanhMuc();
        List<TopPhimMoi> listTop5PM = dao.getTop5PhimMoi();
        List<TopPhimMoi> listTop10PM = dao.getTop10PhimMoi();
        List<TopPhimMoi> listPLM = dao.getPhimLeMoi();
        List<PhimSeries> listPSM = dao.getPhimSeriesMoi();
        List<TopPhimMoi> listPHHM = dao.getPhimHoatHinhMoi();
        List<TopPhimMoi> listPNN = dao.getPhimNgauNhien();
		
    	//B2: set data to jsp
        request.setAttribute("listTheLoai", listTL);
        request.setAttribute("listDanhMuc", listDM);
        request.setAttribute("listTop5PM", listTop5PM);
        request.setAttribute("listTop10PM", listTop10PM);
        request.setAttribute("listPLM", listPLM);
        request.setAttribute("listPSM", listPSM);
        request.setAttribute("listPHHM", listPHHM);
        request.setAttribute("listPNN", listPNN);
        
        request.getRequestDispatcher("./html/home.jsp").forward(request, response);
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
