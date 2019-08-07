package glassgate.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HTTPErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.BAD_REQUEST.value()) {
                return "error-400";
            }
            else if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
                return "error-401";
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "error-403";
            }
            else if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                return "error-405";
            }
            else if(statusCode == HttpStatus.I_AM_A_TEAPOT.value()) {
                return "error-418";
            }
            else if(statusCode == HttpStatus.TOO_MANY_REQUESTS.value()) {
                return "error-429";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
            else if(statusCode == HttpStatus.NOT_IMPLEMENTED.value()) {
                return "error-501";
            }
            else if(statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()) {
                return "error-503";
            }
            else if(statusCode == HttpStatus.INSUFFICIENT_STORAGE.value()) {
                return "error-507";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}