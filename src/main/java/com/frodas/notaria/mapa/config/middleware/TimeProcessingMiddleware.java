package com.frodas.notaria.mapa.config.middleware;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class TimeProcessingMiddleware extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        UUID uuid = UUID.randomUUID();
        StopWatch watch = new StopWatch();
        watch.start();
        log.info(uuid + " Process start time:" + new Date());
        filterChain.doFilter(request, response);
        watch.stop();
        log.info(uuid + " Process end time:" + new Date() + " total execution time:" + watch.getTotalTimeMillis());
    }

}
