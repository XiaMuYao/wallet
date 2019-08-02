package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class GetInviteListBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"list":[{"createTime":"1564581139377","inviteCode":"09263012","nickname":"MAX","vipType":0},{"createTime":"1564509355579","inviteCode":"21808813","nickname":"MAX","vipType":0},{"createTime":"1564509291751","inviteCode":"93165186","nickname":"MAX11111","vipType":0},{"createTime":"1564505207389","inviteCode":"12086510","nickname":"MAX","vipType":0},{"createTime":"1564504539886","inviteCode":"29133953","nickname":"高贵妃","vipType":0},{"createTime":"1564495981635","inviteCode":"95958630","nickname":"MAX12","vipType":0},{"createTime":"1564495192951","inviteCode":"15239055","nickname":"MAX","vipType":0},{"createTime":"1564494854990","inviteCode":"13519511","nickname":"MAX","vipType":0},{"createTime":"1564494690059","inviteCode":"86923589","nickname":"MAX","vipType":0},{"createTime":"1564494060656","inviteCode":"21120165","nickname":"MAX","vipType":0},{"createTime":"1564491403436","inviteCode":"26056920","nickname":"MAX","vipType":0},{"createTime":"1564488228818","inviteCode":"88208061","nickname":"MAX","vipType":0}]}
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
             * createTime : 1564581139377
             * inviteCode : 09263012
             * nickname : MAX
             * vipType : 0
             */

            private String createTime;
            private String inviteCode;
            private String nickname;
            private int vipType;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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
        }
    }
}
