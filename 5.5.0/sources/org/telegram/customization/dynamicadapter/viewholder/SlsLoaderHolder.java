package org.telegram.customization.dynamicadapter.viewholder;

import android.app.Activity;
import android.view.ViewGroup;
import org.ir.talaeii.R;
import org.telegram.customization.dynamicadapter.DynamicAdapter;
import org.telegram.customization.dynamicadapter.annotations.ViewHolderType;
import org.telegram.customization.dynamicadapter.data.ExtraData;
import org.telegram.customization.dynamicadapter.data.ObjBase;
import org.telegram.customization.dynamicadapter.data.SlsLoadingHelper;

@ViewHolderType(model = SlsLoadingHelper.class, type = 107)
public class SlsLoaderHolder extends HolderBase {
    public SlsLoaderHolder(Activity activity, ViewGroup viewGroup, DynamicAdapter dynamicAdapter, ExtraData extraData) {
        super(activity, viewGroup, R.layout.sls_loader_holder, dynamicAdapter, extraData);
    }

    public void itemClicked(ObjBase objBase) {
    }

    public void onBind(ObjBase objBase) {
    }
}
