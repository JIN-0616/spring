package net.hb.order;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {
	// GuestDAO dao = new GuestDAO(); //자바 MVC2=서블릿 접근방식

	@Autowired
	GuestDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(GuestController.class);

	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String guest_form(Locale locale, Model model) {
		logger.info("Write.do");
		//return "guest"; // WEB_INF/views/guest.jsp문서
		return "./WEB-INF/views/guest.jsp";
			 // ./ 도 가능
	}

	@RequestMapping("/insert.do")
	public String guest_insert(GuestDTO dto) { // MVC2 InsertController.java
		dao.dbInsert(dto); // DAO의 메소드 접근
		// return "guestList"; //.jsp확장자 적지 마시오
		return "redirect:list.do";
	}

	@RequestMapping("/list.do")
	public ModelAndView guest_select(HttpServletRequest request) { // MVC2 ListController.java
		ModelAndView mav = new ModelAndView();
		// 페이징 초기값설정
		int startpage = 1, endpage = 10;
		String pnum = "";
		int pageNUM = 1, start = 1, end = 10;
		int pagecount = 1, temp = 0;
		// 검색 skey, sval, returnpage
		String skey="", sval="", returnpage="";
		skey = request.getParameter("keyfield");
		sval = request.getParameter("keyword");		
		if(skey==""||skey==null||sval==""||sval==null) { //null초기화
			skey="title"; sval="";
		}
		
		returnpage = "&keyfield="+skey+"&keyword="+sval;	
				
		pnum = request.getParameter("pageNum"); // <a href="list.do?pageNum=${i}">[${i}]</a>
		if (pnum == "" || pnum == null) {pnum = "1";}
		else {pageNUM = Integer.parseInt(pnum);}

		// [7클릭] 숫자 7을 pageNUM변수가 기억
		start = (pageNUM - 1) * 10 + 1;
		end = (pageNUM) * 10;		
		int Stotal = dao.dbCountSearch(skey, sval);
		int Gtotal = dao.dbCount(); // 레코드 전체갯수		
		if (Stotal % 10 == 0) {	pagecount = Stotal / 10;} //Gtotal대신 Stotal
		else {pagecount = (Stotal / 10) + 1;}

		// temp변수활용 [7]
		// startpage
		// endpage
		temp = (pageNUM - 1) % 10;
		startpage = pageNUM - temp;
		endpage = startpage + 9;  //[31]~~[40]
		if(endpage>pagecount) {endpage=pagecount;}
		List<GuestDTO> list = dao.dbSelect(start, end, skey, sval);
		mav.addObject("naver", list);
		mav.addObject("Gtotal", Gtotal);
		mav.addObject("Stotal", Stotal);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("pagecount", pagecount);
		mav.addObject("pageNUM", pageNUM);
		mav.addObject("skey",skey);
		mav.addObject("sval",sval);
		mav.addObject("returnpage",returnpage);
		//mav.setViewName("guestList");
		mav.setViewName("./WEB-INF/views/guestList.jsp"); 
		return mav; // WEB_INF/views/guestList.jsp문서
	}
   
	@RequestMapping("/detaibatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException: l.do")
	public String guest_detail(Model model,@RequestParam("idx") int data) { // MaV 대신 Model객체 사용
		logger.info("detail.do");
		GuestDTO dto = dao.dbDetail(data);
		model.addAttribute("bean", dto);		
		return "WEB-INF/views/guestDetail.jsp";
	}

	@RequestMapping("/delete.do")
	public String guest_delete(@RequestParam("idx") String data) {
		dao.dbDelete(Integer.parseInt(data));
		//return "redirect:list.do";  //return "redirect:/list.do";
		return "redirect:list.do";  //return "redirect:/list.do";
	}

	@RequestMapping("/preEdit.do")
	public ModelAndView guest_preEdit(@RequestParam("idx") String data) {
		ModelAndView mav = new ModelAndView();
		GuestDTO dto = dao.dbDetail(Integer.parseInt(data));
		mav.addObject("bean", dto);
		//mav.setViewName("guestEdit");
		mav.setViewName("/WEB-INF/views/guestEdit.jsp");
		return mav;
	}

	@RequestMapping("/edit.do")
	public String guest_Edit(GuestDTO dto) {
		dao.dbEdit(dto);
		return "redirect:/list.do";
	}
}
