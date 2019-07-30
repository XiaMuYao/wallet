package com.xiamuyao.ulanbator.model.bean.response;

public class GetMoenyInfoBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"ethUSD":"0","eos":"0","vipType":0,"token":"0","btc":"0","etc":"0","usdtUSD":"0","eosUSD":"0","inviteCode":"63310259","ltcUSD":"0","nickname":"MAX","eth":"0","usdt":"0","etcUSD":"0","tokenUSD":"0","ltc":"0","btcUSD":"0"}
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
         * ethUSD : 0
         * eos : 0
         * vipType : 0
         * token : 0
         * btc : 0
         * etc : 0
         * usdtUSD : 0
         * eosUSD : 0
         * inviteCode : 63310259
         * ltcUSD : 0
         * nickname : MAX
         * eth : 0
         * usdt : 0
         * etcUSD : 0
         * tokenUSD : 0
         * ltc : 0
         * btcUSD : 0
         */

        private String ethUSD;
        private String eos;
        private int vipType;
        private String token;
        private String btc;
        private String etc;
        private String usdtUSD;
        private String eosUSD;
        private String inviteCode;
        private String ltcUSD;
        private String nickname;
        private String eth;
        private String usdt;
        private String etcUSD;
        private String tokenUSD;
        private String ltc;
        private String btcUSD;

        public String getEthUSD() {
            return ethUSD;
        }

        public void setEthUSD(String ethUSD) {
            this.ethUSD = ethUSD;
        }

        public String getEos() {
            return eos;
        }

        public void setEos(String eos) {
            this.eos = eos;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

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

        public String getUsdtUSD() {
            return usdtUSD;
        }

        public void setUsdtUSD(String usdtUSD) {
            this.usdtUSD = usdtUSD;
        }

        public String getEosUSD() {
            return eosUSD;
        }

        public void setEosUSD(String eosUSD) {
            this.eosUSD = eosUSD;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public String getLtcUSD() {
            return ltcUSD;
        }

        public void setLtcUSD(String ltcUSD) {
            this.ltcUSD = ltcUSD;
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

        public String getUsdt() {
            return usdt;
        }

        public void setUsdt(String usdt) {
            this.usdt = usdt;
        }

        public String getEtcUSD() {
            return etcUSD;
        }

        public void setEtcUSD(String etcUSD) {
            this.etcUSD = etcUSD;
        }

        public String getTokenUSD() {
            return tokenUSD;
        }

        public void setTokenUSD(String tokenUSD) {
            this.tokenUSD = tokenUSD;
        }

        public String getLtc() {
            return ltc;
        }

        public void setLtc(String ltc) {
            this.ltc = ltc;
        }

        public String getBtcUSD() {
            return btcUSD;
        }

        public void setBtcUSD(String btcUSD) {
            this.btcUSD = btcUSD;
        }
    }
}
