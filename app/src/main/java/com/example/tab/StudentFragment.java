package com.example.tab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StudentFragment extends Fragment
{
    private static final String STUDENTS_LIST = "students_list";
    private List<Student> students;

    public static StudentFragment newInstance( List<Student> students )
    {
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();
        args.putSerializable( STUDENTS_LIST, new ArrayList<>( students ) );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        if ( getArguments() != null )
        {
            students = (List<Student>) getArguments().getSerializable( STUDENTS_LIST );
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        MainActivity mainActivity = (MainActivity) requireActivity();
        View view = inflater.inflate( R.layout.fragment_student, container, false );
        RecyclerView recyclerView = view.findViewById( R.id.recyclerView );
        recyclerView.setAdapter( new StudentAdapter(
                students,
                () ->
                {

                  Log.i( "LinLi", "right" );
                  mainActivity.setIndex( mainActivity.getIndex() + 1 );

                },
                () ->
                {
                    Log.i( "LinLi", "left" );
                  mainActivity.setIndex( mainActivity.getIndex() - 1 );
                } ) );

        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
        recyclerView.setFocusable( true );

        return view;
    }

}