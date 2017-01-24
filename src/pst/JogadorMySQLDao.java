package pst;

import intities.Jogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorMySQLDao implements JogadorDao {

	@Override
	public void inserir(Jogador d) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con
					.prepareStatement("insert into Jogador (nome, pontuacao) values (?,?)");

			stmt.setString(1, d.getNome());
			stmt.setInt(2, d.getPontuacao());

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
	public void alterar (Jogador d) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("update Jogador set pontuacao = ? where nome = ?");
			
			stmt.setInt(1, d.getPontuacao());
			stmt.setString(2, d.getNome());
			
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
	public List<Jogador> buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
