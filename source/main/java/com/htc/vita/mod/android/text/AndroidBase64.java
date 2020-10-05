package com.htc.vita.mod.android.text;

import com.htc.vita.core.log.Logger;
import com.htc.vita.core.text.Base64;
import com.htc.vita.core.text.Base64Option;

public class AndroidBase64 extends Base64 {
    @Override
    protected byte[] onDecode(
            String data,
            Base64Option base64Option) {
        if (base64Option == Base64Option.Basic) {
            return android.util.Base64.decode(
                    data,
                    android.util.Base64.DEFAULT
            );
        }
        if (base64Option == Base64Option.Mime) {
            return android.util.Base64.decode(
                    data,
                    android.util.Base64.CRLF
            );
        }
        if (base64Option == Base64Option.UrlSafe) {
            return android.util.Base64.decode(
                    data,
                    android.util.Base64.NO_PADDING
                            | android.util.Base64.NO_WRAP
                            | android.util.Base64.URL_SAFE
            );
        }
        Logger.getInstance(AndroidBase64.class.getSimpleName()).error("Can not find available implementation");
        return null;
    }

    @Override
    protected String onEncodeToString(
            byte[] data,
            Base64Option base64Option) {
        if (base64Option == Base64Option.Basic) {
            return android.util.Base64.encodeToString(
                    data,
                    android.util.Base64.NO_WRAP
            );
        }
        if (base64Option == Base64Option.Mime) {
            return android.util.Base64.encodeToString(
                    data,
                    android.util.Base64.CRLF
            );
        }
        if (base64Option == Base64Option.UrlSafe) {
            return android.util.Base64.encodeToString(
                    data,
                    android.util.Base64.NO_PADDING
                            | android.util.Base64.NO_WRAP
                            | android.util.Base64.URL_SAFE
            );
        }
        Logger.getInstance(AndroidBase64.class.getSimpleName()).error("Can not find available implementation");
        return null;
    }
}
