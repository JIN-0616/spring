package net.hb.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
@Component
public class BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);

	//org.mybatis.spring.SqlSessionTemplate
	@Autowired
	SqlSessionTemplate temp;

	public void dbInsert(BoardDTO dto) {
		System.out.println("\ndao�Ѿ���̸�=" + dto.getName());
		System.out.println("dao�Ѿ������=" + dto.getTitle());
		System.out.println("dao�Ѿ�³���=" + dto.getContent());
		System.out.println("dao�Ѿ�¼���=" + dto.getGender());
		System.out.println("dao�Ѿ�����=" + dto.getHobby());
		System.out.println("dao���ڿ�����=" + dto.getUpload_f());
		System.out.println("dao����������=" + dto.getImg_file_name());

		temp.insert("board.add", dto);
		logger.info("hobby���̺� ���������强��");
	}// end
	
	public List<BoardDTO> dbList(Map<String, Object> query) {		
		List<BoardDTO> list = temp.selectList("board.selectAllDynamic", query);
		return list;
	}
	
	public List<BoardDTO> dbList2() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = temp.selectList("board.selectAll");
		return list;
	}

	public BoardDTO dbDetail(int idx) {
		BoardDTO dto = temp.selectOne("board.detail", idx);
		return dto;
	}
	public int dbCount() {
		int cnt = (Integer) temp.selectOne("board.countAll");
		return cnt;
	}
	
	public int dbCount(String skey, String sval) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("skey", skey);
		map.put("sval", sval);		
		int cnt = (Integer) temp.selectOne("board.countQuery",map);
		return cnt;
	}// end

	public void dbDelete(int idx) {
		temp.delete("board.del", idx);
	}

	public void dbEdit(BoardDTO dto) {
		temp.update("board.edit", dto);
	}

}// BoardDA end
