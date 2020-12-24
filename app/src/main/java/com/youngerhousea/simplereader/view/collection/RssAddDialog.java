package com.youngerhousea.simplereader.view.collection;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.android.material.snackbar.Snackbar;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseDialogFragment;
import com.youngerhousea.simplereader.databinding.DialogRssAddBinding;
import com.youngerhousea.simplereader.utils.Utils;
import com.youngerhousea.simplereader.viewmodel.CollectionViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RssAddDialog extends BaseDialogFragment<DialogRssAddBinding, CollectionViewModel> {

    @Override
    public int getBindingViewModel() {
        return BR.collectionViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_rss_add;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(dataBinding.getRoot())
                .setPositiveButton(R.string.dialog_global_determine, (dialog, which) -> {
                    final String groupToAdd = viewModel.groupToAdd.getValue();
                    if (Utils.isNotNullOrEmpty(groupToAdd)) {
                        viewModel.insertGroup();
                        Snackbar.make(view, R.string.success_add, Snackbar.LENGTH_SHORT).show();
                    } else
                        Snackbar.make(view, R.string.cannot_add_empty, Snackbar.LENGTH_SHORT).show();
                })
                .setNegativeButton(R.string.dialog_global_cancel, (dialog, which) -> dialog.cancel());

        return builder.create();
    }
}
