package com.youngerhousea.simplereader.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddGroupFragment extends DialogFragment {
    public interface NoticeDiaLogListener{
        public void onDialogPositiveClick(DialogFragment dialogFragment);
        public void onDialogNegativeClick();
    }
    NoticeDiaLogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        return builder.create();
    }
}
