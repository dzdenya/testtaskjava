package model;

import java.util.Objects;

public class RandomBody {
    private String jsonrpc;
    private String method;
    private Params params;
    private int id;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public RandomBody setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public RandomBody setMethod(String method) {
        this.method = method;
        return this;
    }

    public Params getParams() {
        return params;
    }

    public RandomBody setParams(Params params) {
        this.params = params;
        return this;
    }

    public int getId() {
        return id;
    }

    public RandomBody setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "RandomBody{" +
                "jsonrpc='" + jsonrpc + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomBody randomBody = (RandomBody) o;
        return id == randomBody.id &&
                Objects.equals(jsonrpc, randomBody.jsonrpc) &&
                Objects.equals(method, randomBody.method) &&
                Objects.equals(params, randomBody.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonrpc, method, params, id);
    }
}

