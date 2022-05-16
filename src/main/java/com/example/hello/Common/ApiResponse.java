package com.example.hello.Common;

import lombok.Data;

import java.util.StringJoiner;

@Data
public class ApiResponse {
    public boolean result;
    public Object data;
    public String code;

    public ApiResponse(boolean result, Object data, String code) {
        this.result = result;
        this.data = data;
        this.code = code;
    }

    public boolean isSuccess() {
        return this.result;
    }
    public static class Builder {
        public boolean result;
        public Object data;
        public String code;

        public Builder setResult(Boolean result) {
            this.result = result;
            return this;
        }

        public Builder setData(Object data) {
            this.data = data;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(result, data, code);
        }
    }
    public String toJson() {
        return new StringJoiner(", ", "{", "}")
                .add("\"result\": \"" + result + "\"")
                .add("\"data\": " + data)
                .add("\"error_code\": \"" + code + "\"")
                .toString();
    }
}
