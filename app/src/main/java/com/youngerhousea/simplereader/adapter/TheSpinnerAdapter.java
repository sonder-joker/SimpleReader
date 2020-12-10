package com.youngerhousea.simplereader.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


@BindingMethods({
        @BindingMethod(type = Spinner.class, attribute = "onItemClick", method = "setOnItemClickListener"),
        @BindingMethod(type = Spinner.class, attribute = "onItemLongClick", method = "setOnItemLongClickListener"),
        @BindingMethod(type = Spinner.class, attribute = "spinnerEntries", method = "setSpinnerEntries")
})
@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "selectedItemPosition"),
        @InverseBindingMethod(type = Spinner.class, attribute = "selection",
                method = "getSelectedItemPosition",
                event = "selectedItemPositionAttrChanged"),
})
public class TheSpinnerAdapter {
    @BindingAdapter("spinnerEntries")
    public static void setSpinnerEntries(@NotNull Spinner spinner, List<?> entries) {
        ArrayAdapter<?> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item, entries == null ? new ArrayList<>() : entries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @BindingAdapter("selectedItemPosition")
    public static void setSelectedItemPosition(@NotNull Spinner spinner, int position) {
        if (spinner.getSelectedItemPosition() != position) {
            spinner.setSelection(position);
        }
    }

    @BindingAdapter("selection")
    public static void setSelection(Spinner view, int position) {
        setSelectedItemPosition(view, position);
    }

    @BindingAdapter({"selectedItemPosition", "adapter"})
    public static void setSelectedItemPosition(@NotNull Spinner view, int position, android.widget.SpinnerAdapter adapter) {
        if (adapter != view.getAdapter()) {
            view.setAdapter(adapter);
            view.setSelection(position);
        } else if (view.getSelectedItemPosition() != position) {
            view.setSelection(position);
        }
    }

    @BindingAdapter({"selection", "adapter"})
    public static void setSelection(Spinner view, int position, android.widget.SpinnerAdapter adapter) {
        setSelectedItemPosition(view, position, adapter);
    }

    @BindingAdapter(value = {"onItemSelected", "onNothingSelected",
            "selectedItemPositionAttrChanged"}, requireAll = false)
    public static void setOnItemSelectedListener(Spinner view, final OnItemSelected selected,
                                                 final OnNothingSelected nothingSelected, final InverseBindingListener attrChanged) {
        if (selected == null && nothingSelected == null && attrChanged == null) {
            view.setOnItemSelectedListener(null);
        } else {
            view.setOnItemSelectedListener(
                    new OnItemSelectedComponentListener(selected, nothingSelected, attrChanged));
        }
    }

    public static class OnItemSelectedComponentListener implements AdapterView.OnItemSelectedListener {
        private final OnItemSelected mSelected;
        private final OnNothingSelected mNothingSelected;
        private final InverseBindingListener mAttrChanged;

        public OnItemSelectedComponentListener(OnItemSelected selected,
                                               OnNothingSelected nothingSelected, InverseBindingListener attrChanged) {
            this.mSelected = selected;
            this.mNothingSelected = nothingSelected;
            this.mAttrChanged = attrChanged;
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (mSelected != null) {
                mSelected.onItemSelected(parent, view, position, id);
            }
            if (mAttrChanged != null) {
                mAttrChanged.onChange();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            if (mNothingSelected != null) {
                mNothingSelected.onNothingSelected(parent);
            }
            if (mAttrChanged != null) {
                mAttrChanged.onChange();
            }
        }
    }

    public interface OnItemSelected {
        void onItemSelected(AdapterView<?> parent, View view, int position, long id);
    }

    public interface OnNothingSelected {
        void onNothingSelected(AdapterView<?> parent);
    }

}
