package com.example.guardadodatospermanentes;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    CuandoSeleccioneLaFecha miFecha;

    @Override
    public void onDateSet(DatePicker datePicker, int año, int mes, int día) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(año, mes, día);
        miFecha.fechaSeleccionada(gregorianCalendar);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        int año  = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int día = calendario.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this,año,mes,día );
    }

    @Override
    public void onAttach(@NonNull Context context) {
        miFecha = (CuandoSeleccioneLaFecha) context;
        super.onAttach(context);
    }

    public interface CuandoSeleccioneLaFecha{
        public void fechaSeleccionada(GregorianCalendar fecha);
    }
}
