package com.youngerhousea.simplereader.fragment.collection;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.android.material.snackbar.Snackbar;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseDialogFragment;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;
import com.youngerhousea.simplereader.databinding.DialogFragmentDeleteBinding;
import com.youngerhousea.simplereader.viewmodel.RssEditViewModel;

public class DeleteDialogFragment extends BaseDialogFragment<DialogFragmentDeleteBinding, RssEditViewModel> {
    @Override
    public int getBindingViewModel() {
        return BR.rssEditViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_fragment_delete;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        final DeleteDialogFragmentArgs deleteDialogFragmentArgs = DeleteDialogFragmentArgs.fromBundle(savedInstanceState);
        Group group = deleteDialogFragmentArgs.getGroup();
        RssUrl rssUrl = deleteDialogFragmentArgs.getRssUrl();

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(dataBinding.getRoot())
                .setPositiveButton(R.string.dialog_global_determine, (dialog, which) -> {
                    if(rssUrl == null) {
                        viewModel.deleteGroup(group);
                    } else {
                        viewModel.deleteRssUrl(rssUrl);
                    }
                    Snackbar.make(view, R.string.success_delete, Snackbar.LENGTH_SHORT);
                })
                .setNegativeButton(R.string.dialog_global_cancel, (dialog, which) -> {
                    dialog.cancel();
                });
        return builder.create();
    }
}
