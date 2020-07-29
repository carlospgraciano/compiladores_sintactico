package analizador;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_cup.runtime.Symbol;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.StringReader;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntrada;
	private JTextArea txtSalidaLex;
	private JTextArea txtSalidaSin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setResizable(false);
		setTitle("Analizador sintactico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEntrada = new JTextField();
		txtEntrada.setFont(new Font("Tahoma", Font.PLAIN, 34));
		txtEntrada.setBounds(10, 54, 379, 47);
		contentPane.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Limpiar ambos text areas (Lexico y sintactico) */
				txtSalidaLex.setText("");
				txtSalidaSin.setText("");
				
				/* Ejecutar el analizador léxico */
				try {
					analizarLexico();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				analizadorSintactico();
			}
		});
		btnAnalizar.setBounds(399, 54, 213, 47);
		contentPane.add(btnAnalizar);
		
		txtSalidaLex = new JTextArea();
		txtSalidaLex.setEditable(false);
		txtSalidaLex.setBounds(10, 164, 288, 307);
		contentPane.add(txtSalidaLex);
		
		JLabel lblAnalizador = new JLabel("Analizador");
		lblAnalizador.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblAnalizador.setBounds(206, 11, 184, 32);
		contentPane.add(lblAnalizador);
		
		txtSalidaSin = new JTextArea();
		txtSalidaSin.setEditable(false);
		txtSalidaSin.setBounds(324, 164, 288, 307);
		contentPane.add(txtSalidaSin);
		
		JLabel lblNewLabel = new JLabel("Analizador l\u00E9xico");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(62, 112, 190, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnalizadorSintctico = new JLabel("Analizador sint\u00E1ctico");
		lblAnalizadorSintctico.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAnalizadorSintctico.setBounds(359, 112, 221, 41);
		contentPane.add(lblAnalizadorSintctico);
	}
	
	private void analizadorSintactico() {
		String ST = txtEntrada.getText();
		Sintax s = new Sintax(new analizador.LexerCup(new StringReader(ST)));
		
		try {
			Object resultado = s.parse().value;
			txtSalidaSin.setText("Análisis realizado correctamente \n" + ST + " RESULTADO = " + resultado);
			txtSalidaSin.setForeground(new Color(25, 111, 61));
		} catch (Exception e) {
			Symbol sym = s.getS();
			txtSalidaSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
			txtSalidaSin.setForeground(Color.red);
		}
	}
	
	private void analizarLexico() throws IOException {
        int cont = 1;
        
        String expr = (String) txtEntrada.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
            	txtSalidaLex.setText(resultado);
                return;
            }
            switch (token) {
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case No_Igual:
                    resultado += "  <Operador igual negado>\t" + lexer.lexeme + "\n";
                    break;
                case Mayor:
                    resultado += "  <Operador mayor>\t" + lexer.lexeme + "\n";
                    break;
                case Mayor_Igual:
                    resultado += "  <Operador mayor o igual>\t" + lexer.lexeme + "\n";
                    break;
                case Menor:
                    resultado += "  <Operador mayor>\t" + lexer.lexeme + "\n";
                    break;
                case Menor_Igual:
                    resultado += "  <Operador mayor o igual>\t" + lexer.lexeme + "\n";
                    break;
                case Abre_Parentesis:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Cierra_Parentesis:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }
}
