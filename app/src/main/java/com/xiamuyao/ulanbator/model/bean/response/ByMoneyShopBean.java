package com.xiamuyao.ulanbator.model.bean.response;

public class ByMoneyShopBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"amountUsd":"160,000","decimalAmount":"8,000,000"}
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
         * amountUsd : 160,000
         * decimalAmount : 8,000,000
         */

        private String amountUsd;
        private String decimalAmount;

        public String getAmountUsd() {
            return amountUsd;
        }

        public void setAmountUsd(String amountUsd) {
            this.amountUsd = amountUsd;
        }

        public String getDecimalAmount() {
            return decimalAmount;
        }

        public void setDecimalAmount(String decimalAmount) {
            this.decimalAmount = decimalAmount;
        }
    }
}
