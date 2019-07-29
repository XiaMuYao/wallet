package com.xiamuyao.ulanbator.model.bean.response;

public class LoginBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"userLoginId":"1154812560596271106","userLoginToken":"6accfeeb470609e0b097acec573ba3dc"}
     */

    private ResultBean result;
    private DataBean data;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ResultBean {
        /**
         * returnCode : 0
         * returnUserMessage : 成功
         * returnMessage : 成功
         */

        private String returnCode;
        private String returnUserMessage;
        private String returnMessage;

        public String getReturnCode() {
            return returnCode;
        }

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public String getReturnUserMessage() {
            return returnUserMessage;
        }

        public void setReturnUserMessage(String returnUserMessage) {
            this.returnUserMessage = returnUserMessage;
        }

        public String getReturnMessage() {
            return returnMessage;
        }

        public void setReturnMessage(String returnMessage) {
            this.returnMessage = returnMessage;
        }
    }

    public static class DataBean {
        /**
         * userLoginId : 1154812560596271106
         * userLoginToken : 6accfeeb470609e0b097acec573ba3dc
         */

        private String userLoginId;
        private String userLoginToken;

        public String getUserLoginId() {
            return userLoginId;
        }

        public void setUserLoginId(String userLoginId) {
            this.userLoginId = userLoginId;
        }

        public String getUserLoginToken() {
            return userLoginToken;
        }

        public void setUserLoginToken(String userLoginToken) {
            this.userLoginToken = userLoginToken;
        }
    }
}
