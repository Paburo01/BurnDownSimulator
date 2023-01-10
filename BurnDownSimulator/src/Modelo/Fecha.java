package Modelo;

import java.util.Scanner;

public final class Fecha implements Cloneable {
    private int dia;
    private int mes;
    private int anio;
    
    public Fecha() {
        this.dia=0;
        this.mes=0;
        this.anio=0;
    }
    
    public Fecha(final int dia, final int mes, final int anio) {
        this.setFecha(dia, mes, anio);
    }
    
    public int getNumDiasTotales() {
    	int total = 0;
    	final int[] maxDias = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    	total += anio * 365;
    	for (int i = 1; i <= mes; i++)
    		total += maxDias[i];
    	total += dia;
    	return total;
    }
    
    public Fecha(final Fecha f) {
        this(f.dia, f.mes, f.anio);
    }
    
    public int getDia() {
        return this.dia;
    }
    
    public int getMes() {
        return this.mes;
    }
    
    public int getAnio() {
        return this.anio;
    }
    
    public void setDia(final int dia) {
        this.dia = dia;
    }
    
    public void setMes(final int mes) {
        this.mes = mes;
    }
    
    public void setAnio(final int anio) {
        this.anio = anio;
    }
    
    public void setFecha(final int dia, final int mes, final int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = Math.abs(anio);
        if (mes < 1) {
            this.mes = 1;
        }
        else if (mes > 12) {
            this.mes = 12;
        }
        final int[] maxDias = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (dia < 1) {
            this.dia = 1;
        }
        else if (dia > maxDias[this.mes]) {
            this.dia = maxDias[this.mes];
        }
    }
    
    public Fecha diaSig() {
        Fecha fecha;
        fecha = (Fecha)this.clone();
        fecha.dia++;
        final int[] maxDias = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (fecha.dia > maxDias[fecha.mes]) {
        	fecha.dia = 1;
        	fecha.mes++;
        	if (fecha.mes > 12) {
        		fecha.mes = 1;
        		fecha.anio++;
        	}
        }
        return fecha;
    }
    
    public static boolean mayor(final Fecha f1, final Fecha f2) {
        return f1.anio > f2.anio || (f1.anio == f2.anio && f1.mes > f2.mes) || (f1.anio == f2.anio && f1.mes == f2.mes && f1.dia > f2.dia);
    }
    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%02d", this.dia, this.mes, this.anio);
    }
    
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        }
        catch (CloneNotSupportedException ex) {}
        return obj;
    }
    
    public void ver() {
        System.out.println(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Fecha)) {
            return false;
        }
        final Fecha f = (Fecha)o;
        return this.dia == f.dia && this.mes == f.mes && this.anio == f.anio;
    }
}

