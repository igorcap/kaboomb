package background;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingWorker;

import layout.Botoes;

public class BotoesBackground extends javax.swing.JPanel  {
	private int tempo = 0;
	public int getTempo() {
		return tempo;
	}




	public BotoesBackground() {
		initComponents();
		SwingWorker worker = new SwingWorker() {
			
			protected Object doInBackground() {
				while(true){
					label1.setText(""+tempo);
					try {
						Thread.sleep(1000);
						tempo++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		worker.execute();



	}




	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

		Image img1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/campominadojogo2.jpg"));

		g.drawImage(img1, 0, 0, this);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		label1 = new java.awt.Label();
		botoes1 = new layout.Botoes();

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		setPreferredSize(new java.awt.Dimension(400, 400));

		label1.setBackground(new java.awt.Color(255, 255, 255));
		label1.addComponentListener(new java.awt.event.ComponentAdapter() {
			
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78, 78, 78))
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(botoes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(38, 38, 38)
						.addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
						.addComponent(botoes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
	}// </editor-fold>//GEN-END:initComponents

	

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private layout.Botoes botoes1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	public java.awt.Label label1;
	// End of variables declaration//GEN-END:variables
}
