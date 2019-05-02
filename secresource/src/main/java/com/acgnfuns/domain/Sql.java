package com.acgnfuns.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Sql implements Serializable {
    private String sql;
    private Map params;

    public Sql() {
    }

    public Sql(String sql, Map params) {
        this.sql = sql;
        this.params = params;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sql)) return false;
        Sql sql1 = (Sql) o;
        return Objects.equals(getSql(), sql1.getSql()) &&
                Objects.equals(getParams(), sql1.getParams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSql(), getParams());
    }

    @Override
    public String toString() {
        return "Sql{" +
                "sql='" + sql + '\'' +
                ", params=" + params +
                '}';
    }
}
