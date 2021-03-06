package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        // *** CREATE 20 random user obj to be displayed in recycler view
        ArrayList<User> userObjList = new ArrayList<User>();
        //List to store use_obj

        String nameNum;
        String descNum;
        boolean followed;
        for(int i=0; i<20; i++){
            Random random = new Random();

            //Creating obj name
            int name = random.nextInt((1000000000+1000000000) - 1000000000);
            nameNum = Integer.toString(name); //as name is a string in the Obj we must convert it
            //nameNum = "Name" + Integer.toString(name); , previously i wrote this, however, this is bad
            //as it will append to the variable and when creating the obj, will be set into the attribute hence its bad.

            //Creating obj description
            int desc = random.nextInt(1000000000);
            descNum = Integer.toString(desc);

            //Creating Random num for Followed
            int randomNum = random.nextInt(2);

            if (randomNum == 1){
                followed = true;
            }else{
                followed = false;
            }

            User random_userObj = new User(nameNum, descNum, desc, followed );
            userObjList.add(random_userObj);
            //for the Id of user obj, i let it follow the number of desc's random number
            //the followed attribute for the user obj, is based on the random num
        }



        // *** Accessing the RecyclerView and passing in Obj list to be displayed
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter mAdapter =
                new UserAdapter(userObjList, this); //here i'm passing in the current activty

        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    public void onImageViewClick (View view){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        //setting the attributes in an Alert Dialog
//        builder.setTitle("Profile");
//        builder.setMessage("MADness");
//        builder.setCancelable(false);  //determines if the Alert Dialog disappear when pressed on anywhere of the screen
//        builder.setPositiveButton("Close", new DialogInterface.OnClickListener(){
//            public void onClick(DialogInterface dialog, int id){
//		        //<action>
//            }
//        });
//        builder.setNegativeButton("View", new DialogInterface.OnClickListener(){
//            public void onClick(DialogInterface dialog, int id){
//		        //<action> Random int generated, MainActivity launched, Random int sent over
//                Random random = new Random();
//                int randomNumber = random.nextInt(100-1) + 1; //random.nextInt(max???min) + min;
//
//                //intent created to sent Random int over
//                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
//                myIntent.putExtra("randomNum", randomNumber);
//                startActivity(myIntent);
//
//            }
//        });

        //Displaying the Alert Dialog
//        AlertDialog alert = builder.create();
//        alert.show();

    }
}