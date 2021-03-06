/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import layout.Continuar;
import layout.Dificuldade;
import layout.Recordes;
import principal.PartidaContinue;


/**
 *
 * @author Igor Capistrano
 */
public class TelaInicial extends javax.swing.JPanel {

	/**
	 * Creates new form TelaInicial
	 */
	private boolean flag;

	public TelaInicial() {
		flag = false;
		initComponents();
		jogar.setOpaque(false);
		jogar.setContentAreaFilled(false); //to make the content area transparent
		jogar.setBorderPainted(false); 
		recordes.setOpaque(false);
		recordes.setContentAreaFilled(false); //to make the content area transparent
		recordes.setBorderPainted(false); 
		sair.setOpaque(false);
		sair.setContentAreaFilled(false); //to make the content area transparent
		sair.setBorderPainted(false);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

		Image img1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/teleinicial.jpg"));

		g.drawImage(img1, 0, 0, this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jogar = new javax.swing.JButton();
		recordes = new javax.swing.JButton();
		sair = new javax.swing.JButton();

		jogar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jogarMouseClicked(evt);
			}
		});
		jogar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jogarActionPerformed(evt);
			}
		});

		recordes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				recordesMouseClicked(evt);
			}
		});

		sair.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				sairMouseClicked(evt);
			}
		});

		JButton continuar = new JButton();
		continuar.setOpaque(false);
		continuar.setContentAreaFilled(false); //to make the content area transparent
		continuar.setBorderPainted(false);
		continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				continuarActionClicked(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(101)
						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(sair, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
								.addComponent(jogar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(recordes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(continuar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(93, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(continuar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jogar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addGap(55)
										.addComponent(recordes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addGap(48)
										.addComponent(sair, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
										.addGap(174))
				);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	private void jogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jogarActionPerformed

	}//GEN-LAST:event_jogarActionPerformed



	private void jogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jogarMouseClicked
		Dificuldade y = new Dificuldade();
		y.main(null);
	}//GEN-LAST:event_jogarMouseClicked

	private void recordesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordesMouseClicked
		Recordes r = new Recordes();
		r.main(null);
	}//GEN-LAST:event_recordesMouseClicked

	private void continuarActionClicked(ActionEvent evt){
		flag = true;
		PartidaContinue p = new PartidaContinue();
		p.main(null);
	}

	private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
		System.exit(0);
	}//GEN-LAST:event_sairMouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jogar;
	private javax.swing.JButton recordes;
	private javax.swing.JButton sair;
}
