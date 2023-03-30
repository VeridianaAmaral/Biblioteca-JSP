package com.projetobiblioteca.controle;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetobiblioteca.dao.util.Conexao;

/**
 * Servlet implementation class IndexControle
 */
@WebServlet("/publica")
public class IndexControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexControle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "novo":
				novoUsuario(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	
	private void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Connection conexaoJDBC = Conexao.getConexao();
		//apenas para teste
		if (conexaoJDBC != null) {
			System.out.println("Conexão Aberta");
		}else {
			System.out.println("Sem conexão");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		dispatcher.forward(request, response);
	}

}
