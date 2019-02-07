package net.hb.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class GuestDAO {
	
	@Autowired
	SqlMapClientTemplate temp; // guest.xml������ id��������
	
	public void dbInsert(GuestDTO dto) { //guest_insert(dto)
		temp.insert("guest.add",dto); //guest���ӽ����̽� add <insert id=add
		//ibatis�����͸�Ī #��# <--->  mybatis #{}  <---> el�±� ${}
		System.out.println("guest ���̺� ������ ���强��");
	}
		
	public List<GuestDTO> dbSelect(int start, int end){ //start,end
		//DTO��üȭ �� setvalue("value")
		GuestDTO dto = new GuestDTO();
		dto.setStart(start);
		dto.setEnd(end);
		@SuppressWarnings("unchecked")
		List<GuestDTO> list = temp.queryForList("guest.selectAll",dto);			
		return list;
	}
	// ������ ������, end��, �˻��ʵ�, Ű���� ��Ȱ��
	public List<GuestDTO> dbSelect(int start, int end, String skey, String sval){
		GuestDTO dto = new GuestDTO();
		dto.setStart(start);
		dto.setEnd(end);
		dto.setSkey(skey);
		dto.setSval(sval);
		@SuppressWarnings("unchecked")
		List<GuestDTO> list = temp.queryForList("guest.dynamicSelectAll",dto);			
		return list;
	}
	public int dbCountSearch(String skey, String sval) {//�˻�+��ȸ����� ��ü�� �޾Ƽ� ����ȯ
		GuestDTO dto = new GuestDTO();
		dto.setSkey(skey);
		dto.setSval(sval);
		int cnt = (Integer)temp.queryForObject("guest.countAllSearch",dto);
		return cnt;
	}
	
	public int dbCount(String skey, String sval) {//�˻�+��ȸ����� ��ü�� �޾Ƽ� ����ȯ
		GuestDTO dto = new GuestDTO();
		dto.setSkey(skey);
		dto.setSval(sval);
		int cnt = (Integer)temp.queryForObject("guest.countAllSearch",dto);
		return cnt;
	}
	
	public int dbCount() {//��ȸ����� ��ü�� �޾Ƽ� ����ȯ
		int cnt = (Integer)temp.queryForObject("guest.countAll");
		return cnt;
	}
	
	public GuestDTO dbDetail(int data) {
		GuestDTO dto = null; //temp.queryForObject("guest.detail",data);
		dto = (GuestDTO) temp.queryForObject("guest.detail",data);
		return dto;		
	}
	public void dbDelete(int data) {
		temp.delete("guest.del",data);
		System.out.println("guest ���̺� ������ ���� ����");
	}
	
	public void dbEdit(GuestDTO dto) {
		temp.update("guest.edit",dto);
		System.out.println("guest ���̺� ������ ���� ����");
	}	
}
