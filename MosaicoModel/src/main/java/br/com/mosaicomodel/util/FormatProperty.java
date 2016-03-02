package br.com.mosaicomodel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatProperty {

	public String formartarData(Date dataB){
		String dataz = "dd/MM/yyyy";
        SimpleDateFormat formatas = new SimpleDateFormat(dataz);
        String data = formatas.format(dataB);
		return data;
	}
	
	public String formartarDataHora(Date dataB){
		String dataz = "dd/MM/yyyy HH:mm";
        SimpleDateFormat formatas = new SimpleDateFormat(dataz);
        String data = formatas.format(dataB);
		return data;
	}
}
