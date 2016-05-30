package com.example.hd.fml.view.QiuNotes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hd.fml.R;
import com.example.hd.fml.constant.BaseFragment;

import butterknife.ButterKnife;


public class QiuNotesFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_qiu_notes, container, false);
        ButterKnife.bind(this, view);
        Log.i(TAG, "zzponCreateView: ");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
