//package com.angusF.Anly.aop;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class GeneralExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Map handleException(HttpServletRequest request, Exception e) throws Exception {
//        Map map = new HashMap(5);
//        map.put("errorCode", 404);
//        map.put("isSuccess", false);
//        return map;
//    }
//}
