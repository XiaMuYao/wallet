package com.xiamuyao.ulanbator.model.bean.response;

import java.io.Serializable;
import java.util.List;

public class GetMoneyShopBean implements Serializable{

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"list":[{"userAmountMin":100,"leaveRate":5,"interestMax":0.2,"intro":"门槛：$100~$1000","interestMin":0.1,"stateType":0,"memo":"","stateRate":0,"title":"S1","userAmountMax":200,"leaveDay":"30","productId":""},{"userAmountMin":101,"leaveRate":5,"interestMax":1.2,"intro":"门槛：$1000~$5000","interestMin":1.1,"stateType":0,"memo":"","stateRate":0,"title":"S2","userAmountMax":201,"leaveDay":"30","productId":""},{"userAmountMin":102,"leaveRate":5,"interestMax":2.2,"intro":"门槛：$100000","interestMin":2.1,"stateType":0,"memo":"","stateRate":0,"title":"S3","userAmountMax":202,"leaveDay":"30","productId":""}]}
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

    public static class ResultBean implements Serializable{
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

    public static class DataBean implements Serializable{
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * userAmountMin : 100
             * leaveRate : 5
             * interestMax : 0.2
             * intro : 门槛：$100~$1000
             * interestMin : 0.1
             * stateType : 0
             * memo :
             * stateRate : 0
             * title : S1
             * userAmountMax : 200
             * leaveDay : 30
             * productId :
             */

            private int userAmountMin;
            private int leaveRate;
            private double interestMax;
            private String intro;
            private double interestMin;
            private int stateType;
            private String memo;
            private int stateRate;
            private String title;
            private int userAmountMax;
            private String leaveDay;
            private String productId;
            private String shouyiText;

            public String getShouyiText() {
                return getInterestMin()+ "~" + getInterestMax();
            }

            public void setShouyiText(String shouyiText) {
                this.shouyiText = shouyiText;
            }

            public int getUserAmountMin() {
                return userAmountMin;
            }

            public void setUserAmountMin(int userAmountMin) {
                this.userAmountMin = userAmountMin;
            }

            public int getLeaveRate() {
                return leaveRate;
            }

            public void setLeaveRate(int leaveRate) {
                this.leaveRate = leaveRate;
            }

            public String getInterestMax() {
                return interestMax+"%";
            }

            public void setInterestMax(double interestMax) {
                this.interestMax = interestMax;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getInterestMin() {
                return interestMin+"%";
            }

            public void setInterestMin(double interestMin) {
                this.interestMin = interestMin;
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

            public int getStateRate() {
                return stateRate;
            }

            public void setStateRate(int stateRate) {
                this.stateRate = stateRate;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUserAmountMax() {
                return userAmountMax;
            }

            public void setUserAmountMax(int userAmountMax) {
                this.userAmountMax = userAmountMax;
            }

            public String getLeaveDay() {
                return leaveDay;
            }

            public void setLeaveDay(String leaveDay) {
                this.leaveDay = leaveDay;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }
        }
    }
}
