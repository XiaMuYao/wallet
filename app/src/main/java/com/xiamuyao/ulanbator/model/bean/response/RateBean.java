package com.xiamuyao.ulanbator.model.bean.response;

public class RateBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"BTCKRW":"11333002.8521569400000000","USDJPY":"109.6089456000000000","USDTUSD":"0.9986000000000000","BTCCNY":"65922.4458000000000000","USDCNY":"6.9400000000000000","USDKRW":"1193.4651762600000000","USDTCNY":"6.9200000000000000","BTCUSD":"9511.4640445000000000","USDTKRW":"1189.6460876900000000","USDTJPY":"109.2581969700000000","BTCJPY":"1040833.4635781100000000"}
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
         * BTCKRW : 11333002.8521569400000000
         * BTCJPY : 1040833.4635781100000000
         * BTCCNY : 65922.4458000000000000
         * BTCUSD : 9511.4640445000000000
         * USDJPY : 109.6089456000000000
         * USDTUSD : 0.9986000000000000
         * USDCNY : 6.9400000000000000
         * USDKRW : 1193.4651762600000000
         * USDTCNY : 6.9200000000000000
         * USDTKRW : 1189.6460876900000000
         * USDTJPY : 109.2581969700000000
         */

        private String BTCKRW;
        private String USDJPY;
        private String USDTUSD;
        private String BTCCNY;
        private String USDCNY;
        private String USDKRW;
        private String USDTCNY;
        private String BTCUSD;
        private String USDTKRW;
        private String USDTJPY;
        private String BTCJPY;

        public String getBTCKRW() {
            return BTCKRW;
        }

        public void setBTCKRW(String BTCKRW) {
            this.BTCKRW = BTCKRW;
        }

        public String getUSDJPY() {
            return USDJPY;
        }

        public void setUSDJPY(String USDJPY) {
            this.USDJPY = USDJPY;
        }

        public String getUSDTUSD() {
            return USDTUSD;
        }

        public void setUSDTUSD(String USDTUSD) {
            this.USDTUSD = USDTUSD;
        }

        public String getBTCCNY() {
            return BTCCNY;
        }

        public void setBTCCNY(String BTCCNY) {
            this.BTCCNY = BTCCNY;
        }

        public String getUSDCNY() {
            return USDCNY;
        }

        public void setUSDCNY(String USDCNY) {
            this.USDCNY = USDCNY;
        }

        public String getUSDKRW() {
            return USDKRW;
        }

        public void setUSDKRW(String USDKRW) {
            this.USDKRW = USDKRW;
        }

        public String getUSDTCNY() {
            return USDTCNY;
        }

        public void setUSDTCNY(String USDTCNY) {
            this.USDTCNY = USDTCNY;
        }

        public String getBTCUSD() {
            return BTCUSD;
        }

        public void setBTCUSD(String BTCUSD) {
            this.BTCUSD = BTCUSD;
        }

        public String getUSDTKRW() {
            return USDTKRW;
        }

        public void setUSDTKRW(String USDTKRW) {
            this.USDTKRW = USDTKRW;
        }

        public String getUSDTJPY() {
            return USDTJPY;
        }

        public void setUSDTJPY(String USDTJPY) {
            this.USDTJPY = USDTJPY;
        }

        public String getBTCJPY() {
            return BTCJPY;
        }

        public void setBTCJPY(String BTCJPY) {
            this.BTCJPY = BTCJPY;
        }
    }
}
