package kr.bit.interceptor;

import kr.bit.bean.Subject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectInterceptor implements HandlerInterceptor {

    private Subject subjectBean;

    public SubjectInterceptor(Subject subjectBean) {
        this.subjectBean = subjectBean;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
