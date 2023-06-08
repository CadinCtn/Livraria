package application;
import javax.swing.JOptionPane; 
public class Pane {

public String telinha() {

    String[] options = {"SELECT", "DELETE", "UPDATE", "INSERT"};
    //ImageIcon icon = new ImageIcon("src/images/image");
     String n = (String)JOptionPane.showInputDialog(null, "BANCO DE DADOS", 
            "SISTEMA BIBLIOTECA", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
    //System.out.println(n);
    return n;
}

}
