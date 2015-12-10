package com.example.shana.webintentcaster;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by shana on 2015/12/10.
 */
public class IntentFactory {
    public static Intent getIntent(String intentType, String inputString) throws Exception {
        if (intentType.equals("android.intent.action.VIEW")) {
            return getViewIntent(inputString);
        }
        if (intentType.equals("android.intent.action.WEB_SEARCH")) {
            return getBrowseSearchIntent(inputString);
        }
        if (intentType.equals("android.intent.action.CALL")) {
            return getCallIntent(inputString);
        }
        if (intentType.equals("android.intent.action.DIAL")) {
            return getDialIntent(inputString);
        }
        throw new Exception("IntentFactory getIntent unknown intent type");
    }

    private static Intent getViewIntent(String url) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    }

    private static Intent getBrowseSearchIntent(String keyWord) {
        return new Intent(Intent.ACTION_WEB_SEARCH).putExtra(SearchManager.QUERY, keyWord);
    }

    private static Intent getCallIntent(String phoneNumber) {
        return new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + phoneNumber));
    }

    private static Intent getDialIntent(String phoneNumber) {
        return new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:" + phoneNumber));
    }
}
