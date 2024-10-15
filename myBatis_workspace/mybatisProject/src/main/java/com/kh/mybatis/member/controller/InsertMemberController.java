package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberServiceImpl;

/**
 * Servlet implementation class InsertMemberController
 */
@WebServlet("/insert.me")
public class InsertMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String id = request.getParameter("userId");
				String pwd = request.getParameter("userPwd");
				
				Member m = new Member();
				m.setUserId(id);
				m.setUserPwd(pwd);
				
			
				int insertUser = new MemberServiceImpl().insertMember(m);
				
				if(insertUser > 0) {
				
					HttpSession session = request.getSession();
					
					session.setAttribute("alertMsg", "회원가입 완료.");
					session.setAttribute("insertUser", insertUser);
					
					response.sendRedirect(request.getContextPath());
				}else {
					
					request.setAttribute("errorMsg", "회원가입 실패.");
					request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp")
					         .forward(request, response);
				}
				
	}

}
