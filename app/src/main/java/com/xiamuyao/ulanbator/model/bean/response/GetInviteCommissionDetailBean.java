package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class GetInviteCommissionDetailBean {


    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"nickname":"MAX","vipType":0,"list":[{"amount":"2","createTime":"0","operationTypeText":"分享收益邀请返佣","operationType":"41"},{"amount":"3","createTime":"0","operationTypeText":"分享收益邀请返佣","operationType":"41"}],"inviteCode":"26056920"}
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
         * nickname : MAX
         * vipType : 0
         * list : [{"amount":"2","createTime":"0","operationTypeText":"分享收益邀请返佣","operationType":"41"},{"amount":"3","createTime":"0","operationTypeText":"分享收益邀请返佣","operationType":"41"}]
         * inviteCode : 26056920
         */

        private String nickname;
        private int vipType;
        private String inviteCode;
        private List<ListBean> list;

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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * amount : 2
             * createTime : 0
             * operationTypeText : 分享收益邀请返佣
             * operationType : 41
             */

            private String amount;
            private String createTime;
            private String operationTypeText;
            private String operationType;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
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

            public String getOperationType() {
                return operationType;
            }

            public void setOperationType(String operationType) {
                this.operationType = operationType;
            }
        }
    }
}
