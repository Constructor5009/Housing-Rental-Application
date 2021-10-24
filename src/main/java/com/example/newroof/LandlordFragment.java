package com.example.newroof;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class LandlordFragment extends Fragment {
//    private static final int RESULT_OK = 1;
    EditText ed1,ed2,ed3;
//    ImageView iv;
//    Uri imageuri;
    Button reg,ell;
//    public static final int PICK_IMAGE = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_landlord, container,false);

        ed1 = (EditText) v.findViewById(R.id.entername);
        ed2 = (EditText) v.findViewById(R.id.enteraddress);
        ed3 = (EditText) v.findViewById(R.id.enterphone);
        reg = (Button) v.findViewById(R.id.reg);
        ell = (Button) v.findViewById(R.id.ell);
//        iv = (ImageView) v.findViewById(R.id.img);

//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gallery = new Intent();
//                gallery.setType("image/*");
//                gallery.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(gallery,"Select Picture"),PICK_IMAGE);
//            }
//        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),houselist.class);
//                i.putExtra("Name", String.valueOf(ed1));
//                i.putExtra("Address", String.valueOf(ed2));
//                i.putExtra("Phone", String.valueOf(ed3));
                startActivity(i);
            }
        });
        ell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),houselist.class);
                startActivity(i);
            }
        });

        return v;
    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
//            imageuri = data.getData();
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver())
//            }
//        }
//    }
}
