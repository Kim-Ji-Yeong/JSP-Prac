package practice2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {

	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board3 (title, ctnt)" + " VALUES " + "(?,?)";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	};

	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_board3";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.executeQuery();
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);

				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");

				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}



	public static BoardVO selBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_board3 WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			
			rs = ps.executeQuery();
			BoardVO vo = new BoardVO();
			if (rs.next()) {

				vo.setIboard(rs.getInt("iboard"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setTitle(rs.getString("title"));
			}
			return vo;

			// insert,update,delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return null;
	}

}
