package com.xiamuyao.ulanbator.model.bean.response;

public class WalletHomeBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"btc":"0","etc":"0","inviteCode":"","nickname":"MAX","eth":"0","eos":"0","usdt":"0","ltc":"0","token":"0","vipType":0}
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
         * btc : 0
         * etc : 0
         * inviteCode :
         * nickname : MAX
         * eth : 0
         * eos : 0
         * usdt : 0
         * ltc : 0
         * token : 0
         * vipType : 0
         */

        private String btc;
        private String etc;
        private String inviteCode;
        private String nickname;
        private String eth;
        private String eos;
        private String usdt;
        private String ltc;
        private String token;
        private int vipType;

        public String getBtc() {
            return btc;
        }

        public void setBtc(String btc) {
            this.btc = btc;
        }

        public String getEtc() {
            return etc;
        }

        public void setEtc(String etc) {
            this.etc = etc;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getEth() {
            return eth;
        }

        public void setEth(String eth) {
            this.eth = eth;
        }

        public String getEos() {
            return eos;
        }

        public void setEos(String eos) {
            this.eos = eos;
        }

        public String getUsdt() {
            return usdt;
        }

        public void setUsdt(String usdt) {
            this.usdt = usdt;
        }

        public String getLtc() {
            return ltc;
        }

        public void setLtc(String ltc) {
            this.ltc = ltc;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }
    }
}
