package kr.bit.interceptor;

import kr.bit.bean.Student;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인 확인처리
public class LoginInterceptor implements HandlerInterceptor {

    private Student loginBean;

    public LoginInterceptor(Student loginBean) {
        this.loginBean = loginBean;
    }

    //로그인 안되어있으면 주소를 입력해도 못들어가도록 막을거임
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(loginBean.isStudentLogin());
        if (loginBean.isStudentLogin() == false) {
            String str = request.getContextPath();  //첫 경로 알아내서
            response.sendRedirect(str + "/not_login"); //로그인 안되어있으면 이 주소로 강제이동
            return false;
        }
        return true;
    }
}
