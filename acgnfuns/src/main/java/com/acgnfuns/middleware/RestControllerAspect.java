package com.acgnfuns.middleware;

import com.acgnfuns.service.ClicksService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RestControllerAspect {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClicksService clicksService;

    @Before("execution(public * com.acgnfuns.controller.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String method = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);
        String url = request.getParameter("url");
        String type = "";
        if ("getAnimationBangumiByUrl".equals(method))
            type = "动画";
        else
        if ("getComicMangaByUrl".equals(method))
            type = "漫画";
        else
        if ("getGameGeimuByUrl".equals(method))
            type = "游戏";
        else
        if ("getNovelNoberuByUrl".equals(method))
            type = "轻小说";
        if ("".equals(type))
            return;
        clicksService.save(url, type);
    }
}
