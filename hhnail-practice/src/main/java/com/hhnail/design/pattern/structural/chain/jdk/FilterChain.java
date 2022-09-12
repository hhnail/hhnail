package com.hhnail.design.pattern.structural.chain.jdk;

import com.hhnail.algorithm.leetcode.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    private List<Filter> filters = new ArrayList<>();

    public void addFiter(Filter filter){
        filters.add(filter);
    }

    public void doFilter(){
        
    }

}
