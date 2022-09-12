package com.hhnail.design.pattern.structural.chain.jdk;

public interface Filter {
    void doFilter(Request request, Response response,FilterChain filterChain);
}

interface Request {

}

interface Response {

}
