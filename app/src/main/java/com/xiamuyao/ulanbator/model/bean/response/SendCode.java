package com.xiamuyao.ulanbator.model.bean.response;

public class SendCode {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"verifyKey":"1154804387088957440"}
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
         * verifyKey : 1154804387088957440
         */

        private String verifyKey;

        public String getVerifyKey() {
            return verifyKey;
        }

        public void setVerifyKey(String verifyKey) {
            this.verifyKey = verifyKey;
        }
    }
}
