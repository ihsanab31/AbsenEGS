
package com.ofal.ihsan.absensiegs.util.barcode;

import android.content.Context;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;
/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on 18/07/2018
 * ------------------------------
 * This class for
 */
class BarcodeTracker extends Tracker<Barcode> {
    private BarcodeGraphicTrackerCallback mListener;

    public interface BarcodeGraphicTrackerCallback {
        void onDetectedQrCode(Barcode barcode);
    }

    BarcodeTracker(Context listener) {
        mListener = (BarcodeGraphicTrackerCallback) listener;
    }

    @Override
    public void onNewItem(int id, Barcode item) {
        if (item.displayValue != null) {
            mListener.onDetectedQrCode(item);
        }
    }
}
