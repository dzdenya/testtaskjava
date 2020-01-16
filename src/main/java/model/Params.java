package model;

import java.util.Objects;

public class Params {
    private String apiKey;
    private int n;
    private int length;
    private int min;
    private int max;
    private boolean replacement;

    public String getApiKey() {
        return apiKey;
    }

    public Params setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public int getN() {
        return n;
    }

    public Params setN(int n) {
        this.n = n;
        return this;
    }

    public int getMin() {
        return min;
    }

    public int getLength() {
        return length;
    }

    public Params setLength(int length) {
        this.length = length;
        return this;
    }

    public Params setMin(int min) {
        this.min = min;
        return this;
    }

    public int getMax() {
        return max;
    }

    public Params setMax(int max) {
        this.max = max;
        return this;
    }

    public boolean isReplacement() {
        return replacement;
    }

    public Params setReplacement(boolean replacement) {
        this.replacement = replacement;
        return this;
    }

    @Override
    public String toString() {
        return "Params{" +
                "apiKey='" + apiKey + '\'' +
                ", n=" + n +
                ", length=" + length +
                ", min=" + min +
                ", max=" + max +
                ", replacement=" + replacement +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Params params = (Params) o;
        return n == params.n &&
                length == params.length &&
                min == params.min &&
                max == params.max &&
                replacement == params.replacement &&
                Objects.equals(apiKey, params.apiKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, n, length, min, max, replacement);
    }
}
