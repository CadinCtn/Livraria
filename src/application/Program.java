package application;



public class Program {

	public static void main(String[] args) {
		Metodos banco = new Metodos();
		Metodos emp = new Metodos();
		Metodos dev = new Metodos();
		//while(1<2) {
		switch (banco.menu()) {
		case "Administrador": 
			

			Pane tela = new Pane();
			/////////////////////////////////////////////////////// TELA
			String x = tela.telinha();
			
			switch (x) {
			
			case "SELECT":
			banco.consulta();
			break;
			case "UPDATE":
			
				banco.update();
			break;
			case "INSERT":
				banco.insert();
			break;
			case "DELETE":
				int id = 0;// O NUMERO DO ID PARA SER REMOVIDO NA TABELA DO BANCO
				banco.delete(id);//Id
			break;
			}
			
			break;
			
			
		case "Emprestimo": 
			
			emp.emprestimo();
			break;
			
		case "Devolução":
			dev.devolucao();
			
		}
		
		
		//}
	
	}

}