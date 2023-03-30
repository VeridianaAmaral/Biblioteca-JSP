package com.projetobiblioteca.controle;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetobiblioteca.controle.util.ManipulacaoData;
import com.projetobiblioteca.dao.util.Conexao;
import com.projetobiblioteca.modelo.Usuario;

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
			case "inserir":
				gravarUsuario(request, response);
			break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	
	private void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void gravarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		String data = request.getParameter("nascimento");
		
		ManipulacaoData manipulacaoData = new ManipulacaoData();
		Date dataNascimento = manipulacaoData.converterStringData(data);
		
		Usuario usuario = new Usuario(nome, cpf, dataNascimento, email, password, login, false);
		
		System.out.println(usuario);
		
		
	}

}
