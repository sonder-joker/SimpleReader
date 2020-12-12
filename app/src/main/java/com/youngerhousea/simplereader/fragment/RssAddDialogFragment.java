package com.youngerhousea.simplereader.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseDialogFragment;
import com.youngerhousea.simplereader.viewmodel.RssAddViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RssAddDialogFragment extends BaseDialogFragment<RssAddViewModel> {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_rss_add_title, null))
                .setPositiveButton(R.string.dialog_rss_add_determine, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.insertGroup();
                    }
                })
                .setNegativeButton(R.string.dialog_rss_add_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
