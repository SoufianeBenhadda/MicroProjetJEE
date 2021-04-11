package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import models.Article;

/**
 * Servlet implementation class CategorieServlet
 */

public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Database data=new Database();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String categorie = request.getParameter("categorie");
		if(categorie==null) {
			categorie="1";
		}
		
		List<Article> articles = data.getArticlesByCat(categorie);
		request.setAttribute("articles", articles);
		request.setAttribute("cat", categorie);
		
		request.getRequestDispatcher("Display.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
