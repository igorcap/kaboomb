package pst;

import intities.Bomba;
import intities.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BombaMySQLDao implements BombaDao {

	@Override
	public void inserir(Bomba d) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("insert into bombas (x_bombas, y_bombas,fk_jogosalvo) values (?,?,?)");
			
			stmt.setInt(1, d.getX());
			stmt.setInt(2, d.getY());
			stmt.setInt(3, d.getJ().getCod());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if (stmt != null){
					stmt.close();
				}
				if (con!= null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public ArrayList<Bomba> listar(Jogo j) {
		ArrayList<Bomba> bombas = new ArrayList<Bomba>();
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("Select * from bombas where fk_jogosalvo = ?");
			stmt.setInt(1, j.getCod());
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				int x = rs.getInt("x_bombas");
				int y = rs.getInt("y_bombas");

				Bomba d = new Bomba(x, y);
				bombas.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return bombas;
	}
	@Override
	public void excluir() {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("delete from jogo_salvo where flag = ?");
			
			stmt.setBoolean(1, true);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Bomba> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bomba buscar(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bomba> buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
