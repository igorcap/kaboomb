package pst;

import intities.BotaoClicado;
import intities.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BotaoClicadoMySQLDao implements BotaoClicadoDao{



	@Override
	public void inserir(BotaoClicado d) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("insert into clicked (x_clicked, y_clicked, fk_jogosalvo) values (?,?,?)");

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

	public ArrayList<BotaoClicado> listar(Jogo j) {
		ArrayList<BotaoClicado> clicados = new ArrayList<BotaoClicado>();
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("Select * from clicked where fk_jogosalvo = ?");
			stmt.setInt(1, j.getCod());
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				int x = rs.getInt("x_clicked");
				int y = rs.getInt("y_clicked");

				BotaoClicado d = new BotaoClicado(x, y);
				clicados.add(d);
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

		return clicados;
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
	public List<BotaoClicado> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BotaoClicado buscar(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BotaoClicado> buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
