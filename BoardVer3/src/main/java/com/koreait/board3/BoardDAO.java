package com.koreait.board3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Data Access Object (DB 담당)
public class BoardDAO {
	// 글등록
	public static int insertBoard(BoardVO3 vo) { // title,ctnt 값 담겨움, 외부로부터 값을 받아옴에 따라
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board (title, ctnt)" // ↓
				+ " VALUES" // ↓
				+ "(?,?)"; // 대소문자 안가림

		try {
			con = DBUtils.getCon(); // 다리연결
			ps = con.prepareStatement(sql); // 연결된 다리로부터 준비된 상태 객체 생성
			ps.setString(1, vo.getTitle()); // <----------------------------------값이 버뀜
			ps.setString(2, vo.getCtnt());// 몇번쨰 물음표에 어떤값을 넣을건지 - > 2번 째 물음표자리에 vo.getCtnt()값 넣을거임

			return ps.executeUpdate(); // insert,update,delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps); // 리턴 하고서도 실행되기 때문에, 위에 리턴하면서 쿼리문 실행하고 나서도 connerction은 무조건 닫힌다.
		}

		return 0;
	};
		public static List<BoardVO3> selBoardList() {

//		List<BoardVO3> list = new ArrayList();
//		//list 에 들어갈수있는 객체는 BoardVO3밖에 읍따.
//		BoardVO3 vo = new BoardVO3();
//		vo.setTitle("안녕");
//		vo.set("2021-04-30");
//		list.add(vo);
//		
//		BoardVO3 vo2 = new BoardVO3();
//		vo.setIboard(2);
//		vo.setTitle("Hello");
//		list.add(vo2);
//		
//		BoardVO3 vo3 = new BoardVO3();
//		vo.setIboard(3);
//		vo.setTitle("반가워");
//		list.add(vo3);
//		
//		
//		return list;
//
//	}

		// 글 불러오기
		List<BoardVO3> list = new ArrayList();

		Connection con = null; // select 문은 이거 3개 필요함
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_board";
//		String sql = "SELECT iboard, title, regdt FROM t_board";
		// t-board끝에 ;세미콜론 안됨(에러), 외부에서의 ;를 이용한 데이터베이스 접근을 막기위한

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.executeQuery();
			rs = ps.executeQuery();

			while (rs.next()) {
//			while(rs.next()) {
				// rs.next() : 첫번 째 실행되면 첫번 째 줄을 가리킨다.(일종의 포인터)
				// 가리켰는데 레코드가 있으면 true, 없으면 false 반환

				BoardVO3 vo = new BoardVO3();
				list.add(vo); // 레퍼런스 변수이기 떄문에 위치 상관 ㄴㄴ 객체생성 후면은 됨

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

		return list; // list를 불러준곳으로 가야함 -> BoardListServlet에 list
						// -> list.jsp의 ${list}

	}
	public static BoardVO3 selBoard(BoardVO3 param) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_board WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			BoardVO3 vo = new BoardVO3();
			if(rs.next()) {
				
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

	

	public static int updBoard(BoardVO3 param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board "
				+ " SET title = ? " 
				+ " , ctnt = ? "
				+ " WHERE iBoard = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			
			System.out.println(ps.toString());
			return ps.executeUpdate(); // insert,update,delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static int delBoard(BoardVO3 param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM t_board where iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());

			return ps.executeUpdate(); // insert,update,delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

}
