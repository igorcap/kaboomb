package layout;

import background.DificuldadeBack;

public class Dificuldade extends javax.swing.JFrame {
	private DificuldadeBack DificuldadeBack1;
	
	public Dificuldade() {
		initComponents();
		setLocationRelativeTo(null); 
	}

	private void initComponents() {

		DificuldadeBack1 = new DificuldadeBack();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(DificuldadeBack1);
        
		pack();
	}

	public static void main(String args[]) {
	
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Dificuldade.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Dificuldade.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Dificuldade.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Dificuldade.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Dificuldade().setVisible(true);
			}
		});
	}
}