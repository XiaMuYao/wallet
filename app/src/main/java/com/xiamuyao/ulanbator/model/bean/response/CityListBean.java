package com.xiamuyao.ulanbator.model.bean.response;

import java.util.List;

public class CityListBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"list":[{"titleEN":"Korea","countryCode":"KR","titleCN":"韩国","titleKO":"韩国韩文","titleJP":"韩国日文","countryId":"2","dialingCode":"82"},{"titleEN":"China","countryCode":"CN","titleCN":"中国","titleKO":"中国韩文","titleJP":"中国日文","countryId":"1","dialingCode":"86"}]}
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
             * titleEN : Korea
             * countryCode : KR
             * titleCN : 韩国
             * titleKO : 韩国韩文
             * titleJP : 韩国日文
             * countryId : 2
             * dialingCode : 82
             */

            private String titleEN;
            private String countryCode;
            private String titleCN;
            private String titleKO;
            private String titleJP;
            private String countryId;
            private String dialingCode;
            private String showCityName;

            public String getShowCityName() {
                return showCityName;
            }

            public void setShowCityName(String showCityName) {
                this.showCityName = showCityName;
            }

            public String getTitleEN() {
                return titleEN;
            }

            public void setTitleEN(String titleEN) {
                this.titleEN = titleEN;
            }

            public String getCountryCode() {
                return countryCode;
            }

            public void setCountryCode(String countryCode) {
                this.countryCode = countryCode;
            }

            public String getTitleCN() {
                return titleCN;
            }

            public void setTitleCN(String titleCN) {
                this.titleCN = titleCN;
            }

            public String getTitleKO() {
                return titleKO;
            }

            public void setTitleKO(String titleKO) {
                this.titleKO = titleKO;
            }

            public String getTitleJP() {
                return titleJP;
            }

            public void setTitleJP(String titleJP) {
                this.titleJP = titleJP;
            }

            public String getCountryId() {
                return countryId;
            }

            public void setCountryId(String countryId) {
                this.countryId = countryId;
            }

            public String getDialingCode() {
                return dialingCode;
            }

            public void setDialingCode(String dialingCode) {
                this.dialingCode = dialingCode;
            }
        }
    }
}
