package com.cherish.app;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Keep;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

import java.util.Locale;

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/24 13:43
 * @version: 2.0
 */
public class SophixStubApplication  extends SophixApplication {
    private final String TAG = "SophixStubApplication";

    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
    @Keep
    @SophixEntry(App.class)
    static class RealApplicationStub {
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//         如果需要使用MultiDex，需要在此处调用。
//         MultiDex.install(this);
        initSophix();
    }

    private void initSophix() {
        String appVersion = "1.0";
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;
        } catch (Exception e) {
        }
        final SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData("27551420", "bc1b50349a9ab759d40ecac1c2ea26fb", "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCum0KptXjKOmmQA52WLvSAxNDHVu4dv8Ibk9bcicu4U1BtD6slgRnC2dTgxkoPpyZU+oDIWF+jqb/gnsqilDM9c4WPmA+r5JnW1UxTpVN265DCwAAKCcPcwvH/cM4Q+abhKs7YV3SYbzsDVElf40cxmBm+ke42LkOezFfCOvh53RGwbn5uYotpfy4O+C/tZ0vTME2a7pqmPtDEdk7gU5RDo5lFzxQGjCCV0/RDvcDhq4SQ50HrtvN2kgwNwZxLXomrr36yvsgWuHB7FogFEUUPQG3N/MDUT9i4/bZ/LE1Oc/fn9zFv3hSlg/PD3jcTNa/hc0DP6W8BcK/QjU/kWaEDAgMBAAECggEAbiPJ/TtXolkOVaWyNhYQbVm5SMTxFxrq2nJ7Skoxk2gah3EmyFWTZnH58n+iIBWT/G635ai5S4e8XXhM4hkR6WWBjn6hBBEDaZzKtMjIyW72taJfY/Wc8xiVhkgl9FdGiSpzp8wi5DTlyMfWMQIw2nvTYX60AMFWLkk/4mlIa7WWaoMxAE6H1VOQHFRS6Kco2Vk+H2JCs+Fbu4gO2CvL+gTR7yhlA/2oVV4d8vWdAzYeXcm4/cMNL3ZJr4OZYlMqxfZUYLRHDxXgoomBw1BENd9hdjJFmJrjSdOw9HxZOrZmRn35uin8He5oL1twIIkg/fR7IXkR9td6PdDx+zcJwQKBgQDxajFgrwOv2VagrZwwOupO7Z2D4h5unHvoMH3bJCAXUsv2s/B+Ig00q7D9MRuF+2h7VXeAcLI8qJqtuS+aMucaMNFVVqANlazkn6KPLNF4pjjBsYcAo/qYspr9/f81c/Ele2jx63i8vyoYXEv9pzsmasV30OVgZkhYk52rKs3gKQKBgQC5J8lE3N/vLpejQMirnwGMdjGRdwVqP2NyUc+EWsN57q6wsF83UUtycpSXGztPYRpHgUm3YKNMphCT0qSH3hRsFFZOq3R1q/D4OWr6hiXw+4xYeirSeeXClZBOMJcytdQi6/J94z4kjTyqJoboUwb8ppNGOOC2pczCNmbdGcvtSwKBgQChZSNZxeerGpwFk8uFmv2mgsj5sKQzwr47vp+FcCNcNGhTqHyxdsZpXhdXTgteiXOScNMRtUYTs4ylc9bVOg6yvcxVRzJ9ooER339oRMhN5qKvK6Zb0UTp7Q4dnD+QVtDzBAxnH8t6NDtKSforvC+ZQWx+69NNnVPkk9um4Vj98QKBgGm2p5mjqk97gKR7Fpe2P0IdMYvmMrdI3dSllR/yWm1Bs4e6C4Mf7T244dGsgJ5/yGtPC/GhQVs/7XMY70uLpolWyzg7eFC/DOQMlGHZOcxvMuBJUC2/30jL8ApUf986JZaStG7f0dk4soxLVvdKgFC8IpYTX2mpHFE+klhmpCIlAoGAeOfZAeB4W+RXDvr70j2XssxAtFVnBE1+prqHEay1OeUhAcKxWCGHJF4wpF4OvkEOLmOuu/OCiuSFWrbx57fc9tFISlehQd5QovvFPKCxjpSHt+DR6Fhu6fo92N06PL+uLv7VCw05cvsybWQ3kRdIhyfT86vsGfifnSkqBtVNhTg=")
                .setEnableDebug(true)
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            Log.i(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            Log.i(TAG, "sophix preload patch success. restart app to make effect.");
                        }else {
                            Log.i(TAG, String.format(Locale.CHINA,"sophix preload patch error. code=%d info=%s handlePatchVersion=%d",code,info,handlePatchVersion) );
                        }
                    }
                }).initialize();
    }
}
