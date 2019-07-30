package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class FindBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"list":[{"infoId":"3","createTime":"0","author":"maxflow","intro":"尊敬的用户IEuehdhdjdnh ","coverImagePath":"","title":"关于BTC充值提现业务的通知公告3","url":"http://www.baidu.com"},{"infoId":"2","createTime":"0","author":"maxflow","intro":"尊敬的用户我就弄公司了男","coverImagePath":"","title":"关于BTC充值提现业务的通知公告2","url":"http://www.baidu.com"},{"infoId":"1","createTime":"0","author":"maxflow","intro":"尊敬的用户水电费水电费水电费","coverImagePath":"","title":"关于BTC充值提现业务的通知公告1","url":"http://www.baidu.com"}]}
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
             * infoId : 3
             * createTime : 0
             * author : maxflow
             * intro : 尊敬的用户IEuehdhdjdnh
             * coverImagePath :
             * title : 关于BTC充值提现业务的通知公告3
             * url : http://www.baidu.com
             */

            private String infoId;
            private String createTime;
            private String author;
            private String intro;
            private String coverImagePath;
            private String title;
            private String url;

            public String getInfoId() {
                return infoId;
            }

            public void setInfoId(String infoId) {
                this.infoId = infoId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getCoverImagePath() {
                return coverImagePath;
            }

            public void setCoverImagePath(String coverImagePath) {
                this.coverImagePath = coverImagePath;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
