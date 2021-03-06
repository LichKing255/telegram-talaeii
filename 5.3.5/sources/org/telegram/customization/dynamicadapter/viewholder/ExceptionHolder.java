package org.telegram.customization.dynamicadapter.viewholder;

import android.app.Activity;
import android.view.ViewGroup;
import org.ir.talaeii.R;
import org.telegram.customization.dynamicadapter.DynamicAdapter;
import org.telegram.customization.dynamicadapter.annotations.ViewHolderType;
import org.telegram.customization.dynamicadapter.data.ExceptionData;
import org.telegram.customization.dynamicadapter.data.ExtraData;
import org.telegram.customization.dynamicadapter.data.ObjBase;

@ViewHolderType(model = ExceptionData.class, type = 111)
public class ExceptionHolder extends HolderBase {
    public ExceptionHolder(Activity activity, ViewGroup viewGroup, DynamicAdapter adapter, ExtraData extraData) {
        super(activity, viewGroup, R.layout.sls_exception, adapter, extraData);
    }

    public void onBind(ObjBase obj) {
    }

    public void itemClicked(ObjBase obj) {
    }
}
