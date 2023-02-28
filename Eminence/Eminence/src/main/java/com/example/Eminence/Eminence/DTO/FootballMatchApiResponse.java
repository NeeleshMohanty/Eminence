package com.example.Eminence.Eminence.DTO;

import com.example.Eminence.Eminence.Entity.FootballMatch;

import java.util.List;

public class FootballMatchApiResponse {
    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private List<FootballMatch> data;

    public FootballMatchApiResponse() {
    }

    public FootballMatchApiResponse(int page, int perPage, int total, int totalPages, List<FootballMatch> data) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<FootballMatch>  getMatches() {
        return data;
    }

    public void setData(List<FootballMatch> data) {
        this.data = data;
    }


}

