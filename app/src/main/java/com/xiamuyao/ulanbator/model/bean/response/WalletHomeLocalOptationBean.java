package com.xiamuyao.ulanbator.model.bean.response;

import com.xiamuyao.ulanbator.model.bean.WalletListBean;

import java.util.List;

/**
 * 本地操作一次 返回给ViewModel
 */
public class WalletHomeLocalOptationBean {

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
        private List<WalletListBean> list;
        private String userSumMoney;

        public String getUserSumMoney() {
            return userSumMoney;
        }

        public void setUserSumMoney(String userSumMoney) {
            this.userSumMoney = userSumMoney;
        }

        public List<WalletListBean> getList() {
            return list;
        }

        public void setList(List<WalletListBean> list) {
            this.list = list;
        }
    }
}
