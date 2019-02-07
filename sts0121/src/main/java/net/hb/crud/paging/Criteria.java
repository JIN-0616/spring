package net.hb.crud.paging;

public class Criteria {
	
	private int page;	//���� ��������ȣ
	private int perPageNum; // �� �������� ������ �Խñ� ����
	private int pageStart;
	private int pageEnd;
	private String skey;
	private String sval;
	
	public int getPageStart() { // Ư�� �������� �Խñ� ���۹�ȣ, �Խñ� ���� �� ��ȣ		
		//���� �������� �Խñ� ���� ��ȣ = (���� ������ ��ȣ - 1) * �������� ������ �Խñ� ����		
		return (this.page-1)*perPageNum;
	}
	
	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSval() {
		return sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public Criteria() { // �⺻ ������ - �⺻�� ����
		this.page = 1;	
		this.perPageNum =10;
		this.skey="";
		this.sval="";
		this.pageStart=(page-1)*perPageNum;
		this.pageEnd=pageStart+9;
	}
	
	public int getPage() {
		return page;
	}

	//�������� �������� ���� �ʰ� ����. ������ �Ǹ� 1�������� ��Ÿ����.
	public void setPage(int page) { 
		if(page<=0) {		//�Ѿ�� �������� 1���� ������
			this.page = 1;	//�⺻�� ����
		}else {		
			this.page = page; //�װ� �ƴϸ� ������ ����
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	
	//�������� ������ �Խñ� ���� ������ �ʰ� �����ߴ�.
	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if(pageCount != cnt) {
			this.perPageNum = cnt;
		}else {
			this.perPageNum = pageCount;
		}
	}
	
	
}
