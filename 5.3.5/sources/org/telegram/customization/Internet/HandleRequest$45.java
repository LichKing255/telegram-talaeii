package org.telegram.customization.Internet;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import java.lang.reflect.Type;
import java.util.Map;
import org.telegram.customization.Model.Payment.HostRequestData;
import utils.view.Constants;

class HandleRequest$45 implements HandleRequest$HandleInterface {
    final /* synthetic */ HandleRequest this$0;
    final /* synthetic */ String val$desc;
    final /* synthetic */ String val$paymentId;

    HandleRequest$45(HandleRequest this$0, String str, String str2) {
        this.this$0 = this$0;
        this.val$paymentId = str;
        this.val$desc = str2;
    }

    public RetryPolicy getRetryPolicy() {
        return null;
    }

    public void onResponse(BaseResponseModel object) {
        HostRequestData hostRequestData = (HostRequestData) object.getItems();
        if (hostRequestData != null) {
            HandleRequest.access$300(this.this$0).onResult(hostRequestData, 36);
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        HandleRequest.access$300(this.this$0).onResult(null, -36);
    }

    public Request getRequest() {
        return new BaseStringRequest(1, String.format(WebservicePropertis.WS_FAIL_PAYMENT, new Object[]{this.val$paymentId, this.val$desc}), this.this$0, this.this$0, HandleRequest.access$400(this.this$0), getSetKey()) {
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            public String getBodyContentType() {
                return "text/plain";
            }

            public byte[] getBody() throws AuthFailureError {
                return super.getBody();
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                return BaseStringRequest.getBulkRequestHeaders(this._context);
            }
        };
    }

    public boolean ignoreParsingResponse() {
        return false;
    }

    public Type getClassType() {
        return HostRequestData.class;
    }

    public String getSetKey() {
        return Constants.KEY_SETTING_PAYMENT_API;
    }

    public String toString() {
        return "WS_POST_T_M";
    }
}
