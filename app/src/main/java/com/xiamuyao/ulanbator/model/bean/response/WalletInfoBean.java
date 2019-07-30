package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class WalletInfoBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"symbolFeeRate":5,"balance":"710","symbolFeeMax":100,"symbolFeeMin":1,"inviteCode":"69539212","nickname":"MAX","vipType":0,"frozen":"0","list":[{"amount":"+10","balance":"710","createTime":"1564228748688","operationTypeText":"官方投送","stateType":1,"memo":"","operationType":"1"},{"amount":"+700","balance":"700","createTime":"1564226713932","operationTypeText":"官方投送","stateType":1,"memo":"","operationType":"1"}]}
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
         * symbolFeeRate : 5
         * balance : 710
         * symbolFeeMax : 100
         * symbolFeeMin : 1
         * inviteCode : 69539212
         * nickname : MAX
         * vipType : 0
         * frozen : 0
         * list : [{"amount":"+10","balance":"710","createTime":"1564228748688","operationTypeText":"官方投送","stateType":1,"memo":"","operationType":"1"},{"amount":"+700","balance":"700","createTime":"1564226713932","operationTypeText":"官方投送","stateType":1,"memo":"","operationType":"1"}]
         */

        private int symbolFeeRate;
        private String balance;
        private int symbolFeeMax;
        private int symbolFeeMin;
        private String inviteCode;
        private String nickname;
        private int vipType;
        private String frozen;
        private List<ListBean> list;

        public int getSymbolFeeRate() {
            return symbolFeeRate;
        }

        public void setSymbolFeeRate(int symbolFeeRate) {
            this.symbolFeeRate = symbolFeeRate;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public int getSymbolFeeMax() {
            return symbolFeeMax;
        }

        public void setSymbolFeeMax(int symbolFeeMax) {
            this.symbolFeeMax = symbolFeeMax;
        }

        public int getSymbolFeeMin() {
            return symbolFeeMin;
        }

        public void setSymbolFeeMin(int symbolFeeMin) {
            this.symbolFeeMin = symbolFeeMin;
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

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public String getFrozen() {
            return frozen;
        }

        public void setFrozen(String frozen) {
            this.frozen = frozen;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * amount : +10
             * balance : 710
             * createTime : 1564228748688
             * operationTypeText : 官方投送
             * stateType : 1
             * memo :
             * operationType : 1
             */

            private String amount;
            private String balance;
            private String createTime;
            private String operationTypeText;
            private int stateType;
            private String memo;
            private String operationType;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getOperationTypeText() {
                return operationTypeText;
            }

            public void setOperationTypeText(String operationTypeText) {
                this.operationTypeText = operationTypeText;
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

            public String getOperationType() {
                return operationType;
            }

            public void setOperationType(String operationType) {
                this.operationType = operationType;
            }
        }
    }
}
