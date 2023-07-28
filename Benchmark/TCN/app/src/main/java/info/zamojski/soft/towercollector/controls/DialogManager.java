/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.controls;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;
import org.sufficientlysecure.htmltextview.OnClickATagListener;

import info.zamojski.soft.towercollector.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

public class DialogManager {

    public static AlertDialog createHtmlInfoDialog(Context context, int titleId, int messageId, boolean largeText, boolean textIsSelectable) {
        return createHtmlInfoDialog(context, titleId, messageId, null, largeText, textIsSelectable, null, null);
    }

    public static AlertDialog createHtmlInfoDialog(Context context, int titleId, String message, boolean largeText, boolean textIsSelectable) {
        return createHtmlInfoDialog(context, titleId, null, message, largeText, textIsSelectable, null, null);
    }

    public static AlertDialog createHtmlInfoDialog(Context context, int titleId, String message, boolean largeText, boolean textIsSelectable, Integer negativeActionTextId, DialogInterface.OnClickListener negativeAction) {
        return createHtmlInfoDialog(context, titleId, null, message, largeText, textIsSelectable, negativeActionTextId, negativeAction);
    }

    private static AlertDialog createHtmlInfoDialog(Context context, int titleId, Integer messageId, String message, boolean largeText, boolean textIsSelectable, Integer negativeActionTextId, DialogInterface.OnClickListener negativeAction) {
        if (messageId == null && message == null)
            throw new IllegalArgumentException("MessageId or message values is required");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogLayout = inflater.inflate(R.layout.html_information_dialog, null);
        builder.setView(dialogLayout);
        builder.setPositiveButton(R.string.dialog_ok, null);
        if (negativeActionTextId != null && negativeAction != null) {
            builder.setNegativeButton(negativeActionTextId, negativeAction);
        }

        builder.setTitle(titleId);
        HtmlTextView messageView = (HtmlTextView) dialogLayout.findViewById(R.id.html_info_dialog_textview);
        messageView.setTextAppearance(context, (largeText ? android.R.style.TextAppearance_Medium : android.R.style.TextAppearance_Small));
        if (messageId != null) {
            messageView.setHtml(messageId, new HtmlResImageGetter(context));
        } else {
            messageView.setHtml(message, new HtmlResImageGetter(context));
        }
        // don't move above setting the content because it won't work
        messageView.setTextIsSelectable(textIsSelectable);
        messageView.setOnClickATagListener(new OnClickATagListener() {
            @Override
            public boolean onClick(View widget, String spannedText, @Nullable String href) {
                return false;
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    public static AlertDialog createConfirmationDialog(Context context, int titleId, int messageId, DialogInterface.OnClickListener confirmedAction) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setPositiveButton(R.string.dialog_proceed, confirmedAction);
        builder.setNegativeButton(R.string.dialog_cancel, null);

        builder.setTitle(titleId);
        builder.setMessage(messageId);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }
}
