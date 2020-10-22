package com.example.guardadodatospermanentes;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.GregorianCalendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoHora extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
CuandoEsteSeleccionadaLaHora miHora;
    @Override
    public void onTimeSet(TimePicker timePicker, int hora, int minutos) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(GregorianCalendar.HOUR,hora);
        gregorianCalendar.set(GregorianCalendar.MINUTE, minutos);
        miHora.enSeleccion(gregorianCalendar);


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int hora = gregorianCalendar.get(GregorianCalendar.HOUR);
        int minutos = gregorianCalendar.get(GregorianCalendar.MINUTE);
        return new TimePickerDialog(getActivity(),this, hora , minutos, true);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        miHora = (CuandoEsteSeleccionadaLaHora) context;
        super.onAttach(context);
    }

    public interface CuandoEsteSeleccionadaLaHora{
        public void enSeleccion(GregorianCalendar hora);
    }

}
