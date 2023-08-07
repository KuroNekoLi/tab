package com.example.tab;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    private static final String STUDENTS_LIST = "students_list";
    private List<Student> students;

    public static StudentFragment newInstance(List<Student> students) {
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();
        args.putSerializable(STUDENTS_LIST, new ArrayList<>(students));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            students = (List<Student>) getArguments().getSerializable(STUDENTS_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new StudentAdapter(students));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setFocusable(true);
        recyclerView.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View view, int i, KeyEvent keyEvent )
            {
                if ( keyEvent.getAction() == KeyEvent.ACTION_DOWN ){
                    if ( i == KeyEvent.KEYCODE_DPAD_RIGHT ){
                        Toast.makeText( getContext(), "right", Toast.LENGTH_SHORT ).show();
                    }
                    return true;
                }
                return false;
            }
        } );
        return view;
    }
}