package com.example.boot.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {
    public int page;
    public  int pageSize;

    public String pages;

    public  boolean active;

    public PageUtil(){}

    PageUtil(String pages,boolean active) {
        this.pages = pages;
        this.active = active;
    }

    public List<PageUtil> getPageList(Integer pages, Integer allCount) {
        int allPage = allCount/this.pageSize;
        if(allCount%this.pageSize > 0) {
            allPage += 1;
        }
        ArrayList<PageUtil> newList = new ArrayList<>();
        if(pages!=1) {
            newList.add(new PageUtil("上一页",false));
        }
        int startIndex = pages-5;
        int endIndex = pages+5;
        if (startIndex < 0) {
            startIndex = 0;
            endIndex = 10;
        }

        if (endIndex > allPage) {
            endIndex = allPage;
            startIndex = allPage-10;
        }

        for (int i = startIndex; i <endIndex; i++) {
            boolean isActive = false;
            Integer tPage = i+1;
            if (tPage.equals(pages)) {
                isActive = true;
            }
            newList.add(new PageUtil(""+tPage,isActive));
        }

        if(!pages.equals(allPage)) {
            newList.add(new PageUtil("下一页",false));
        }
        return newList;
    }


}
