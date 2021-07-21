package pe.edu.upeu.modelo;

import lombok.Data;

@Data
public class VentaTO {
    //IdVenta	idDNI	fechaVenta	netoTotal	igv	precioTotal
    public String idVenta, idDni, fechaVenta;
    public double netoTotal, igv, precioTotal;


}
