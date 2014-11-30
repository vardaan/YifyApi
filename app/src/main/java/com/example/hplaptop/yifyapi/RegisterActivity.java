package com.example.hplaptop.yifyapi;

import android.content.Context;
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
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import utilty.EmailValidator;


public class RegisterActivity extends ActionBarActivity {

    private static final String TAG = "RegisterActivity";
    Context mContext;
    @InjectView(R.id.et_uname_reg)
    EditText mEtUname;
    @InjectView(R.id.et_email_reg)
    EditText mEtEmail;
    @InjectView(R.id.et_pass_reg)
    EditText mEtPass;
    @InjectView(R.id.bt_register)
    Button mBtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = this.getApplicationContext();
        ButterKnife.inject(this);
    }

    @OnClick(R.id.bt_register)
    public void register() {
        validateFields();
    }

    private void validateFields() {
        String uName = mEtUname.getText().toString().trim();
        String pass = mEtPass.getText().toString().trim();
        String email = mEtEmail.getText().toString().trim();
        //     String errorMsg = "";

        // Validation checks
        if (uName.isEmpty())
            mEtUname.setError("Username should not be empty");
        else if (email.isEmpty())
            mEtEmail.setError("email should not be empty");
        else if (pass.isEmpty())
            mEtPass.setError("password should not be empty");
            //check the length of username

        else if (uName.length() < 3)
            mEtEmail.setError("Username should be 3 or more characters");
            //check the length of password
        else if (pass.length() < 6)
            mEtPass.setError("PassWord should be more than 6 characters");
            //check against invalid email address
        else if (!isValidEmail(email))
            mEtEmail.setError("Not a valid email address");
        else {

            // call the Api's to intialiate register process
            ApiClient.getYifyApiClient().registerUser(uName, email, pass, new Callback<String>() {
                @Override
                public void success(String s, Response response) {
                    Toast.makeText(mContext, s, Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.d(TAG, "Try after some time !!!!");
                }
            });
        }
    }

    private boolean isValidEmail(String email) {
        EmailValidator validator = new EmailValidator();
        return validator.validate(email);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
