package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class MoneyProudyInfoBean {


    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"productId":"1","interestMax":0.2,"listSymbolUsd":[{"amount":"4,743.577632","symbolName":"btc","symbolType":1},{"amount":"1,256.422368","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"400.12","symbolName":"token","symbolType":7}],"stateType":2,"memo":"","title":"S1","leaveDay":"30","listSymbolBalance":[{"amount":"9.501157281","symbolName":"btc","symbolType":1},{"amount":"14","symbolName":"eth","symbolType":2},{"amount":"30","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"9,980,000","symbolName":"token","symbolType":7}],"userAmountMin":100,"listSymbolFrozen":[{"amount":"0.498842719","symbolName":"btc","symbolType":1},{"amount":"6","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"20,000","symbolName":"token","symbolType":7}],"leaveRate":5,"money":"1,000","intro":"门槛：$100~$1000","interestMin":0.1,"stateRate":100,"userAmountMax":200}
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
         * productId : 1
         * interestMax : 0.2
         * listSymbolUsd : [{"amount":"4,743.577632","symbolName":"btc","symbolType":1},{"amount":"1,256.422368","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"400.12","symbolName":"token","symbolType":7}]
         * stateType : 2
         * memo :
         * title : S1
         * leaveDay : 30
         * listSymbolBalance : [{"amount":"9.501157281","symbolName":"btc","symbolType":1},{"amount":"14","symbolName":"eth","symbolType":2},{"amount":"30","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"9,980,000","symbolName":"token","symbolType":7}]
         * userAmountMin : 100
         * listSymbolFrozen : [{"amount":"0.498842719","symbolName":"btc","symbolType":1},{"amount":"6","symbolName":"eth","symbolType":2},{"amount":"0","symbolName":"ltc","symbolType":3},{"amount":"0","symbolName":"eos","symbolType":4},{"amount":"0","symbolName":"etc","symbolType":5},{"amount":"0","symbolName":"usdt","symbolType":6},{"amount":"20,000","symbolName":"token","symbolType":7}]
         * leaveRate : 5
         * money : 1,000
         * intro : 门槛：$100~$1000
         * interestMin : 0.1
         * stateRate : 100
         * userAmountMax : 200
         */

        private String productId;
        private String interestMax;
        private int stateType;
        private String memo;
        private String title;
        private String leaveDay;
        private String userAmountMin;
        private int leaveRate;
        private String money;
        private String intro;
        private String interestMin;
        private int stateRate;
        private String userAmountMax;
        private String userAmountMaxSum;
        private List<ListSymbolUsdBean> listSymbolUsd;
        private List<ListSymbolBalanceBean> listSymbolBalance;
        private List<ListSymbolFrozenBean> listSymbolFrozen;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getUserAmountMaxSum() {
            return userAmountMaxSum;
        }

        public void setUserAmountMaxSum(String userAmountMaxSum) {
            this.userAmountMaxSum = userAmountMaxSum;
        }

        public String getInterestMax() {
            return interestMax;
        }

        public void setInterestMax(String interestMax) {
            this.interestMax = interestMax;
        }

        public void setInterestMin(String interestMin) {
            this.interestMin = interestMin;
        }

        public void setUserAmountMax(String userAmountMax) {
            this.userAmountMax = userAmountMax;
        }

        public int getStateType() {
            return stateType;
        }

        public void setStateType(int stateType) {
            this.stateType = stateType;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLeaveDay() {
            return leaveDay;
        }

        public void setLeaveDay(String leaveDay) {
            this.leaveDay = leaveDay;
        }

        public String getUserAmountMin() {
            return userAmountMin;
        }

        public void setUserAmountMin(String userAmountMin) {
            this.userAmountMin = userAmountMin;
        }

        public int getLeaveRate() {
            return leaveRate;
        }

        public void setLeaveRate(int leaveRate) {
            this.leaveRate = leaveRate;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getInterestMin() {
            return interestMin;
        }

        public int getStateRate() {
            return stateRate;
        }

        public void setStateRate(int stateRate) {
            this.stateRate = stateRate;
        }

        public String getUserAmountMax() {
            return userAmountMax;
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

        public List<ListSymbolFrozenBean> getListSymbolFrozen() {
            return listSymbolFrozen;
        }

        public void setListSymbolFrozen(List<ListSymbolFrozenBean> listSymbolFrozen) {
            this.listSymbolFrozen = listSymbolFrozen;
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
    }
}
