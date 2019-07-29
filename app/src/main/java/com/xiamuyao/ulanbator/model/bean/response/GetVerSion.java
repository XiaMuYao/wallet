package com.xiamuyao.ulanbator.model.bean.response;

public class GetVerSion {

    /**
     * result : {"returnCode":"0","returnUserMessage":"成功","returnMessage":"成功"}
     * data : {"versionNoAndroid":"1","versionNoIOS":"1","versionIOS":"0.0.1","versionAndroid":"0.0.1","iOSUrl":"https://app.goceshi.com/","androidUrl":"http://xx.oss-cn-hongkong.aliyuncs.com/xx.apk"}
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
         * versionNoAndroid : 1
         * versionNoIOS : 1
         * versionIOS : 0.0.1
         * versionAndroid : 0.0.1
         * iOSUrl : https://app.goceshi.com/
         * androidUrl : http://xx.oss-cn-hongkong.aliyuncs.com/xx.apk
         */

        private String versionNoAndroid;
        private String versionNoIOS;
        private String versionIOS;
        private String versionAndroid;
        private String iOSUrl;
        private String androidUrl;

        public String getVersionNoAndroid() {
            return versionNoAndroid;
        }

        public void setVersionNoAndroid(String versionNoAndroid) {
            this.versionNoAndroid = versionNoAndroid;
        }

        public String getVersionNoIOS() {
            return versionNoIOS;
        }

        public void setVersionNoIOS(String versionNoIOS) {
            this.versionNoIOS = versionNoIOS;
        }

        public String getVersionIOS() {
            return versionIOS;
        }

        public void setVersionIOS(String versionIOS) {
            this.versionIOS = versionIOS;
        }

        public String getVersionAndroid() {
            return versionAndroid;
        }

        public void setVersionAndroid(String versionAndroid) {
            this.versionAndroid = versionAndroid;
        }

        public String getIOSUrl() {
            return iOSUrl;
        }

        public void setIOSUrl(String iOSUrl) {
            this.iOSUrl = iOSUrl;
        }

        public String getAndroidUrl() {
            return androidUrl;
        }

        public void setAndroidUrl(String androidUrl) {
            this.androidUrl = androidUrl;
        }
    }
}
