package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import db.DB;

public class Metodos {
	
	public String menu() {
		
		String[] options = {"Emprestimo","Administrador","Devolução"};
		String m = (String) JOptionPane.showInputDialog(null,"Selecione um perfil","Livraria",
				JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
		
		return m;
	}
	
	
	
	
//////////////////////////////////// EMPRESTIMO	
	
	public static String e2;
	public String emprestimo() {
		

		ArrayList<String> livros = new ArrayList<>(); 
		
		
		Connection conn = null;
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from livros");
			
			while(rs.next()) {
				livros.add((rs.getString("nome")));
			}
			
			String[] options = livros.toArray(new String[livros.size()]);
			e2 = (String) JOptionPane.showInputDialog(null,"Livros disponíveis","Livraria",
					JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
			
			JOptionPane.showMessageDialog(null, "Você escolheu o livro: "+e2);
			
			st.executeUpdate("INSERT into emprestimo (emprestimos) values ('"+e2+"');");
			
			st.executeUpdate("DELETE from livros where nome = "+"'"+e2+"'");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deu n");
		
		}
		finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
			
		}		
		System.out.println(e2);
		return e2;
		
	}
	
	
////////////////////////////////////////// DEVOLUÇÃO
	public String devolucao() {
		

		ArrayList<String> livros = new ArrayList<>(); 
		
		
		Connection conn = null;
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from emprestimo");
			
			while(rs.next()) {
				livros.add((rs.getString("emprestimos")));
			}
			
			String[] options = livros.toArray(new String[livros.size()]);
			e2 = (String) JOptionPane.showInputDialog(null,"Livros emprestados: ","Livraria",
					JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
			
			JOptionPane.showMessageDialog(null, "Você devolveu o livro: "+e2);
			
			st.executeUpdate("INSERT into livros (nome) values ('"+e2+"');");
			
			st.executeUpdate("DELETE from emprestimo where emprestimos = '"+e2+"'");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deu n");
		
		}
		finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
			
		}		
		System.out.println(e2);
		return e2;
		
		
	}
	
	
	
////////////////////////////////////////// SELECT
public void consulta() {
	Connection conn = null;
	
	Statement st = null;
	ResultSet rs = null;
	
	try {
	conn = DB.getConnection();
	st = conn.createStatement();
	
	//COMANDO SQL PARA FAZER BUSCA E GUARDAR NA VARIAVEL RS
	rs = st.executeQuery("select * from livros");
	//IMPRIME AS LINHAS DO RS
	while(rs.next()) {
	System.out.println(rs.getInt("ID")+", "+rs.getString("nome"));
	
	}
	}
	catch (SQLException e) {
	e.printStackTrace();
	}
	finally {
	DB.closeResultSet(rs);
	DB.closeStatement(st);
	DB.closeConnection();
	}
	
}

///////////////////////////////////////////////////////////////////////////// DELETE
public void delete(int id) {
	


	ArrayList<String> livros = new ArrayList<>(); 
	
	
	Connection conn = null;
	
	Statement st = null;
	ResultSet rs = null;
	
	
	try {
		conn = DB.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery("select * from livros");
		
		while(rs.next()) {
			livros.add((rs.getString("nome")));
		}
		
		String[] options = livros.toArray(new String[livros.size()]);
		e2 = (String) JOptionPane.showInputDialog(null,"Escolha um livro para EXCLUIR","Livraria",
				JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		
		JOptionPane.showMessageDialog(null, "Você DELETOU o livro: "+e2);
		
		st.executeUpdate("DELETE from livros where nome = '"+e2+"'");
		
	}
	catch (SQLException e) {
		e.printStackTrace();
		}
	finally {
		
		DB.closeResultSet(rs);
		DB.closeStatement(st);
		DB.closeConnection();
		
	}		
	System.out.println(e2);


}
////////////////////////////////////////////////////////////////////// INSERT
	public void insert() {
	
	Connection conn = null;
	Statement st = null;

	
	try {
	conn = DB.getConnection();
	st = conn.createStatement();
	
	
	String nlivro = JOptionPane.showInputDialog("Digite o nome do livro que deseja inserir:");
	System.out.println(nlivro);
	
	st.executeUpdate("INSERT into livros (nome) values ('"+nlivro+"');");
	
	JOptionPane.showMessageDialog(null,"Você adicionou o livro: "+nlivro+" ao sistema.");
	
	
	
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
	DB.closeStatement(st);
	DB.closeConnection();
	
	}
	
}
///////////////////////////////////////////////////////////////////// UPDATE	
	public void update() {


		ArrayList<String> livros = new ArrayList<>(); 
		
		
		Connection conn = null;
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from livros");
			
			while(rs.next()) {
				livros.add((rs.getString("nome")));
			}
			
			String[] options = livros.toArray(new String[livros.size()]);
			e2 = (String) JOptionPane.showInputDialog(null,"Escolha um livro para EDITAR","Livraria",
					JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
			
			String elivro = JOptionPane.showInputDialog("Digite o novo nome:");
			
			
			JOptionPane.showMessageDialog(null, "Você EDITOU o livro: "+e2+"  PARA: "+elivro);
			
			st.executeUpdate("UPDATE livros set nome = \""+elivro+"\" where nome = \""+e2+"\";");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
			
		}		
		System.out.println(e2);

	}
////////////////////////////////////////////////////////////////////
}