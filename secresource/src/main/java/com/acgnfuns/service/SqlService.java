package com.acgnfuns.service;

import com.acgnfuns.mapper.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class SqlService {
    @Autowired
    private SqlMapper sqlMapper;

    public Map<String, Object> selectOne(String sql, Map params){
        return this.sqlMapper.selectOne(sql,params);
    }
    public int insert(String sql, Map params){
        return this.sqlMapper.insert(sql,params);
    }
}
