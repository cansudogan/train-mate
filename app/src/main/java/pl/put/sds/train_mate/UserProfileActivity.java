package pl.put.sds.train_mate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserProfileActivity extends AppCompatActivity {

    private TextView tv_test_user_profil_query;
    private User user;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        FirebaseApp.initializeApp(this);

        // I just put a textview inside this activity in order for you to read the data from the database.
        // When you will create the real UI feel free to remove this one
        // In order to modify the UI open the file located in: app/res/layout/activity_userprofile or create an other one and modify the parameter of the
        // setContentView method above.

        tv_test_user_profil_query = (TextView) findViewById(R.id.tv_test_user_profil_query);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //createFakeUser();
        fetchUserDatas();

    }

    private void fetchUserDatas(){

        //For now we use an hardcoded userID, for the real app we will get this id from the mapActivity.
        //If you want to try a second one you can use this one: "e2bhkPPkXrYbD5CVfH4VblqsKbx1"

        String testUserID = "5TXtEiPZDJfWwjzd4xLLm9ybryq1";


        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(testUserID);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);

                //Now you can use the user object to show the user detail inside the activity, you can get the user info like i did bellow

                String description = "firstName = "+user.firsName +"\nlastName = "+user.lastName +"\nage = "+user.age +"\nlatitude = "+user.latitude +"\nlongitude = "+user.longitude +"\nsportTags = " + user.sportTags.toString() +"\ngender = "+user.gender +"\npictureURL = "+user.pictureURL;
                tv_test_user_profil_query.setText(description);
                Log.d("USER FROM DB", dataSnapshot.toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                String value = databaseError.toString();
                Log.e("ERROR FROM DB", value);
            }
        });

    }

    private void createFakeUser(){

        //Do not use this method
        //This method will be removed in the future it is just for me to enter some values inside the database easily.

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        ArrayList<String> sportTags = new ArrayList();
        sportTags.add("running");
        sportTags.add("trail");
        sportTags.add("formula 1");
        User user = new User("Lewis","Hamilton","https://firebasestorage.googleapis.com/v0/b/sds-put.appspot.com/o/profilePictures%2Flewis.jpg?alt=media&token=f18d0588-3bd2-4739-b386-0b8215d81178","M", sportTags,48.852966,2.349902,473900400);
        databaseReference.child("5TXtEiPZDJfWwjzd4xLLm9ybryq1").setValue(user);

    }

}
