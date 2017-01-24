package pst;

import intities.Jogo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JogoMySQLDao implements JogoDao {

	@Override
	public void inserir(Jogo d) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con
					.prepareStatement("insert into Jogo_salvo (data_partida, total_linhas, total_colunas) values (?,?,?)");

			stmt.setTimestamp(1, new Timestamp(d.getData().getTime()));
			stmt.setInt(2, d.getLinhas());
			stmt.setInt(3, d.getColunas());

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

	public ArrayList<Jogo> buscar() {
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("Select * from jogo_salvo order by id desc");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int y = rs.getInt("total_colunas");
				int x = rs.getInt("total_linhas");
				
				Jogo j = new Jogo(id, x, y);
				jogos.add(j);
			}

		} catch (SQLException  e) {
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
		return jogos;
	}


	@Override
	public void excluir(int codigo) {
		/*Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("delete from Jogo where flag = false");

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
		}/*/
	}

	@Override
	public Jogo buscar(int codigo) {
		/*Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("Select * from Jogo where idJogo = ?");
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Date date = rs.getDate("idJogo");

				Jogo d = new Jogo(date);
				return d;
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
		}/*/
		return null;
	}

}
