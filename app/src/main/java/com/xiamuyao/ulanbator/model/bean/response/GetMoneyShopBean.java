package com.xiamuyao.ulanbator.model.bean.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class GetMoneyShopBean implements Serializable{


    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"list":[{"productId":"1","interestMax":0.2,"stateType":2,"memo":"","title":"S1","leaveDay":"30","userAmountMin":"100","leaveRate":5,"money":"1,000","intro":"门槛：$100~$1000","interestMin":0.1,"stateRate":100,"userAmountMax":"200","userAmountMaxSum":"1,000"},{"productId":"2","interestMax":0.3,"stateType":2,"memo":"","title":"S2","leaveDay":"30","userAmountMin":"1,000","leaveRate":5,"money":"5,000","intro":"门槛：$1000~$5000","interestMin":0.2,"stateRate":100,"userAmountMax":"5,000","userAmountMaxSum":"5,000"},{"productId":"3","interestMax":0.4,"stateType":0,"memo":"","title":"S3","leaveDay":"30","userAmountMin":"100,000","leaveRate":5,"money":"0","intro":"门槛：$100000","interestMin":0.3,"stateRate":0,"userAmountMax":"999,999,999","userAmountMaxSum":"999,999,999"},{"productId":"8","interestMax":0.4,"stateType":1,"memo":"","title":"S4","leaveDay":"30","userAmountMin":"100","leaveRate":5,"money":"10,686.711424","intro":"门槛：$100-$9999999","interestMin":0.3,"stateRate":0,"userAmountMax":"9,999,999","userAmountMaxSum":"999,999,999"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * productId : 1
             * interestMax : 0.2
             * stateType : 2
             * memo :
             * title : S1
             * leaveDay : 30
             * userAmountMin : 100
             * leaveRate : 5
             * money : 1,000
             * intro : 门槛：$100~$1000
             * interestMin : 0.1
             * stateRate : 100
             * userAmountMax : 200
             * userAmountMaxSum : 1,000
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
            private String shouyiText;

            public String getShouyiText() {
                return getInterestMin()+ "~" + getInterestMax();
            }

            public void setShouyiText(String shouyiText) {
                this.shouyiText = shouyiText;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
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

            public String getInterestMax() {
                return    new BigDecimal(interestMax).stripTrailingZeros().toPlainString()+"%";
            }

            public void setInterestMax(String interestMax) {
                this.interestMax = interestMax;
            }

            public String getInterestMin() {
                return new BigDecimal(interestMin).stripTrailingZeros().toPlainString()+"%";
            }

            public void setInterestMin(String interestMin) {
                this.interestMin = interestMin;
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

            public void setUserAmountMax(String userAmountMax) {
                this.userAmountMax = userAmountMax;
            }

            public String getUserAmountMaxSum() {
                return userAmountMaxSum;
            }

            public void setUserAmountMaxSum(String userAmountMaxSum) {
                this.userAmountMaxSum = userAmountMaxSum;
            }
        }
    }
}
