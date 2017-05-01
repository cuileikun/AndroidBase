package com.cuileikun.androidbase.activity.nine;

import android.app.Activity;
import android.os.Bundle;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.bean.Contacts;
import com.cuileikun.androidbase.utils.ReadContactUtils;

import java.util.List;

/**
 * Created by Admin on 2017/4/29.
 */

public class SearchContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);


        List<Contacts> readContacts = ReadContactUtils.readContact(getApplicationContext());
        for (Contacts contact : readContacts) {
            System.out.println("contact:"+contact);
        }

    }
}
