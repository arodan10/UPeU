package pe.edu.upeu.modelo;

import lombok.Data;

@Data
public class VentaDetalleTO {
    //IdVEntaDetalle	IdVenta	IdProducto	precioUnit	porceUtil	cantidad	netoTotal
    public String idVentaDetalle,idVenta, idProducto;
    public double precioUnit, porcentUtil, cantiad, precioTotal;

}
