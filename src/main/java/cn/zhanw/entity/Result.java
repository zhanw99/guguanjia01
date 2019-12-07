package cn.zhanw.entity;

import java.io.Serializable;

/**
 * @description：操作结果集

 */
public class Result implements Serializable {

    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;

    private static final long serialVersionUID = 5576237395711742681L;

    /**
     * 正确还是错误
     */
    private boolean success = false;

    /**
     * 提示成功还是失败
     */
    private String msg = "";

    /**
     * 存对象
     */
    private Object obj = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * 默认失败
     */
    public Result() {
        success = false;
        msg = "操作失败";
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
