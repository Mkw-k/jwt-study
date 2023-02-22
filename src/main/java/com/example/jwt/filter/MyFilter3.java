package com.example.jwt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * packageName    : com.example.jwt.filter
 * fileName       : MyFilter1
 * author         : 드림포원 디자이너2
 * date           : 2023-02-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-02-22        드림포원 디자이너2       최초 생성
 */
public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //토큰 : cos 이걸 만들어줘야함 id, pw 가 정상적으로 들어와서 로그인이 완료되면 토큰을 만들어 주고 그걸 응답해준다
        if(request.getMethod().equals("POST")){
            System.out.println("POST 요청됨");
            String headerAuth = request.getHeader("Authorization");
            System.out.println(headerAuth);

            if(headerAuth.equals("cos")){
                filterChain.doFilter(request, response);
            }else{
                PrintWriter outPrintWriter = response.getWriter();
                outPrintWriter.println("인증안됨");
            }
        }
    }
}
