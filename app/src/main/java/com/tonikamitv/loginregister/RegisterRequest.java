package com.tonikamitv.loginregister;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String TAG = "RegisterRequest";
    private static final String REGISTER_REQUEST_URL = "http://10.128.2.19/pb4c/registerUser.php";


    private Map<String, String> params;

    public RegisterRequest(String firstName, String lastName, String email, String password, Response.Listener<String> listener) {
        //Using Test URL
        super(Method.POST, REGISTER_REQUEST_URL, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.getMessage());
            }
        });
        params = new HashMap<>();
        params.put("userFirstName", firstName);
        params.put("userLastName", lastName);
        params.put("userEmail", email);               //original "name", "age", "username", "password"
        params.put("userPassword", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
