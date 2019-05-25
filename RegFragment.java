package com.example.mediacom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatViewInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegFragment extends Fragment {
    EditText Username,Email,Pass,Fname,Lname,Mobile,City,Address;
    Button btn;
    TextView textView;
    ApiInterface apiInterface;
    PrefConfig prefConfig;
    public RegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reg, container, false);
        Username = view.findViewById(R.id.username);
        Email = view.findViewById(R.id.mail);
        Pass = view.findViewById(R.id.pswrdd);
        Fname = view.findViewById(R.id.firstname);
        Lname = view.findViewById(R.id.lastname);
        Mobile = view.findViewById(R.id.mobphone);
        Address = view.findViewById(R.id.mobaddress);
        btn = view.findViewById(R.id.sup);
        textView = view.findViewById(R.id.lin);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, new LoginFragment()).addToBackStack(null).commit();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reg();
            }
        });
        return view;
    }
        public void Reg(){
         String username = Username.getText().toString();
         String email = Email.getText().toString();
         String pass = Pass.getText().toString();
         String fname = Fname.getText().toString();
         String lname = Lname.getText().toString();
         String mobile = Mobile.getText().toString();
         String address = Address.getText().toString();
         Call<User> call = MainActivity.apiInterface.performUserRegistration(email, username, pass, fname, lname, mobile, address);
    call.enqueue(new Callback<User>() {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {
            if(response.body().getResponse().equals("ok")){
                MainActivity.prefConfig.DisplayToast("Success");
            }

        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {
            Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
        }
    });
/*    Username.setText("");
    Email.setText("");
    Pass.setText("");
    Fname.setText("");
    Lname.setText("");
    Mobile.setText("");
    City.setText("");
    Address.setText("");*/



    }
}
