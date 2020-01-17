package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

final class zzbj implements ChannelApi.ChannelListener {
    private final String zzVo;
    private final ChannelApi.ChannelListener zzbtb;

    zzbj(String str, ChannelApi.ChannelListener channelListener) {
        this.zzVo = (String) zzx.zzz(str);
        this.zzbtb = (ChannelApi.ChannelListener) zzx.zzz(channelListener);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof zzbj)) {
                return false;
            }
            zzbj zzbj = (zzbj) obj;
            if (!this.zzbtb.equals(zzbj.zzbtb) || !this.zzVo.equals(zzbj.zzVo)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (this.zzVo.hashCode() * 31) + this.zzbtb.hashCode();
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
        this.zzbtb.onChannelClosed(channel, i, i2);
    }

    public void onChannelOpened(Channel channel) {
        this.zzbtb.onChannelOpened(channel);
    }

    public void onInputClosed(Channel channel, int i, int i2) {
        this.zzbtb.onInputClosed(channel, i, i2);
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
        this.zzbtb.onOutputClosed(channel, i, i2);
    }
}
