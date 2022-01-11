package com.left.responsibilitychain;

/**
 * 责任链模式
 * 为请求创建一个接受者对象的链
 */
public class ResponsibilityChain {

    public static void main(String[] args) {
        Request.RequestBuilder builder = new Request.RequestBuilder();
        Request request = builder.isFrequent(false).isLogin(true).build();
        Handler handler = new RequestFrequentHandler(new LogginHandler(null));
        if (handler.process(request)) {
            System.out.println("正常进行业务");
        } else {
            System.out.println("访问异常");
        }
    }

}

class Request {
    private boolean isLogin;
    private boolean isFrequent;
    private boolean isPermits;
    private boolean ContainSensitiveWords;

    public Request(boolean isLogin, boolean isFrequent, boolean isPermits, boolean containSensitiveWords) {
        this.isLogin = isLogin;
        this.isFrequent = isFrequent;
        this.isPermits = isPermits;
        ContainSensitiveWords = containSensitiveWords;
    }

    static class RequestBuilder {
        private boolean isLogin;
        private boolean isFrequent;
        private boolean isPermits;
        private boolean ContainSensitiveWords;

        RequestBuilder isLogin(Boolean isLogin) {
            this.isLogin = isLogin;
            return this;
        }

        RequestBuilder isFrequent(Boolean isFrequent) {
            this.isFrequent = isFrequent;
            return this;
        }

        RequestBuilder isPermits(Boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }

        RequestBuilder ContainSensitiveWords(Boolean ContainSensitiveWords) {
            this.ContainSensitiveWords = ContainSensitiveWords;
            return this;
        }

        public Request build() {
            return new Request(this.isLogin, this.isFrequent, this.isPermits, this.ContainSensitiveWords);
        }

    }

    public boolean isLogin() {
        return isLogin;
    }

    public boolean isFrequent() {
        return isFrequent;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public boolean isContainSensitiveWords() {
        return ContainSensitiveWords;
    }

}

abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);

}
class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制");
        if (request.isFrequent()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}
class LogginHandler extends Handler {

    public LogginHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登陆校验");
        if (request.isLogin()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}