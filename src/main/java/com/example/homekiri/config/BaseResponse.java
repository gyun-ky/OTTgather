package com.example.homekiri.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;

import static com.example.homekiri.config.BaseResponseStatus.SUCCESS;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class BaseResponse<T> extends HttpEntity<T>{
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String message;
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 요청에 성공
    public BaseResponse(T result) {
        this.isSuccess = SUCCESS.isSuccess();
        this.message = SUCCESS.getMessage();
        this.status = SUCCESS.getStatus();
        this.result = result;
    }

    // 요청에 실패
    public BaseResponse(BaseResponseStatus status){
        this.isSuccess = status.isSuccess();
        this.message = status.getMessage();
        this.status = status.getStatus();
    }
}

//{
//    "isSuccess" : false,
//        "message" : "JWT 인증에 실패하였습니다",
//        "result" : [
//                ]
//        }

