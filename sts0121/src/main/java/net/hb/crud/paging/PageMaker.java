package net.hb.crud.paging;

public class PageMaker {
	private Criteria cri;
	private int totalCount;		//�� �Խñ� ��
	private int startPage;		//ȭ�鿡 ������ ������ ��������ȣ, �� ������ ��ȣ
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5;  //ȭ�� �ϴܿ� �������� ������ ��ư�� ��
	
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	private void calcData() {
		//�� ������ ��ȣ = (���� ������ ��ȣ / ȭ�鿡 ������ ������ ��ȣ�� ����) * ȭ�鿡 ������ ������ ��ȣ�� ����
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);

		//������ ������ ��ȣ = �� �Խñ� �� / �� �������� ������ �Խñ��� ����
		int tempEndPage = (int)(Math.ceil(totalCount)/(double)cri.getPerPageNum());
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//���� ������ ��ȣ = (�� ������ ��ȣ - ȭ�鿡 ������ ������ ��ȣ�� ����) + 1
		startPage = (endPage - displayPageNum)+1;		
		
		//���� ��ư ���� ���� = ���� ������ ��ȣ == 1 ? false : true
		prev = startPage == 1 ? false : true;
		
		//���� ��ư ���� ���� = �� ������ ��ȣ * �� �������� ������ �Խñ��� ���� >= �� �Խñ��� �� ? false : true
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;		
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	

}
