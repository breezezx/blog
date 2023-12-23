package org.zx.blog.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private String code;
    private String msg;
    private Object data;
    public static Result succ(Object data)  {
        Result result = new Result();
        result.setCode("200");
        result.setData(data);
        result.setMsg("Success");
        return result;
    }

    public static Result succ(String mess, Object data){
        Result result =new Result();
        result.setCode("200");
        result.setData(data);
        result.setMsg(mess);
        return result;
    }
    public static Result fail(String mess){
        Result result=new Result();
        result.setCode("201");
        result.setData(null);
        result.setMsg(mess);
        return result;
    }

    public static Result fail(String mess, Object data){
        Result result =new Result();
        result.setCode("201");
        result.setData(data);
        result.setMsg(mess);
        return result;
    }
}
