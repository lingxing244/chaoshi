package com.dao;

import com.entity.Provider;

import java.util.List;

public interface IProviderDao {
    List<Provider> selectAll();

    Long selectProId(String proname);
}
