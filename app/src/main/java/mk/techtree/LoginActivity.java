package mk.techtree;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import mk.techtree.constatnts.AppConstants;
import mk.techtree.managers.SharedPreferenceManager;
import mk.techtree.models.UserModel;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.login_button)
    LoginButton btnFBLoginButton;


    private UserModel facebookProfile;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        callbackManager = CallbackManager.Factory.create();


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        if (isLoggedIn) {
            disconnectSocialNetworks();
        }


        btnFBLoginButton.setReadPermissions("email");
        // If using in a fragment
//        btnFBLoginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        btnFBLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                // App code

                AccessToken accessToken = loginResult.getAccessToken();
                fetchUserInfo(accessToken);
                Log.e("fb", accessToken.getUserId());

            }

            @Override
            public void onCancel() {
                // App code
                Log.e("fb", "on Cancel");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.e("fb", "on Error");
            }
        });

    }


    private void fetchUserInfo(AccessToken accessToken) {
        facebookProfile = new UserModel();
        if (accessToken != null) {
            GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                    if (jsonObject == null) {
                        return;
                    }
//                    onSocialInfoFetched(jsonObject);
                    Log.e("FbUserData", jsonObject.toString());
                    Gson gson = new Gson();
                    facebookProfile = gson.fromJson(jsonObject.toString(), UserModel.class);

                    // Uncomment below code to get picture

//                    profileTracker = new ProfileTracker() {
//                        @Override
//                        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
//                            Log.d("**", "onCurrentProfileChanged: "+ facebookProfile.picture);
//                            facebookProfile.picture = currentProfile.getProfilePictureUri(200, 200).toString();
//                        }
//                    };

//                    facebookProfile.picture = new String("https://graph.facebook.com/" + facebookProfile.fbID + "/picture?width=200&height=150");
//                    Log.i("profile_pic", facebookProfile.picture + "");
                    disconnectSocialNetworks();
                    fbLogin(facebookProfile);

                }
            });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id, email, name");
//            parameters.putString("fields", "id,first_name,last_name,email,hometown,name");
            request.setParameters(parameters);
            request.executeAsync();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void disconnectSocialNetworks() {
        logoutFromFacebook();
    }

    protected void logoutFromFacebook() {
        LoginManager.getInstance().logOut();
    }


    private void fbLogin(UserModel userModel) {

        disconnectSocialNetworks();

        // User is successfully logged in and saved in your Shared preferences. You can get User from Shared Preferences to use in your app.

        SharedPreferenceManager.getInstance(this).putObject(AppConstants.KEY_CURRENT_USER_MODEL, userModel);

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
