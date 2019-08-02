package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class GetMoenyInfoBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"nickname":"我是昵称","vipType":0,"listSymbolFrozen":[{"amount":"0.498842719","symbolName":"btc","symbolType":1},{"amount":"6","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"20,000","symbolName":"token","symbolType":7}],"listSymbolUsd":[{"amount":"4,743.577632","symbolName":"btc","symbolType":1},{"amount":"1,256.422368","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"400.12","symbolName":"token","symbolType":7}],"inviteCode":"53391699","listSymbolBalance":[{"amount":"9.501157281","symbolName":"btc","symbolType":1},{"amount":"14","symbolName":"eth","symbolType":2},{"amount":"30","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"9,980,000","symbolName":"token","symbolType":7}]}
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
         * nickname : 我是昵称
         * vipType : 0
         * listSymbolFrozen : [{"amount":"0.498842719","symbolName":"btc","symbolType":1},{"amount":"6","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"20,000","symbolName":"token","symbolType":7}]
         * listSymbolUsd : [{"amount":"4,743.577632","symbolName":"btc","symbolType":1},{"amount":"1,256.422368","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"400.12","symbolName":"token","symbolType":7}]
         * inviteCode : 53391699
         * listSymbolBalance : [{"amount":"9.501157281","symbolName":"btc","symbolType":1},{"amount":"14","symbolName":"eth","symbolType":2},{"amount":"30","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"9,980,000","symbolName":"token","symbolType":7}]
         */

        private String nickname;
        private String sum;
        private int vipType;
        private String inviteCode;
        private List<ListSymbolFrozenBean> listSymbolFrozen;
        private List<ListSymbolUsdBean> listSymbolUsd;
        private List<ListSymbolBalanceBean> listSymbolBalance;

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public List<ListSymbolFrozenBean> getListSymbolFrozen() {
            return listSymbolFrozen;
        }

        public void setListSymbolFrozen(List<ListSymbolFrozenBean> listSymbolFrozen) {
            this.listSymbolFrozen = listSymbolFrozen;
        }

        public List<ListSymbolUsdBean> getListSymbolUsd() {
            return listSymbolUsd;
        }

        public void setListSymbolUsd(List<ListSymbolUsdBean> listSymbolUsd) {
            this.listSymbolUsd = listSymbolUsd;
        }

        public List<ListSymbolBalanceBean> getListSymbolBalance() {
            return listSymbolBalance;
        }

        public void setListSymbolBalance(List<ListSymbolBalanceBean> listSymbolBalance) {
            this.listSymbolBalance = listSymbolBalance;
        }

        public static class ListSymbolFrozenBean {
            /**
             * amount : 0.498842719
             * symbolName : btc
             * symbolType : 1
             */

            private String amount;
            private String symbolName;
            private int symbolType;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getSymbolName() {
                return symbolName;
            }

            public void setSymbolName(String symbolName) {
                this.symbolName = symbolName;
            }

            public int getSymbolType() {
                return symbolType;
            }

            public void setSymbolType(int symbolType) {
                this.symbolType = symbolType;
            }
        }

        public static class ListSymbolUsdBean {
            /**
             * amount : 4,743.577632
             * symbolName : btc
             * symbolType : 1
             */

            private String amount;
            private String symbolName;
            private int symbolType;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getSymbolName() {
                return symbolName;
            }

            public void setSymbolName(String symbolName) {
                this.symbolName = symbolName;
            }

            public int getSymbolType() {
                return symbolType;
            }

            public void setSymbolType(int symbolType) {
                this.symbolType = symbolType;
            }
        }

        public static class ListSymbolBalanceBean {
            /**
             * amount : 9.501157281
             * symbolName : btc
             * symbolType : 1
             */

            private String amount;
            private String symbolName;
            private int symbolType;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getSymbolName() {
                return symbolName;
            }

            public void setSymbolName(String symbolName) {
                this.symbolName = symbolName;
            }

            public int getSymbolType() {
                return symbolType;
            }

            public void setSymbolType(int symbolType) {
                this.symbolType = symbolType;
            }
        }
    }
}
