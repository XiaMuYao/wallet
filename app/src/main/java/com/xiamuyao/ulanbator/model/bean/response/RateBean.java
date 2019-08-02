package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class RateBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"BTCKRW":"11781855.3899584600000000","USDTUSD":"1.0013000000000000","BTCCNY":"68730.6585000000000000","BTCUSD":"9981.7071272500000000","list":[{"rateName":"USDTCNY","rate":"6.9000000000000000"},{"rateName":"USDTUSD","rate":"1.0013000000000000"},{"rateName":"USDTKRW","rate":"1182.8026089800000000"},{"rateName":"USDTJPY","rate":"108.6892635700000000"},{"rateName":"BTCCNY","rate":"68730.6585000000000000"},{"rateName":"BTCUSD","rate":"9981.7071272500000000"},{"rateName":"BTCKRW","rate":"11781855.3899584600000000"},{"rateName":"BTCJPY","rate":"1082649.9502965400000000"},{"rateName":"USDCNY","rate":"6.8800000000000000"},{"rateName":"USDKRW","rate":"1180.9131479500000000"},{"rateName":"USDJPY","rate":"108.5156385500000000"},{"rateName":"TOKENUSDT","rate":0.02}],"USDJPY":"108.5156385500000000","TOKENUSDT":0.02,"USDCNY":"6.8800000000000000","USDKRW":"1180.9131479500000000","USDTCNY":"6.9000000000000000","USDTKRW":"1182.8026089800000000","USDTJPY":"108.6892635700000000","BTCJPY":"1082649.9502965400000000"}
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
         * BTCKRW : 11781855.3899584600000000
         * USDTUSD : 1.0013000000000000
         * BTCCNY : 68730.6585000000000000
         * BTCUSD : 9981.7071272500000000
         * list : [{"rateName":"USDTCNY","rate":"6.9000000000000000"},{"rateName":"USDTUSD","rate":"1.0013000000000000"},{"rateName":"USDTKRW","rate":"1182.8026089800000000"},{"rateName":"USDTJPY","rate":"108.6892635700000000"},{"rateName":"BTCCNY","rate":"68730.6585000000000000"},{"rateName":"BTCUSD","rate":"9981.7071272500000000"},{"rateName":"BTCKRW","rate":"11781855.3899584600000000"},{"rateName":"BTCJPY","rate":"1082649.9502965400000000"},{"rateName":"USDCNY","rate":"6.8800000000000000"},{"rateName":"USDKRW","rate":"1180.9131479500000000"},{"rateName":"USDJPY","rate":"108.5156385500000000"},{"rateName":"TOKENUSDT","rate":0.02}]
         * USDJPY : 108.5156385500000000
         * TOKENUSDT : 0.02
         * USDCNY : 6.8800000000000000
         * USDKRW : 1180.9131479500000000
         * USDTCNY : 6.9000000000000000
         * USDTKRW : 1182.8026089800000000
         * USDTJPY : 108.6892635700000000
         * BTCJPY : 1082649.9502965400000000
         */

        private String BTCKRW;
        private String USDTUSD;
        private String BTCCNY;
        private String BTCUSD;
        private String USDJPY;
        private double TOKENUSDT;
        private String USDCNY;
        private String USDKRW;
        private String USDTCNY;
        private String USDTKRW;
        private String USDTJPY;
        private String BTCJPY;
        private List<ListBean> list;

        public String getBTCKRW() {
            return BTCKRW;
        }

        public void setBTCKRW(String BTCKRW) {
            this.BTCKRW = BTCKRW;
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

        public String getBTCUSD() {
            return BTCUSD;
        }

        public void setBTCUSD(String BTCUSD) {
            this.BTCUSD = BTCUSD;
        }

        public String getUSDJPY() {
            return USDJPY;
        }

        public void setUSDJPY(String USDJPY) {
            this.USDJPY = USDJPY;
        }

        public double getTOKENUSDT() {
            return TOKENUSDT;
        }

        public void setTOKENUSDT(double TOKENUSDT) {
            this.TOKENUSDT = TOKENUSDT;
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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * rateName : USDTCNY
             * rate : 6.9000000000000000
             */

            private String rateName;
            private String rate;

            public String getRateName() {
                return rateName;
            }

            public void setRateName(String rateName) {
                this.rateName = rateName;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }
        }
    }
}
