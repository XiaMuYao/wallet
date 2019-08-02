package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class GetInviteStatisticsBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"userQtyVip3":"0","userQtyVip2":"0","inviteInterest":"0","userQtyVip5":"0","inviteCode":"53391699","userQtyVip4":"0","nickname":"我是昵称","userQtyALL":"0","vipType":0,"userQtyVip1":"0","userQtyVip0":"0","list":[{"vipType":0,"vipQty":"0"},{"vipType":1,"vipQty":"0"},{"vipType":2,"vipQty":"0"},{"vipType":3,"vipQty":"0"},{"vipType":4,"vipQty":"0"},{"vipType":5,"vipQty":"0"}]}
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
         * userQtyVip3 : 0
         * userQtyVip2 : 0
         * inviteInterest : 0
         * userQtyVip5 : 0
         * inviteCode : 53391699
         * userQtyVip4 : 0
         * nickname : 我是昵称
         * userQtyALL : 0
         * vipType : 0
         * userQtyVip1 : 0
         * userQtyVip0 : 0
         * list : [{"vipType":0,"vipQty":"0"},{"vipType":1,"vipQty":"0"},{"vipType":2,"vipQty":"0"},{"vipType":3,"vipQty":"0"},{"vipType":4,"vipQty":"0"},{"vipType":5,"vipQty":"0"}]
         */

        private String userQtyVip3;
        private String userQtyVip2;
        private String inviteInterest;
        private String userQtyVip5;
        private String inviteCode;
        private String userQtyVip4;
        private String nickname;
        private String userQtyALL;
        private int vipType;
        private String userQtyVip1;
        private String userQtyVip0;
        private String sum="0";
        private List<ListBean> list;

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }

        public String getUserQtyVip3() {
            return userQtyVip3;
        }

        public void setUserQtyVip3(String userQtyVip3) {
            this.userQtyVip3 = userQtyVip3;
        }

        public String getUserQtyVip2() {
            return userQtyVip2;
        }

        public void setUserQtyVip2(String userQtyVip2) {
            this.userQtyVip2 = userQtyVip2;
        }

        public String getInviteInterest() {
            return inviteInterest;
        }

        public void setInviteInterest(String inviteInterest) {
            this.inviteInterest = inviteInterest;
        }

        public String getUserQtyVip5() {
            return userQtyVip5;
        }

        public void setUserQtyVip5(String userQtyVip5) {
            this.userQtyVip5 = userQtyVip5;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public String getUserQtyVip4() {
            return userQtyVip4;
        }

        public void setUserQtyVip4(String userQtyVip4) {
            this.userQtyVip4 = userQtyVip4;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserQtyALL() {
            return userQtyALL;
        }

        public void setUserQtyALL(String userQtyALL) {
            this.userQtyALL = userQtyALL;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public String getUserQtyVip1() {
            return userQtyVip1;
        }

        public void setUserQtyVip1(String userQtyVip1) {
            this.userQtyVip1 = userQtyVip1;
        }

        public String getUserQtyVip0() {
            return userQtyVip0;
        }

        public void setUserQtyVip0(String userQtyVip0) {
            this.userQtyVip0 = userQtyVip0;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * vipType : 0
             * vipQty : 0
             */

            private int vipType;
            private String vipQty;

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public String getVipQty() {
                return vipQty;
            }

            public void setVipQty(String vipQty) {
                this.vipQty = vipQty;
            }
        }
    }
}
