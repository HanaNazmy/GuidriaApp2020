package com.example.guidrian;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {
    TextView fullName,email,phone;
    Button logoutBtn;
    @Override
    public View onCreateView( final LayoutInflater inflater,final ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view =  inflater.inflate(R.layout.fragment_profile,container,false);
        phone = view.findViewById(R.id.ProfilePhone);
        fullName = view.findViewById(R.id.ProfileName);
        email = view.findViewById(R.id.ProfileEmail);
        logoutBtn = view.findViewById(R.id.Logout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(),Register.class));
                getActivity().finish();
            }
        });
        return view;
    }


    public void getData(String fullName,String phone,String email)
    {
        this.phone.setText(phone);
        this.fullName.setText(fullName);
        this.email.setText(email);
    }
}