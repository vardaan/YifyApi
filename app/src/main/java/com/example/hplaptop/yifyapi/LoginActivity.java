package com.example.hplaptop.yifyapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.ApiClient;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import models.LoginResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LoginActivity extends ActionBarActivity {

    private static final String TAG = "LoginActivity";
    @InjectView(R.id.et_uname_login)
    EditText mUnameEt;
    @InjectView(R.id.et_pass_login)
    EditText mPassEt;
    @InjectView(R.id.bt_login)
    Button mLoginBtn;
    private Context mContext;
    SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        mContext = this.getApplicationContext();

        //Getting the shared prefs
        mSharedPref = mContext.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

    }

    @OnClick(R.id.bt_login)
    public void OnClick() {
        //validate the fields in case of success this will call login api
        validateFields();
    }

    private void validateFields() {
        String uName = mUnameEt.getText().toString().trim();
        String pass = mPassEt.getText().toString().trim();

        //Check against empty username
        if (uName.isEmpty())
            mUnameEt.setError("Username cannot be empty");
            //check against empty password
        else if (pass.isEmpty())
            mPassEt.setError("Password cannot be empty");
            //Call the login services
        else {
            // call the Api's to intialiate register process
            ApiClient.getYifyApiClient().LoginUser(uName, pass, new Callback<LoginResponse>() {
                @Override
                public void success(LoginResponse r, Response response) {
                    Toast.makeText(mContext, r.getUserID(), Toast.LENGTH_LONG).show();

                    //Store user's credentials inside the shared prefs for future use
                    mSharedPref.edit().putString(getString(R.string.user_pref_hash), r.getHash()).apply();
                    mSharedPref.edit().putString(getString(R.string.user_pref_uname), r.getUsername()).apply();
                    mSharedPref.edit().putString(getString(R.string.user_pref_id), r.getUserID()).apply();

                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.d(TAG, "Try after some time !!!!");
                }
            });

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
