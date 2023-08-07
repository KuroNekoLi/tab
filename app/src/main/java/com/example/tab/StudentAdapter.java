package com.example.tab;

import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> students;
    private Runnable onKeyRight;
    private Runnable onKeyLeft;

    public StudentAdapter(List<Student> students,Runnable onKeyRight,Runnable onKeyLeft) {
        this.students = students;
        this.onKeyRight = onKeyRight;
        this.onKeyLeft = onKeyLeft;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bind( position );
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView studentId;

        StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            studentId = itemView.findViewById(R.id.student_id);
        }
        void bind(int position){
            Student student = students.get(position);
            studentName.setText(student.getName());
            itemView.setOnClickListener( view -> Toast.makeText( view.getContext(), "item clicked", Toast.LENGTH_SHORT ).show() );
            itemView.setOnFocusChangeListener((view, hasFocus) -> {
                if (hasFocus) {
                    studentName.setTextColor(Color.BLUE);
                } else {
                    studentName.setTextColor(Color.BLACK);
                }
            });
            itemView.setOnKeyListener( new View.OnKeyListener()
            {
                @Override
                public boolean onKey( View view, int i, KeyEvent keyEvent )
                {
                    if ( keyEvent.getAction() == KeyEvent.ACTION_DOWN ){
                        if ( i == KeyEvent.KEYCODE_DPAD_RIGHT ){
                            onKeyRight.run();
                        }else if ( i == KeyEvent.KEYCODE_DPAD_LEFT ){
                            onKeyLeft.run();
                        }
                    }
                    return false;
                }
            } );
        }
    }
}
