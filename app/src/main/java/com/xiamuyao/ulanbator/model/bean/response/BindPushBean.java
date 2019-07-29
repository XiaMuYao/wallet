package com.xiamuyao.ulanbator.model.bean.response;

public class BindPushBean {

    /**
     * result : {"returnCode":"0","returnUserMessage":"綁定成功","returnMessage":"綁定成功"}
     * data : {"versionNoIOS":"1","versionAndroid":"0.0.1","androidUrl":"http://xx.oss-cn-hongkong.aliyuncs.com/xx.apk","versionNoAndroid":"1","appKey":"3b366f4ed1719695a67024a41d39676e","versionIOS":"0.0.1","iOSUrl":"https://app.goceshi.com/"}
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
         * returnUserMessage : 綁定成功
         * returnMessage : 綁定成功
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
         * versionNoIOS : 1
         * versionAndroid : 0.0.1
         * androidUrl : http://xx.oss-cn-hongkong.aliyuncs.com/xx.apk
         * versionNoAndroid : 1
         * appKey : 3b366f4ed1719695a67024a41d39676e
         * versionIOS : 0.0.1
         * iOSUrl : https://app.goceshi.com/
         */

        private String versionNoIOS;
        private String versionAndroid;
        private String androidUrl;
        private String versionNoAndroid;
        private String appKey;
        private String versionIOS;
        private String iOSUrl;

        public String getVersionNoIOS() {
            return versionNoIOS;
        }

        public void setVersionNoIOS(String versionNoIOS) {
            this.versionNoIOS = versionNoIOS;
        }

        public String getVersionAndroid() {
            return versionAndroid;
        }

        public void setVersionAndroid(String versionAndroid) {
            this.versionAndroid = versionAndroid;
        }

        public String getAndroidUrl() {
            return androidUrl;
        }

        public void setAndroidUrl(String androidUrl) {
            this.androidUrl = androidUrl;
        }

        public String getVersionNoAndroid() {
            return versionNoAndroid;
        }

        public void setVersionNoAndroid(String versionNoAndroid) {
            this.versionNoAndroid = versionNoAndroid;
        }

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getVersionIOS() {
            return versionIOS;
        }

        public void setVersionIOS(String versionIOS) {
            this.versionIOS = versionIOS;
        }

        public String getIOSUrl() {
            return iOSUrl;
        }

        public void setIOSUrl(String iOSUrl) {
            this.iOSUrl = iOSUrl;
        }
    }
}

