package com.xiamuyao.ulanbator.model.bean.response;

public class MoneyAccountInfoBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"interestShareLast":"0","interestALL":"0","interestLast":"0","interestShare":"0","interestProduct":"0","interestTeam":"0","interestProductLast":"0"}
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
         * interestShareLast : 0
         * interestALL : 0
         * interestLast : 0
         * interestShare : 0
         * interestProduct : 0
         * interestTeam : 0
         * interestProductLast : 0
         */

        private String interestShareLast;
        private String interestALL;
        private String interestLast;
        private String interestShare;
        private String interestProduct;
        private String interestTeam;
        private String interestProductLast;

        public String getInterestShareLast() {
            return interestShareLast;
        }

        public void setInterestShareLast(String interestShareLast) {
            this.interestShareLast = interestShareLast;
        }

        public String getInterestALL() {
            return interestALL;
        }

        public void setInterestALL(String interestALL) {
            this.interestALL = interestALL;
        }

        public String getInterestLast() {
            return interestLast;
        }

        public void setInterestLast(String interestLast) {
            this.interestLast = interestLast;
        }

        public String getInterestShare() {
            return interestShare;
        }

        public void setInterestShare(String interestShare) {
            this.interestShare = interestShare;
        }

        public String getInterestProduct() {
            return interestProduct;
        }

        public void setInterestProduct(String interestProduct) {
            this.interestProduct = interestProduct;
        }

        public String getInterestTeam() {
            return interestTeam;
        }

        public void setInterestTeam(String interestTeam) {
            this.interestTeam = interestTeam;
        }

        public String getInterestProductLast() {
            return interestProductLast;
        }

        public void setInterestProductLast(String interestProductLast) {
            this.interestProductLast = interestProductLast;
        }
    }
}
