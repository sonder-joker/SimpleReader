package com.youngerhousea.simplereader.fragment.collection;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.android.material.snackbar.Snackbar;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseDialogFragment;
import com.youngerhousea.simplereader.databinding.DialogFragmentRssAddBinding;
import com.youngerhousea.simplereader.utils.Utils;
import com.youngerhousea.simplereader.viewmodel.AddGroupViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddGroupDialogFragment extends BaseDialogFragment<DialogFragmentRssAddBinding, AddGroupViewModel> {

    @Override
    public int getBindingViewModel() {
        return BR.addGroupViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_fragment_rss_add;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(dataBinding.getRoot())
                .setPositiveButton(R.string.dialog_rss_add_determine, (dialog, which) -> {
                    final String groupToAdd = viewModel.groupToAdd.getValue();
                    if (Utils.isNotNullOrEmpty(groupToAdd))
                        viewModel.insertGroup();
                    else
                        Snackbar.make(view, R.string.cannot_add_empty, Snackbar.LENGTH_SHORT).show();
                })
                .setNegativeButton(R.string.dialog_rss_add_cancel, (dialog, which) -> dialog.cancel());

        return builder.create();
    }
}
