package sg.edu.np.mad.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    ArrayList<User> data;
    ListActivity listActivity;

    //Creating/declare an instance of AlertD Dialog
    AlertDialog.Builder profile;


    public UserAdapter(ArrayList<User> data, ListActivity listActivity) {
        this.data = data;
        this.listActivity = listActivity; //pass in List Activity to be stored here
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(
            ViewGroup parent,
            int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_user_obj,
                parent,
                false);
        //Inflater is used to open the activity / xml file


        //since you create the View item, as a variable you can then access the activity
        //so you set an onClick listener, to listen to when the activity is clicked
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                //thus here you create an instance of alert dialog to attach to the view
                AlertDialog alert = profile.create();
                alert.show();
            }
        });
        //to set onClickListener you can do .setOnClickListener(new <tab>)

        return new UserViewHolder(item);
    }

    //This Method Binds the Data to the ViewHolder(to recycler view). (Binds the Data to Holder in Activity_user_obj.xml)
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder,
                                 int position) {
        //Here we have get the object and access the attribute to set the name

        User s = data.get(position);
        int lastNameDigit =  Integer.valueOf(s.name.substring(s.name.length() - 1));
        //This will get the last digit of the name, and if it contains 7 we will perform some actions
        //First we access the last char of String, Then we convert the value to an int

        if(lastNameDigit != 7 ){
            holder.userName.setText("Name" + s.name); //holder is the view, hence you access the view and set in the attribute name of the obj
            holder.userDesc.setText("Description " + s.description);
        }else{
            holder.userName.setText("Seven" + s.name); //holder is the view, hence you access the view and set in the attribute name of the obj
            holder.userDesc.setText("Seven " + s.description);

        }
        //^^^Thus HERE is the Binding the Data to the view holder, to be displayed on the RecyclerView



        //Below here We make the Alert Dialog
        //*** Here we initalise the Alert Dialog we have already declared above
        profile = new AlertDialog.Builder(listActivity);
        profile.setTitle("Profile");
        profile.setMessage("Name" + s.name); //here is to display the random user name obj in the Alert Dialog
        profile.setCancelable(false);
        profile.setPositiveButton("View", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent myIntent = new Intent(listActivity, MainActivity.class);

                myIntent.putExtra("user_name", s.name);
                myIntent.putExtra("user_desc", s.description );
                listActivity.startActivity(myIntent);

            }
        });
        profile.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                //no action yet
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
//end of adapter class

