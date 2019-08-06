package com.xiamuyao.ulanbator.model.bean;

public class SocketReBean {

    /**
     * channel : market_ethbtc_ticker
     * tick : {"amount":"417.36723636704","high":"0.03198723","vol":"13059.889","low":"0.03193888","rose":"-0.00015677","close":"0.0319527","open":"0.03195771"}
     * event_rep :
     * ts : 1554877511000
     * status : ok
     */

    private String channel;
    private TickBean tick;
    private String event_rep;
    private long ts;
    private String status;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public TickBean getTick() {
        return tick;
    }

    public void setTick(TickBean tick) {
        this.tick = tick;
    }

    public String getEvent_rep() {
        return event_rep;
    }

    public void setEvent_rep(String event_rep) {
        this.event_rep = event_rep;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class TickBean {
        /**
         * amount : 417.36723636704
         * high : 0.03198723
         * vol : 13059.889
         * low : 0.03193888
         * rose : -0.00015677
         * close : 0.0319527
         * open : 0.03195771
         */

        private String amount;
        private String high;
        private String vol;
        private String low;
        private String rose;
        private String close;
        private String open;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getVol() {
            return vol;
        }

        public void setVol(String vol) {
            this.vol = vol;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getRose() {
            return rose;
        }

        public void setRose(String rose) {
            this.rose = rose;
        }

        public String getClose() {
            return close;
        }

        public void setClose(String close) {
            this.close = close;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }


    }
}
